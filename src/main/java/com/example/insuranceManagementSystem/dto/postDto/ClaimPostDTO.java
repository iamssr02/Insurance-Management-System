package com.example.insuranceManagementSystem.dto.postDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimPostDTO {
    private Long claimId;
    private Long policyId;
    private Long hospitalId;
    private LocalDateTime createdAt;
    private String claimName;
    private String remarks;
    private String status;
}
