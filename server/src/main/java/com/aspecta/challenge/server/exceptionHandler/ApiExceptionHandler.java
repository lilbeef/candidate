package com.aspecta.challenge.server.exceptionHandler;

import com.aspecta.challenge.io.exception.ApiException;
import com.aspecta.challenge.io.vo.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常类处理
 *
 * @author sxy
 */
@ResponseBody
@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public JSONResult errorHandle(Exception e){
        log.warn("error info " , e );

        return new JSONResult(9500,"系统内部错误");
    }

    @ExceptionHandler(value = ApiException.class)
    public JSONResult errorHandle(ApiException e){
        log.warn("error info " , e );
        return new JSONResult(e.getCode(),e.getMessage());
    }
}
