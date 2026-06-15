package com.example.Immigration.Management.System.RESTful.API;

import jakarta.persistence.*;

@Entity
public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;

    private String nationality;

    private boolean criminalRecord;

}
