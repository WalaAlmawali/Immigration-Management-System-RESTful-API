package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationCenter;
import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationOfficer;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationCenterRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationOfficerRepository;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {

    private final ImmigrationOfficerRepository officerRepository;
    private final ImmigrationCenterRepository centerRepository;

    public OfficerService(ImmigrationOfficerRepository officerRepository, ImmigrationCenterRepository centerRepository) {
        this.officerRepository = officerRepository;
        this.centerRepository = centerRepository;
    }

    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel) {

        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw new RuntimeException("Clearance level must be between 1 and 5");
        }

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        officer.setRank(newRank);
        officer.setClearanceLevel(newClearanceLevel);

        return officerRepository.save(officer);
    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId) {

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        ImmigrationCenter center = centerRepository.findById(newCenterId)
                .orElseThrow(() -> new RuntimeException("Center not found"));

        officer.setCenter(center);
        return officerRepository.save(officer);
    }

}
