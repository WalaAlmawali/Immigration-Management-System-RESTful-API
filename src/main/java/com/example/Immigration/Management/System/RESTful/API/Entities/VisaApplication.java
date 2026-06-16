package com.example.Immigration.Management.System.RESTful.API.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class VisaApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String visaType;

    private String status; // PENDING, APPROVED, REJECTED

    private String officerNotes;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    @JsonIgnoreProperties("visaApplications")
    private Applicant applicant;

    @ManyToOne
    private ImmigrationOfficer handlingOfficer;

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

    public String getOfficerNotes() {
        return officerNotes;
    }

    public void setOfficerNotes(String officerNotes) {
        this.officerNotes = officerNotes;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public ImmigrationOfficer getHandlingOfficer() {
        return handlingOfficer;
    }

    public void setHandlingOfficer(ImmigrationOfficer handlingOfficer) {
        this.handlingOfficer = handlingOfficer;
    }
}
