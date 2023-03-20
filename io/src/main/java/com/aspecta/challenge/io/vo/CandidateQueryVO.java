package com.aspecta.challenge.io.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: sxy
 * @Date: 2023/3/19 14:24
 */
@Data
public class CandidateQueryVO {
    /**
     * 名字
     */
    private String candidate_name;
    /**
     * 主要技能
     */
    private BigDecimal main_skill_score;
    /**
     * 相关技能
     */
    private List<SkillDetailVO> related_skills;
}
