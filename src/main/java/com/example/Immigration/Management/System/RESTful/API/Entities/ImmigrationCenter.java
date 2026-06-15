package com.example.Immigration.Management.System.RESTful.API.Entities;

import jakarta.persistence.*;

import java.util.List;
@Entity public class ImmigrationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String locationCountry;
    private String type; // Embassy or Border
    private int dailyCapacity;

    @OneToMany(mappedBy = "center")
    private List<ImmigrationOfficer> officers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ImmigrationOfficer> getOfficers() {
        return officers;
    }

    public void setOfficers(List<ImmigrationOfficer> officers) {
        this.officers = officers;
    }

    public int getDailyCapacity() {
        return dailyCapacity;
    }

    public void setDailyCapacity(int dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }
}
