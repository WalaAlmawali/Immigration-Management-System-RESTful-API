package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.Entities.*;
import com.example.Immigration.Management.System.RESTful.API.Repository.ApplicantRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationCenterRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.OfficerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseSeedController {

    private final ImmigrationCenterRepository centerRepository;
    private final OfficerRepository officerRepository;
    private final ApplicantRepository applicantRepository;

    public DatabaseSeedController(
            ImmigrationCenterRepository centerRepository,
            OfficerRepository officerRepository,
            ApplicantRepository applicantRepository) {

        this.centerRepository = centerRepository;
        this.officerRepository = officerRepository;
        this.applicantRepository = applicantRepository;
    }

    @PostMapping("/api/seed")
    public String seedDatabase() {

// =====================
// Immigration Centers
// =====================

        ImmigrationCenter center1 = new ImmigrationCenter();
        center1.setName("Muscat Immigration Center");
        center1.setLocationCountry("Oman");

        ImmigrationCenter center2 = new ImmigrationCenter();
        center2.setName("Salalah Immigration Center");
        center2.setLocationCountry("Oman");

        centerRepository.save(center1);
        centerRepository.save(center2);

// =====================
// Officers
// =====================

        ImmigrationOfficer officer1 = new ImmigrationOfficer();
        officer1.setFirstName("Ahmed");
        officer1.setLastName("Ali");
        officer1.setBadgeNumber("OFF001");
        officer1.setRank("Officer");
        officer1.setClearanceLevel(1);
        officer1.setActive(true);
        officer1.setCenter(center1);

        ImmigrationOfficer officer2 = new ImmigrationOfficer();
        officer2.setFirstName("Sara ");
        officer2.setLastName("Hassan");
        officer2.setBadgeNumber("OFF002");
        officer2.setRank("Senior Officer");
        officer2.setClearanceLevel(2);
        officer2.setActive(true);
        officer2.setCenter(center1);

        BorderControlOfficer officer3 = new BorderControlOfficer();
        officer3.setFirstName("Mohammed Said");
        officer3.setBadgeNumber("BCO001");
        officer3.setRank("Border Supervisor");
        officer3.setClearanceLevel(3);
        officer3.setActive(true);
        officer3.setCenter(center2);

        officerRepository.save(officer1);
        officerRepository.save(officer2);
        officerRepository.save(officer3);

// =====================
// Applicants
// =====================

        Applicant applicant1 = new Applicant();
        applicant1.setFirstName("John Smith");
        applicant1.setNationality("British");

        Applicant applicant2 = new Applicant();
        applicant2.setFirstName("Maria Garcia");
        applicant2.setNationality("Spanish");
        applicant2.setCriminalRecord(true);

        AsylumSeeker applicant3 = new AsylumSeeker();
        applicant3.setFirstName("Ali Hassan");
        applicant3.setNationality("Syrian");

        Applicant applicant4 = new Applicant();
        applicant4.setFirstName("Fatima Ahmed");
        applicant4.setNationality("Egyptian");

        applicantRepository.save(applicant1);
        applicantRepository.save(applicant2);
        applicantRepository.save(applicant3);
        applicantRepository.save(applicant4);

        return "Database seeded successfully!";
    }
}
