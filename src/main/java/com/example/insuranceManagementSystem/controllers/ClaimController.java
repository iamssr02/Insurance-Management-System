package com.example.insuranceManagementSystem.controllers;

import com.example.insuranceManagementSystem.getDto.ClaimGetDTO;
import com.example.insuranceManagementSystem.postDto.ClaimPostDTO;
import com.example.insuranceManagementSystem.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance-management-system/claims")
@CrossOrigin(origins = "http://localhost:4200")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ClaimPostDTO createClaim(@RequestBody ClaimPostDTO dto) {
        return claimService.createClaim(dto);
    }

    @PutMapping("/{id}")
    public ClaimPostDTO updateStatus(@PathVariable Long id, @RequestParam String status) {
        return claimService.updateClaimStatus(id, status);
    }

    @GetMapping
    public List<ClaimGetDTO> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public ClaimGetDTO getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
    }
}
