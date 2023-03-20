package com.aspecta.challenge.server.controller;

import com.aspecta.challenge.core.service.ICandidateService;
import com.aspecta.challenge.io.dto.CandidateQueryDTO;
import com.aspecta.challenge.io.vo.CandidateQueryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: sxy
 * @Date: 2023/3/20 9:23
 */
@SpringBootTest
class CandidateControllerTest {
    @Autowired
    private ICandidateService candidateService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testCandidate(){
        CandidateQueryDTO database = CandidateQueryDTO.builder().skill_name("database").build();
        database.setPage(1l);
        database.setPage_size(5l);
        List<CandidateQueryVO> candidatePage = candidateService.getCandidatePage(database);

    }
}
