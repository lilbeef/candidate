package com.aspecta.challenge.server;

import com.aspecta.challenge.core.EnabledCore;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.aspecta.challenge"})
@EnabledCore
@MapperScan("com.aspecta.challenge.core.dao")
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
