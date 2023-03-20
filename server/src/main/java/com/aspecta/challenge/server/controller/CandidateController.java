package com.aspecta.challenge.server.controller;

import com.aspecta.challenge.core.service.ICandidateService;
import com.aspecta.challenge.io.dto.CandidateQueryDTO;
import com.aspecta.challenge.io.vo.CandidateQueryVO;
import com.aspecta.challenge.server.annonation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: sxy
 * @Date: 2023/3/19 13:00
 */
@RestController
public class CandidateController {
    @Autowired
    private ICandidateService candidateService;

    @PostMapping("/search_candidates")
    @Auth
    public List<CandidateQueryVO> getCandidatePage(@RequestBody CandidateQueryDTO candidateQueryDTO){
        List<CandidateQueryVO> candidatePage = candidateService.getCandidatePage(candidateQueryDTO);
        return candidatePage;
    }

}
