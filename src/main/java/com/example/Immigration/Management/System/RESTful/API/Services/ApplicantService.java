package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;
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

    //object
    public Applicant saveApplicant(Applicant applicant) {

        if (applicant.getPassportNumber() == null || applicant.getPassportNumber().isEmpty()) {
            throw new RuntimeException("Passport number cannot be null or empty");
        }

        if (applicant.getFirstName() == null || applicant.getFirstName().isEmpty()
                || applicant.getLastName() == null || applicant.getLastName().isEmpty()) {
            throw new RuntimeException("First name and last name are required");
        }

        return applicantRepository.save(applicant);
    }

}
