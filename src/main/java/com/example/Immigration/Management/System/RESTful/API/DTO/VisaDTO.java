package com.example.Immigration.Management.System.RESTful.API.DTO;

public class VisaDTO {

    private Long id;
    private String visaType;
    private String status;

    public VisaDTO() {
    }

    public VisaDTO(Long id,
                   String visaType,
                   String status) {

        this.id = id;
        this.visaType = visaType;
        this.status = status;
    }

// getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
