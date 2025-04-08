package com.example.insuranceManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDTO {
    private String policyName;
    private String policyType;
    private Double premium;
    private Double coverage;
    private Integer duration;
}
