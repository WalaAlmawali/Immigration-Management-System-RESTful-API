package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;
import com.example.Immigration.Management.System.RESTful.API.Entities.AsylumSeeker;
import com.example.Immigration.Management.System.RESTful.API.Services.ApplicantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicant(applicant);
    }

    @PostMapping("/asylum")
    public AsylumSeeker createAsylum(@RequestBody AsylumSeeker seeker) {
        return applicantService.saveAsylumSeeker(seeker);
    }


}
