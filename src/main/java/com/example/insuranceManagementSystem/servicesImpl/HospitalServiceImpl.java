package com.example.insuranceManagementSystem.servicesImpl;

import com.example.insuranceManagementSystem.dto.HospitalDTO;
import com.example.insuranceManagementSystem.models.HospitalEntity;
import com.example.insuranceManagementSystem.repositories.HospitalRepository;
import com.example.insuranceManagementSystem.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public HospitalDTO createHospital(HospitalDTO dto) {
        if (hospitalRepository.existsByContactEmail(dto.getContactEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in use");
        }
        HospitalEntity entity = mapToEntity(dto);
        HospitalEntity saved = hospitalRepository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public HospitalDTO updateHospital(Long id, HospitalDTO dto) {
        HospitalEntity existing = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        if (!existing.getContactEmail().equals(dto.getContactEmail()) &&
                hospitalRepository.existsByContactEmail(dto.getContactEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in use");
        }
        existing.setName(dto.getName());
        existing.setLocation(dto.getLocation());
        existing.setContactEmail(dto.getContactEmail());
        existing.setPhoneNumber(dto.getPhoneNumber());
        existing.setDiscount(dto.getDiscount());
        HospitalEntity updated = hospitalRepository.save(existing);
        return mapToDTO(updated);
    }

    @Override
    public void deleteHospital(Long id) {
        HospitalEntity existing = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        hospitalRepository.delete(existing);
    }

    @Override
    public HospitalDTO getHospitalById(Long id) {
        HospitalEntity entity = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        return mapToDTO(entity);
    }

    @Override
    public List<HospitalDTO> getAllHospitals() {
        return hospitalRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private HospitalEntity mapToEntity(HospitalDTO dto) {
        return HospitalEntity.builder()
                .createdAt(LocalDateTime.now())
                .name(dto.getName())
                .location(dto.getLocation())
                .contactEmail(dto.getContactEmail())
                .phoneNumber(dto.getPhoneNumber())
                .discount(dto.getDiscount() != null ? dto.getDiscount() : 0.0)
                .build();
    }

    private HospitalDTO mapToDTO(HospitalEntity entity) {
        return HospitalDTO.builder()
                .name(entity.getName())
                .location(entity.getLocation())
                .contactEmail(entity.getContactEmail())
                .phoneNumber(entity.getPhoneNumber())
                .discount(entity.getDiscount())
                .build();
    }
}
