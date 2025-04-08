package com.example.insuranceManagementSystem.getDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimGetDTO {
    private Long claimId;
    private Long policyId;
    private Long hospitalId;
    private String claimName;
    private LocalDateTime createdAt;
    private String remarks;
    private String status;
}
