package com.aspecta.challenge.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author tangh
 * @version 1.0
 * date 2022/9/21
 **/

@ComponentScan("con.aspecta.challenge.core")
@EnableAsync
public @interface EnabledCore {
}
