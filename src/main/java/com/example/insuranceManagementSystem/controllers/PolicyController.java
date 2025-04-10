package com.example.insuranceManagementSystem.controllers;

import com.example.insuranceManagementSystem.dto.postDto.PolicyGetDTO;
import com.example.insuranceManagementSystem.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance-management-system/policy")
@CrossOrigin(origins = "http://localhost:4200")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping
    public PolicyGetDTO createPolicy(@RequestBody PolicyGetDTO dto) {
        return policyService.createPolicy(dto);
    }

    @GetMapping("/{id}")
    public PolicyGetDTO getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @GetMapping
    public List<PolicyGetDTO> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @PutMapping("/{id}")
    public PolicyGetDTO updatePolicy(@PathVariable Long id, @RequestBody PolicyGetDTO dto) {
        return policyService.updatePolicy(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
    }
}