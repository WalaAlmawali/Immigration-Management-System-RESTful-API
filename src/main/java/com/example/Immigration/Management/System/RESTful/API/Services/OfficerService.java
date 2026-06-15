package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationCenter;
import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationOfficer;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationCenterRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationOfficerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficerService {

    private final ImmigrationOfficerRepository immigrationOfficerRepository;
    private final ImmigrationCenterRepository centerRepository;

    public OfficerService(ImmigrationOfficerRepository officerRepository, ImmigrationCenterRepository centerRepository) {
        this.immigrationOfficerRepository = officerRepository;
        this.centerRepository = centerRepository;
    }

    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel) {

        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw new RuntimeException("Clearance level must be between 1 and 5");
        }

        ImmigrationOfficer officer = immigrationOfficerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        officer.setRank(newRank);
        officer.setClearanceLevel(newClearanceLevel);

        return immigrationOfficerRepository.save(officer);
    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId) {

        ImmigrationOfficer officer = immigrationOfficerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        ImmigrationCenter center = centerRepository.findById(newCenterId)
                .orElseThrow(() -> new RuntimeException("Center not found"));

        officer.setCenter(center);
        return immigrationOfficerRepository.save(officer);
    }

    public List<ImmigrationOfficer> findOfficerByRank(String rank) {
        return immigrationOfficerRepository.findByRank(rank);
    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank, int minimumClearanceLevel) {

        List<ImmigrationOfficer> officers = immigrationOfficerRepository.findByRank(rank);
        /*List<ImmigrationOfficer> result = new ArrayList<>();

        for(ImmigrationOfficer officer:officers ) {
            if(officer.getClearanceLevel() >= minimumClearanceLevel){
                result.add(officer);
            }
        }
        return result;*/

        return officers.stream()
                .filter(o -> o.getClearanceLevel() >= minimumClearanceLevel)
                .collect(Collectors.toList());
    }
}

