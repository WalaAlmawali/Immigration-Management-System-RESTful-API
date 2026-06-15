package com.example.Immigration.Management.System.RESTful.API.Entities;

import com.example.Immigration.Management.System.RESTful.API.Person;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Applicant extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;

    private String nationality;

    private boolean criminalRecord;

    @OneToMany(mappedBy="applicant")
    private List<VisaApplication> visaApplications;

    @OneToMany(mappedBy="applicant")
    private List<Interview> interviews;

    public Applicant() {
    }

    public Applicant(Long id, String passportNumber, String nationality, boolean criminalRecord) {
        this.id = id;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.criminalRecord = criminalRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(boolean criminalRecord) {
        this.criminalRecord = criminalRecord;
    }
    public List<VisaApplication> getVisaApplications() {
        return visaApplications;
    }

    public void setVisaApplications(List<VisaApplication> visaApplications) {
        this.visaApplications = visaApplications;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }
}
