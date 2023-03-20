package com.aspecta.challenge.io.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sxy
 * @Date: 2023/3/19 14:26
 */
@Data
public class SkillDetailVO {
    /**
     * 技能名称
     */
    private String name;
    /**
     * 技能分数
     */
    private BigDecimal score;
    /**
     * 技能平均值
     */
    private BigDecimal average;
    /**
     * 来源sources
     */
    private List<String> sources= Arrays.asList("github");
}
