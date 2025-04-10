package com.example.insuranceManagementSystem.controllers;

import com.example.insuranceManagementSystem.dto.getDto.HospitalGetDTO;
import com.example.insuranceManagementSystem.services.HospitalService;
import com.example.insuranceManagementSystem.dto.postDto.HospitalPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance-management-system/hospitals")
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<HospitalPostDTO> createHospital(@RequestBody HospitalPostDTO hospitalPostDTO) {
        HospitalPostDTO created = hospitalService.createHospital(hospitalPostDTO);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<HospitalGetDTO>> getAllHospitals() {
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalGetDTO> getHospitalById(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospitalPostDTO> updateHospital(@PathVariable Long id, @RequestBody HospitalPostDTO hospitalPostDTO) {
        return ResponseEntity.ok(hospitalService.updateHospital(id, hospitalPostDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
        return ResponseEntity.noContent().build();
    }
}
