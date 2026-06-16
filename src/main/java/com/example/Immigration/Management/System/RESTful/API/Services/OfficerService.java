package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationCenter;
import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationOfficer;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationCenterRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.OfficerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficerService {

    private final OfficerRepository officerRepository;
    private final ImmigrationCenterRepository centerRepository;

    public OfficerService(OfficerRepository officerRepository, ImmigrationCenterRepository centerRepository) {
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

    public List<ImmigrationOfficer> findOfficerByRank(String rank) {
        return officerRepository.findByRank(rank);
    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank, int minimumClearanceLevel) {

        List<ImmigrationOfficer> officers = officerRepository.findByRank(rank);
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

    public ImmigrationOfficer hireOfficer(ImmigrationOfficer officer){

        if(officer == null){
            throw new RuntimeException("Officer not found");
        }
        return officerRepository.save(officer);
    }
}

