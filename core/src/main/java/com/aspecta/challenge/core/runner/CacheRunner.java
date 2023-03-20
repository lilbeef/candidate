package com.aspecta.challenge.core.runner;

import com.aspecta.challenge.core.service.ICandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CacheRunner implements ApplicationRunner {

    @Autowired
    private ICandidateService candidateService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        candidateService.initCache();
        log.info("人物缓存加载完成");
    }
}
