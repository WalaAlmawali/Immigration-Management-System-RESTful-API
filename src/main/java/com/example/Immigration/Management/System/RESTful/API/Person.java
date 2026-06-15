package com.example.Immigration.Management.System.RESTful.API;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
}
