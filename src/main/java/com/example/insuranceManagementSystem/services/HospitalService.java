package com.example.insuranceManagementSystem.services;

import com.example.insuranceManagementSystem.getDto.HospitalGetDTO;
import com.example.insuranceManagementSystem.postDto.HospitalPostDTO;

import java.util.List;

public interface HospitalService {
    HospitalPostDTO createHospital(HospitalPostDTO hospitalPostDTO);
    HospitalPostDTO updateHospital(Long id, HospitalPostDTO hospitalPostDTO);
    void deleteHospital(Long id);
    HospitalGetDTO getHospitalById(Long id);
    List<HospitalGetDTO> getAllHospitals();
}