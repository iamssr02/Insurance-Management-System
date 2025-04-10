package com.example.insuranceManagementSystem.dto.getDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyGetDTO {
    private Long id;
    private String policyName;
    private String policyType;
    private Double premium;
    private Double coverage;
    private Integer duration;
}