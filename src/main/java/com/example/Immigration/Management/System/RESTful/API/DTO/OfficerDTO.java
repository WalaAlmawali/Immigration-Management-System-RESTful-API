package com.example.Immigration.Management.System.RESTful.API.DTO;

public class OfficerDTO {
    private Long id;
    private String name;
    private String badgeNumber;
    private String rank;

    public OfficerDTO() {
    }

    public OfficerDTO(Long id,
                      String name,
                      String badgeNumber,
                      String rank) {
        this.id = id;
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
    }

// getters & setters

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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
}
