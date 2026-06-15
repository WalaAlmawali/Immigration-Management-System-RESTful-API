package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Repository.ApplicantRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationOfficerRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.VisaApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class VisaApplicationService {

    private final VisaApplicationRepository visaRepository;
    private final ApplicantRepository applicantRepository;
    private final ImmigrationOfficerRepository officerRepository;

    public VisaApplicationService(VisaApplicationRepository visaRepository,
                                  ApplicantRepository applicantRepository,
                                  ImmigrationOfficerRepository officerRepository) {
        this.visaRepository = visaRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }

}
