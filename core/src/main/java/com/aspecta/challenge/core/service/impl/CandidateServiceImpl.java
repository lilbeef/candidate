package com.aspecta.challenge.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aspecta.challenge.core.dao.CandidateDao;
import com.aspecta.challenge.core.service.ICandidateService;
import com.aspecta.challenge.io.dto.CandidateQueryDTO;
import com.aspecta.challenge.io.vo.CandidateQueryVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: sxy
 * @Date: 2023/3/19 14:31
 */
@Service
@Slf4j
public class CandidateServiceImpl implements ICandidateService {

    @Autowired
    private CandidateDao candidateDao;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public List<CandidateQueryVO> getCandidatePage(CandidateQueryDTO candidateQueryDTO) {
        List<CandidateQueryVO> candidatePageFromCache = getCandidatePageFromCache(candidateQueryDTO);
        if (candidatePageFromCache.size() == candidateQueryDTO.getPage_size()) {
            return candidatePageFromCache;
        }
        log.info("未命中缓存，查询数据库");
        Page<CandidateQueryVO> page = new Page<>(candidateQueryDTO.getPage(), candidateQueryDTO.getPage_size());
        List<String> list = candidateDao.queryCandidatePage(candidateQueryDTO, page);
        List<CandidateQueryVO> records = list.stream().map(e -> {
                    CandidateQueryVO candidateQueryVO = JSONObject.parseObject(e, CandidateQueryVO.class);
                    redisTemplate.opsForZSet().add("candidates", e, candidateQueryVO.getMain_skill_score().doubleValue());
                    return candidateQueryVO;
                }
        ).collect(Collectors.toList());

        return records;
    }

    @Override
    public List<CandidateQueryVO> getCandidatePageFromCache(CandidateQueryDTO candidateQueryDTO) {
        Set<String> cache = redisTemplate.opsForZSet().reverseRangeByScore(candidateQueryDTO.getSkill_name(), Double.MIN_VALUE, Double.MAX_VALUE, candidateQueryDTO.getPage_size() * (candidateQueryDTO.getPage() - 1), candidateQueryDTO.getPage_size());
        return cache.stream().map(e -> JSONObject.parseObject(e, CandidateQueryVO.class)).collect(Collectors.toList());
    }

    @Override
    @Async
    public void initCache() {
        List<String> list = candidateDao.queryCandidatePage(new CandidateQueryDTO(), null);
        list.stream().map(e -> {
                    CandidateQueryVO candidateQueryVO = JSONObject.parseObject(e, CandidateQueryVO.class);
                    redisTemplate.opsForZSet().add("candidates", e, candidateQueryVO.getMain_skill_score().doubleValue());
                    return candidateQueryVO;
                }
        ).forEach(e->
                e.getRelated_skills().stream().forEach(n->
                        redisTemplate.opsForZSet().add(n.getName(), JSONObject.toJSONString(e), e.getMain_skill_score().doubleValue())
                ));
    }
}
