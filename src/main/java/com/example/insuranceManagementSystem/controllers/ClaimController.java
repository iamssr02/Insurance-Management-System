package com.example.insuranceManagementSystem.controllers;

import com.example.insuranceManagementSystem.dto.ClaimDTO;
import com.example.insuranceManagementSystem.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance-management-system/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ClaimDTO createClaim(@RequestBody ClaimDTO dto) {
        return claimService.createClaim(dto);
    }

    @PutMapping("/{id}")
    public ClaimDTO updateStatus(@PathVariable Long id, @RequestParam String status) {
        return claimService.updateClaimStatus(id, status);
    }

    @GetMapping
    public List<ClaimDTO> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public ClaimDTO getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
    }
}
