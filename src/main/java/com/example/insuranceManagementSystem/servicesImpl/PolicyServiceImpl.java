package com.example.insuranceManagementSystem.servicesImpl;

import com.example.insuranceManagementSystem.postDto.PolicyGetDTO;
import com.example.insuranceManagementSystem.models.PolicyEntity;
import com.example.insuranceManagementSystem.repositories.PolicyRepository;
import com.example.insuranceManagementSystem.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public PolicyGetDTO createPolicy(PolicyGetDTO dto) {
        if (policyRepository.existsByPolicyName(dto.getPolicyName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Policy name already exists");
        }
        PolicyEntity entity = mapToEntity(dto);
        return mapToDTO(policyRepository.save(entity));
    }

    @Override
    public PolicyGetDTO updatePolicy(Long id, PolicyGetDTO dto) {
        PolicyEntity existing = policyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found"));

        if (!existing.getPolicyName().equals(dto.getPolicyName()) &&
                policyRepository.existsByPolicyName(dto.getPolicyName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Policy name already exists");
        }

        existing.setPolicyName(dto.getPolicyName());
        existing.setPolicyType(dto.getPolicyType());
        existing.setPremium(dto.getPremium());
        existing.setCoverage(dto.getCoverage());
        existing.setDurationYears(dto.getDuration());
        existing.setUpdatedAt(LocalDateTime.now());

        return mapToDTO(policyRepository.save(existing));
    }

    @Override
    public void deletePolicy(Long id) {
        PolicyEntity existing = policyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found"));
        policyRepository.delete(existing);
    }

    @Override
    public PolicyGetDTO getPolicyById(Long id) {
        return policyRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found"));
    }

    @Override
    public List<PolicyGetDTO> getAllPolicies() {
        return policyRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private PolicyEntity mapToEntity(PolicyGetDTO dto) {
        return PolicyEntity.builder()
                .policyName(dto.getPolicyName())
                .policyType(dto.getPolicyType())
                .premium(dto.getPremium())
                .coverage(dto.getCoverage())
                .durationYears(dto.getDuration())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    private PolicyGetDTO mapToDTO(PolicyEntity entity) {
        return PolicyGetDTO.builder()
                .id(entity.getPolicyId())
                .policyName(entity.getPolicyName())
                .policyType(entity.getPolicyType())
                .premium(entity.getPremium())
                .coverage(entity.getCoverage())
                .duration(entity.getDurationYears())
                .build();
    }
}