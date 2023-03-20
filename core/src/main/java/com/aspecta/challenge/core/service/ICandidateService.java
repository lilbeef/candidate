package com.aspecta.challenge.core.service;

/**
 * @Author: sxy
 * @Date: 2023/3/19 14:30
 */

import com.aspecta.challenge.io.dto.CandidateQueryDTO;
import com.aspecta.challenge.io.vo.CandidateQueryVO;

import java.util.List;

/**
 * 人员service
 */
public interface ICandidateService {

    /**
     * 分页查询人员分数和详情
     * @param candidateQueryDTO
     * @return
     */
    List<CandidateQueryVO> getCandidatePage(CandidateQueryDTO candidateQueryDTO);

    List<CandidateQueryVO> getCandidatePageFromCache(CandidateQueryDTO candidateQueryDTO);


    void initCache();
}
