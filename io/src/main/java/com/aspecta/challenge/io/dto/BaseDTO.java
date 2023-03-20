package com.aspecta.challenge.io.dto;

/**
 * @Author: sxy
 * @Date: 2023/3/19 14:21
 */

import lombok.Data;

/**
 * 基础dto类
 */
@Data
public class BaseDTO {
    /**
     * size
     */
    private long page_size = 10L;
    /**
     * page
     */
    private long page = 1L;
    /**
     * id
     */
    private String id;
    /**
     * 登录凭证
     */
    private String appid;
}
