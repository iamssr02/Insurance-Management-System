package com.example.insuranceManagementSystem.controllers;

import com.example.insuranceManagementSystem.services.HospitalService;
import com.example.insuranceManagementSystem.dto.HospitalDTO;
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
    public ResponseEntity<HospitalDTO> createHospital(@RequestBody HospitalDTO hospitalDTO) {
        HospitalDTO created = hospitalService.createHospital(hospitalDTO);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<HospitalDTO>> getAllHospitals() {
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalDTO> getHospitalById(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospitalDTO> updateHospital(@PathVariable Long id, @RequestBody HospitalDTO hospitalDTO) {
        return ResponseEntity.ok(hospitalService.updateHospital(id, hospitalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
        return ResponseEntity.noContent().build();
    }
}
