package com.example.insuranceManagementSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "policy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;

    @Column(name = "policy_name", nullable = false, unique = true)
    private String policyName;

    @Column(name = "policy_type", nullable = false)
    private String policyType;

    @Column(nullable = false)
    private Double premium;

    @Column(nullable = false)
    private Double coverage;

    @Column(name = "duration_years", nullable = false)
    private Integer durationYears;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
