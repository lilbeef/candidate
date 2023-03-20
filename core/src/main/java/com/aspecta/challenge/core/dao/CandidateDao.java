package com.aspecta.challenge.core.dao;

import com.aspecta.challenge.io.dto.CandidateQueryDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: sxy
 * @Date: 2023/3/19 16:14
 */
@Repository
@Mapper
public interface CandidateDao {
    /**
     * 分页查询
     * @return
     */
    List<String> queryCandidatePage(@Param("param")CandidateQueryDTO candidateQueryDTO, Page page);


}
