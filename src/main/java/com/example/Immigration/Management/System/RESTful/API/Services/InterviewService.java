package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;
import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationOfficer;
import com.example.Immigration.Management.System.RESTful.API.Entities.Interview;
import com.example.Immigration.Management.System.RESTful.API.Exception.OfficerAlreadyBookedException;
import com.example.Immigration.Management.System.RESTful.API.Exception.ResourceNotFoundException;
import com.example.Immigration.Management.System.RESTful.API.Repository.ApplicantRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.InterviewRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.OfficerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    private final InterviewRepository interviewRepository;
    private final ApplicantRepository applicantRepository;
    private final OfficerRepository officerRepository;

    public InterviewService(InterviewRepository interviewRepository, ApplicantRepository applicantRepository, OfficerRepository officerRepository) {
        this.interviewRepository = interviewRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }

    public Interview scheduleInterview(Long applicantId, Long officerId, String date) {

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));


        List<Interview> existing = interviewRepository.findByOfficerIdAndInterviewDate(officerId, date);

        if (!existing.isEmpty()) {
            throw new OfficerAlreadyBookedException("Officer is double-booked!");
        }

        Interview interview = new Interview();

        interview.setApplicant(applicant);
        interview.setOfficer(officer);
        interview.setInterviewDate(date);
        interview.setStatus("SCHEDULED");

        return interviewRepository.save(interview);
    }

    public Interview completeInterview(Long interviewId) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Interview not found"));

        interview.setStatus("COMPLETED");

        return interviewRepository.save(interview);
    }

    public Interview cancelInterview(Long interviewId){
        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Interview not found"));

        interview.setStatus("CANCEL");
        return interviewRepository.save(interview);

    }

    public List<Interview> getOfficerSchedule(Long officerId,String date){

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(()-> new ResourceNotFoundException("Officer not found"));

        return interviewRepository.findByOfficerIdAndInterviewDate(officerId,date);

    }

}

