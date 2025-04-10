package com.example.insuranceManagementSystem.services;

import com.example.insuranceManagementSystem.dto.postDto.PolicyGetDTO;
import java.util.List;

public interface PolicyService {
    PolicyGetDTO createPolicy(PolicyGetDTO dto);
    PolicyGetDTO updatePolicy(Long id, PolicyGetDTO dto);
    void deletePolicy(Long id);
    PolicyGetDTO getPolicyById(Long id);
    List<PolicyGetDTO> getAllPolicies();
}