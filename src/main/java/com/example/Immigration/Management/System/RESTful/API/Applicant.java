package com.example.Immigration.Management.System.RESTful.API;

import jakarta.persistence.*;

@Entity
public class Applicant extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;

    private String nationality;

    private boolean criminalRecord;

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
}
