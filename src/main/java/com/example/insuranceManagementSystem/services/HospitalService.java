package com.example.insuranceManagementSystem.services;

import com.example.insuranceManagementSystem.dto.HospitalDTO;

import java.util.List;

public interface HospitalService {
    HospitalDTO createHospital(HospitalDTO hospitalDTO);
    HospitalDTO updateHospital(Long id, HospitalDTO hospitalDTO);
    void deleteHospital(Long id);
    HospitalDTO getHospitalById(Long id);
    List<HospitalDTO> getAllHospitals();
}