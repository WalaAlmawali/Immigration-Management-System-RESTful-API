package com.example.Immigration.Management.System.RESTful.API.DTO;

import com.example.Immigration.Management.System.RESTful.API.Entities.Interview;

import java.util.ArrayList;
import java.util.List;

public class InterviewDTO {
    private Long id;
    private String interviewDate;
    private String status;
    private String purpose;

    public InterviewDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public static InterviewDTO convertToDTO(Interview entity) {
        InterviewDTO dto = new InterviewDTO();

        dto.setId(entity.getId());
        dto.setInterviewDate(entity.getInterviewDate());
        dto.setStatus(entity.getStatus());
        dto.setPurpose(entity.getPurpose());
        return dto;
    }

    public static List<InterviewDTO> convertToDTO(List<Interview> entities) {

        List<InterviewDTO> dtos = new ArrayList<>();
        for (Interview entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}


