package com.example.insuranceManagementSystem.postDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimPostDTO {
    private Long policyId;
    private Long hospitalId;
    private String claimName;
    private String remarks;
    private String status;
}
