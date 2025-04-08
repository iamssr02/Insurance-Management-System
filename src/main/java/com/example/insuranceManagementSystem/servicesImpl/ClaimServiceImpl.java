package com.example.insuranceManagementSystem.servicesImpl;

import com.example.insuranceManagementSystem.dto.ClaimDTO;
import com.example.insuranceManagementSystem.models.ClaimEntity;
import com.example.insuranceManagementSystem.models.HospitalEntity;
import com.example.insuranceManagementSystem.models.PolicyEntity;
import com.example.insuranceManagementSystem.repositories.ClaimRepository;
import com.example.insuranceManagementSystem.repositories.HospitalRepository;
import com.example.insuranceManagementSystem.repositories.PolicyRepository;
import com.example.insuranceManagementSystem.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public ClaimDTO createClaim(ClaimDTO dto) {
        PolicyEntity policy = policyRepository.findById(dto.getPolicyId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy not found"));
        HospitalEntity hospital = hospitalRepository.findById(dto.getHospitalId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));

        ClaimEntity entity = ClaimEntity.builder()
                .createdAt(LocalDateTime.now())
                .policy(policy)
                .hospital(hospital)
                .remarks(dto.getRemarks())
                .status("PENDING")
                .build();

        ClaimEntity saved = claimRepository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public ClaimDTO updateClaimStatus(Long id, String status) {
        ClaimEntity existing = claimRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Claim not found"));

        existing.setStatus(status);
        ClaimEntity updated = claimRepository.save(existing);
        return mapToDTO(updated);
    }

    @Override
    public List<ClaimDTO> getAllClaims() {
        return claimRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimDTO getClaimById(Long id) {
        ClaimEntity entity = claimRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Claim not found"));
        return mapToDTO(entity);
    }

    @Override
    public void deleteClaim(Long id) {
        ClaimEntity existing = claimRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Claim not found"));
        claimRepository.delete(existing);
    }

    private ClaimDTO mapToDTO(ClaimEntity entity) {
        return ClaimDTO.builder()
                .policyId(entity.getPolicy().getPolicyId())
                .hospitalId(entity.getHospital().getHospitalId())
                .remarks(entity.getRemarks())
                .status(entity.getStatus())
                .build();
    }
}