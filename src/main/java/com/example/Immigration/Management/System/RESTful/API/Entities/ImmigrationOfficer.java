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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
