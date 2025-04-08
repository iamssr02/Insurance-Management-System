package com.example.insuranceManagementSystem.services;

import com.example.insuranceManagementSystem.dto.ClaimDTO;
import java.util.List;

public interface ClaimService {
    ClaimDTO createClaim(ClaimDTO dto);
    ClaimDTO updateClaimStatus(Long id, String status);
    List<ClaimDTO> getAllClaims();
    ClaimDTO getClaimById(Long id);
    void deleteClaim(Long id);
}