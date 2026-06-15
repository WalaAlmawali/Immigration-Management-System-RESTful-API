package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Repository.ApplicantRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.InterviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final InterviewRepository interviewRepository;

    public ApplicantService(ApplicantRepository applicantRepository, InterviewRepository interviewRepository) {
        this.applicantRepository = applicantRepository;
        this.interviewRepository = interviewRepository;
    }


}
