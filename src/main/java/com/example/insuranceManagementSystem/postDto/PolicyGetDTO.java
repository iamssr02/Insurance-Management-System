package com.example.insuranceManagementSystem.postDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyGetDTO {
    private Long id;
    private String policyName;
    private String policyType;
    private Double premium;
    private Double coverage;
    private Integer duration;
}
