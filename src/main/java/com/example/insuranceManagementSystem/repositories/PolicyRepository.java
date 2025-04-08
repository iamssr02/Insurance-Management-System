package com.example.insuranceManagementSystem.repositories;

import com.example.insuranceManagementSystem.models.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {
    boolean existsByPolicyName(String policyName);
}