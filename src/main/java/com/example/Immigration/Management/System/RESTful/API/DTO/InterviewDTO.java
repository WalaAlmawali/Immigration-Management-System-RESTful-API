package com.example.Immigration.Management.System.RESTful.API.DTO;

public class InterviewDTO {
    private Long id;
    private String interviewDate;
    private String status;

    public InterviewDTO() {
    }

    public InterviewDTO(Long id,
                        String interviewDate,
                        String status) {
        this.id = id;
        this.interviewDate = interviewDate;
        this.status = status;
    }

// getters & setters

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
}
