package com.example.Immigration.Management.System.RESTful.API.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class ImmigrationOfficer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String badgeNumber;
    private String rankOfficer;
    private int clearanceLevel;
    private boolean active;

    @ManyToOne
    private ImmigrationCenter center;

    @OneToMany(mappedBy = "handlingOfficer")
    private List<VisaApplication> visaApplications;

    @OneToMany(mappedBy = "officer")
    private List<Interview> interviews;

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
        return rankOfficer;
    }

    public void setRank(String rank) {
        this.rankOfficer = rank;
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

    public ImmigrationCenter getCenter() {
        return center;
    }

    public void setCenter(ImmigrationCenter center) {
        this.center = center;
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
