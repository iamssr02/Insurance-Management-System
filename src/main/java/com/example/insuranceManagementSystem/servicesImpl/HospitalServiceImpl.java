package com.example.insuranceManagementSystem.servicesImpl;

import com.example.insuranceManagementSystem.dto.getDto.HospitalGetDTO;
import com.example.insuranceManagementSystem.dto.postDto.HospitalPostDTO;
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
    public HospitalPostDTO createHospital(HospitalPostDTO dto) {
        if (hospitalRepository.existsByContactEmail(dto.getContactEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in use");
        }
        HospitalEntity entity = mapToEntity(dto);
        HospitalEntity saved = hospitalRepository.save(entity);
        return postMapToDTO(saved);
    }

    @Override
    public HospitalPostDTO updateHospital(Long id, HospitalPostDTO dto) {
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
        return postMapToDTO(updated);
    }

    @Override
    public void deleteHospital(Long id) {
        HospitalEntity existing = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        hospitalRepository.delete(existing);
    }

    @Override
    public HospitalGetDTO getHospitalById(Long id) {
        HospitalEntity entity = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        return getMapToDTO(entity);
    }

    @Override
    public List<HospitalGetDTO> getAllHospitals() {
        return hospitalRepository.findAll().stream()
                .map(this::getMapToDTO)
                .collect(Collectors.toList());
    }

    private HospitalEntity mapToEntity(HospitalPostDTO dto) {
        return HospitalEntity.builder()
                .createdAt(LocalDateTime.now())
                .name(dto.getName())
                .location(dto.getLocation())
                .contactEmail(dto.getContactEmail())
                .phoneNumber(dto.getPhoneNumber())
                .discount(dto.getDiscount() != null ? dto.getDiscount() : 0.0)
                .build();
    }

    private HospitalPostDTO postMapToDTO(HospitalEntity entity) {
        return HospitalPostDTO.builder()
                .name(entity.getName())
                .location(entity.getLocation())
                .contactEmail(entity.getContactEmail())
                .phoneNumber(entity.getPhoneNumber())
                .discount(entity.getDiscount())
                .build();
    }
    private HospitalGetDTO getMapToDTO(HospitalEntity entity) {
        return HospitalGetDTO.builder()
                .id(entity.getHospitalId())
                .name(entity.getName())
                .location(entity.getLocation())
                .contactEmail(entity.getContactEmail())
                .phoneNumber(entity.getPhoneNumber())
                .discount(entity.getDiscount())
                .build();
    }
}
