package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;
import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationOfficer;
import com.example.Immigration.Management.System.RESTful.API.Entities.VisaApplication;
import com.example.Immigration.Management.System.RESTful.API.Repository.ApplicantRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.OfficerRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.VisaApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisaApplicationService {

    private final VisaApplicationRepository visaRepository;
    private final ApplicantRepository applicantRepository;
    private final OfficerRepository officerRepository;

    public VisaApplicationService(VisaApplicationRepository visaRepository, ApplicantRepository applicantRepository, OfficerRepository officerRepository) {
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

    public VisaApplication assignOfficer(Long visaId, Long officerId) {

        VisaApplication visa = visaRepository.findById(visaId)
                .orElseThrow(() -> new RuntimeException("Visa not found"));

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        if (visa.getVisaType().equalsIgnoreCase("Asylum") && (officer.getClearanceLevel() == 4 || officer.getClearanceLevel() == 5)) {
            visa.setHandlingOfficer(officer);
        } else {
            throw new RuntimeException("Officer clearance too low for Asylum visa (must be 4 or 5)");
        }

        return visaRepository.save(visa);

    }

    public VisaApplication processVisa(Long visaId, String newStatus, String notes) {

        VisaApplication visa = visaRepository.findById(visaId)
                .orElseThrow(() -> new RuntimeException("Visa not found"));

        if (!newStatus.equals("APPROVED") && !newStatus.equals("REJECTED")) {
            throw new RuntimeException("Invalid status. Only APPROVED or REJECTED allowed.");
        }

        visa.setStatus(newStatus);
        visa.setOfficerNotes(notes);

        return visaRepository.save(visa);
    }

    public List<VisaApplication> getVisasByApplicant(Long applicantId) {

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        return visaRepository.getVisasByApplicant(applicantId);
    }

    public List<VisaApplication> getVisasByStatus(String status) {
        return visaRepository.findByStatusIgnoreCase(status);
    }

}
