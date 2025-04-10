package com.example.insuranceManagementSystem.dto.postDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalPostDTO {
    private String name;
    private String location;
    private String contactEmail;
    private String phoneNumber;
    private Double discount;
}
