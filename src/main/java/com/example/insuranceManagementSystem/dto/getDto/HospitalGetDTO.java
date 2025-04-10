package com.example.insuranceManagementSystem.dto.getDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalGetDTO {
    private Long id;
    private String name;
    private String location;
    private String contactEmail;
    private String phoneNumber;
    private Double discount;
}
