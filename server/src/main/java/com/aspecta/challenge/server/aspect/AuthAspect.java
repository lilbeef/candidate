package com.aspecta.challenge.server.aspect;

import com.aspecta.challenge.io.dto.BaseDTO;
import com.aspecta.challenge.io.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: sxy
 * @Date: 2021/3/22 16:02
 */
@Aspect
@Component
@Slf4j
public class AuthAspect {


    @Pointcut("@annotation(com.aspecta.challenge.server.annonation.Auth)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void auth(JoinPoint point) throws ApiException {
        Object[] args = point.getArgs();
        String appid="";
        for (Object o : args) {
            if (o instanceof BaseDTO){
                appid=((BaseDTO) o).getAppid();
            }
        }
        if (!StringUtils.hasText(appid)||!appid.equals("sxy123456")){
            throw new ApiException("未登录或授权不正确！");
        }
    }


}


