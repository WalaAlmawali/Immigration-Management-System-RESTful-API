package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;
import com.example.Immigration.Management.System.RESTful.API.Entities.AsylumSeeker;
import com.example.Immigration.Management.System.RESTful.API.Entities.Interview;
import com.example.Immigration.Management.System.RESTful.API.Repository.ApplicantRepository;
import com.example.Immigration.Management.System.RESTful.API.Repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final InterviewRepository interviewRepository;

    public ApplicantService(ApplicantRepository applicantRepository, InterviewRepository interviewRepository) {
        this.applicantRepository = applicantRepository;
        this.interviewRepository = interviewRepository;
    }


    public Applicant saveApplicant(Applicant applicant) {

        if (applicant == null) {
            throw new RuntimeException("Applicant not found");
        }

        if (applicant.getPassportNumber() == null || applicant.getPassportNumber().isEmpty()) {
            throw new RuntimeException("Passport number cannot be null or empty");
        }

        if (applicant.getFirstName() == null || applicant.getFirstName().isEmpty()
                || applicant.getLastName() == null || applicant.getLastName().isEmpty() || applicant.getPhoneNumber() == null || applicant.getPhoneNumber().isEmpty()) {
            throw new RuntimeException("First name, last name and phone number are required");
        }

        return applicantRepository.save(applicant);
    }


    public Applicant saveApplicant(String firstName, String lastName, String passportNumber, String nationality) {

        if (passportNumber == null || passportNumber.isEmpty()) {
            throw new RuntimeException("Passport number cannot be null or empty");
        }

        if (firstName == null || firstName.isEmpty()
                || lastName == null || lastName.isEmpty()) {
            throw new RuntimeException("First name and last name are required");
        }

        if(nationality == null || nationality.isEmpty()){
            throw new RuntimeException("Nationality are required");
        }

        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);
        applicant.setCriminalRecord(false);

        return applicantRepository.save(applicant);
    }

    public void flagCriminalRecord(Long applicantId){

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        applicant.setCriminalRecord(true);
        applicantRepository.save(applicant);

        List<Interview> interviews = interviewRepository.findByApplicantId(applicantId);

        for(Interview interview:interviews){
            if(interview.getStatus().equalsIgnoreCase("SCHEDULED")){
                interview.setStatus("CANCELLED");
            }
        }
        interviewRepository.saveAll(interviews);
    }

    public AsylumSeeker saveAsylumSeeker(AsylumSeeker seeker){

        if (seeker == null) {
            throw new RuntimeException("AsylumSeeker not found");
        }

        if(seeker.getCountryOfOrigin().isBlank() || seeker.getSponsorOrganization().isEmpty()){
            throw new RuntimeException("Country Of Origin and Sponsor Organization are required");

        }

        return applicantRepository.save(seeker);


    }


}
