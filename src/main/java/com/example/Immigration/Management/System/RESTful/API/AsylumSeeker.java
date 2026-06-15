package com.example.Immigration.Management.System.RESTful.API;

import jakarta.persistence.*;

@Entity
public class AsylumSeeker extends Applicant {

    private String countryOfOrigin;

    private String sponsorOrganization;

}
