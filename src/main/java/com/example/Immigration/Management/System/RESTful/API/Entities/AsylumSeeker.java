package com.example.Immigration.Management.System.RESTful.API.Entities;

import jakarta.persistence.*;
@Entity
public class AsylumSeeker extends Applicant {

    private String countryOfOrigin;

    private String sponsorOrganization;

    public AsylumSeeker() {
    }

    public AsylumSeeker(String countryOfOrigin,
                        String sponsorOrganization) {
        this.countryOfOrigin = countryOfOrigin;
        this.sponsorOrganization = sponsorOrganization;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getSponsorOrganization() {
        return sponsorOrganization;
    }

    public void setSponsorOrganization(String sponsorOrganization) {
        this.sponsorOrganization = sponsorOrganization;
    }
}
