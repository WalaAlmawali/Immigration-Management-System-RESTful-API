package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Repository.ApplicantRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationOfficerRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.InterviewRepository;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    private final InterviewRepository interviewRepository;
    private final ApplicantRepository applicantRepository;
    private final ImmigrationOfficerRepository officerRepository;

    public InterviewService(InterviewRepository interviewRepository,
                            ApplicantRepository applicantRepository,
                            ImmigrationOfficerRepository officerRepository) {
        this.interviewRepository = interviewRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }
}
