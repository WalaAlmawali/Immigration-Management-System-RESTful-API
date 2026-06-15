package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;
import com.example.Immigration.Management.System.RESTful.API.Entities.VisaApplication;
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

    public VisaApplication submitApplication(Long applicantId, String visaType) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        VisaApplication visa = new VisaApplication();
        visa.setApplicant(applicant);
        visa.setVisaType(visaType);

        if (applicant.isCriminalRecord()) {
            visa.setStatus("REJECTED");
            visa.setOfficerNotes("Auto-rejected due to criminal flag.");
        } else {
            visa.setStatus("PENDING");
        }

        return visaRepository.save(visa);

    }

}
