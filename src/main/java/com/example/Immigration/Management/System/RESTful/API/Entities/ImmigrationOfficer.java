package com.example.Immigration.Management.System.RESTful.API.Entities;

import com.example.Immigration.Management.System.RESTful.API.Person;
import jakarta.persistence.*;

@Entity
public class ImmigrationOfficer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private boolean active;
}
