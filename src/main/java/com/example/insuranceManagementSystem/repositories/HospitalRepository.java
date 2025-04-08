package com.example.insuranceManagementSystem.repositories;

import com.example.insuranceManagementSystem.models.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
    boolean existsByContactEmail(String contactEmail);
}