package com.example.insuranceManagementSystem.repositories;

import com.example.insuranceManagementSystem.models.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<ClaimEntity, Long> {
}
