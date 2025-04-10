package com.example.insuranceManagementSystem.services;

import com.example.insuranceManagementSystem.dto.getDto.ClaimGetDTO;
import com.example.insuranceManagementSystem.dto.postDto.ClaimPostDTO;
import java.util.List;

public interface ClaimService {
    ClaimPostDTO createClaim(ClaimPostDTO dto);
    ClaimPostDTO updateClaimStatus(Long id, String status);
    List<ClaimGetDTO> getAllClaims();
    ClaimGetDTO getClaimById(Long id);
    void deleteClaim(Long id);
}