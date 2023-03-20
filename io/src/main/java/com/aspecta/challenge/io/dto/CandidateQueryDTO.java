package com.aspecta.challenge.io.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: sxy
 * @Date: 2023/3/19 14:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateQueryDTO extends BaseDTO {
    /**
     * 技能名称
     */
    private String skill_name;

}
