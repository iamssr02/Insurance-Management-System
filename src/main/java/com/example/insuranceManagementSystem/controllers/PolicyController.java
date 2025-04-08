package com.example.insuranceManagementSystem.controllers;

import com.example.insuranceManagementSystem.dto.PolicyDTO;
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
    public PolicyDTO createPolicy(@RequestBody PolicyDTO dto) {
        return policyService.createPolicy(dto);
    }

    @GetMapping("/{id}")
    public PolicyDTO getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @GetMapping
    public List<PolicyDTO> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @PutMapping("/{id}")
    public PolicyDTO updatePolicy(@PathVariable Long id, @RequestBody PolicyDTO dto) {
        return policyService.updatePolicy(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
    }
}