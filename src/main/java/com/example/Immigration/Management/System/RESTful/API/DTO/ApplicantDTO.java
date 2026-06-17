package com.example.Immigration.Management.System.RESTful.API.DTO;


import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;

import java.util.ArrayList;
import java.util.List;

public class ApplicantDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String nationality;

    public ApplicantDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }



    public static ApplicantDTO convertToDTO(Applicant entity) {
        ApplicantDTO dto = new ApplicantDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPassportNumber(entity.getPassportNumber());
        dto.setNationality(entity.getNationality());
        return dto;
    }

    public static List<ApplicantDTO> convertToDTO(
            List<Applicant> entities) {

        List<ApplicantDTO> dtos = new ArrayList<>();

        for (Applicant entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return dtos;
    }
}
