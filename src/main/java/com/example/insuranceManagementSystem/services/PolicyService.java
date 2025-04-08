package com.example.insuranceManagementSystem.services;

import com.example.insuranceManagementSystem.dto.PolicyDTO;
import java.util.List;

public interface PolicyService {
    PolicyDTO createPolicy(PolicyDTO dto);
    PolicyDTO updatePolicy(Long id, PolicyDTO dto);
    void deletePolicy(Long id);
    PolicyDTO getPolicyById(Long id);
    List<PolicyDTO> getAllPolicies();
}