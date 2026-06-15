package com.example.Immigration.Management.System.RESTful.API.Entities;

public class BorderControlOfficer extends ImmigrationOfficer {

    private String assignedCheckpoint;

    private boolean k9UnitAssigned;

    public String getAssignedCheckpoint() {
        return assignedCheckpoint;
    }

    public void setAssignedCheckpoint(String assignedCheckpoint) {
        this.assignedCheckpoint = assignedCheckpoint;
    }

    public boolean isK9UnitAssigned() {
        return k9UnitAssigned;
    }

    public void setK9UnitAssigned(boolean k9UnitAssigned) {
        this.k9UnitAssigned = k9UnitAssigned;
    }
}
