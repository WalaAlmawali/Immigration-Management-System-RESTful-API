package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.DTO.ApplicantDTO;
import com.example.Immigration.Management.System.RESTful.API.Entities.Applicant;
import com.example.Immigration.Management.System.RESTful.API.Entities.AsylumSeeker;
import com.example.Immigration.Management.System.RESTful.API.Services.ApplicantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ApplicantDTO>> getAll() {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.getAllApplicants()));
    }

    @GetMapping("/search")
    public List<Applicant> searchByNationality(@RequestParam String nationality) {
        return applicantService.findByNationality(nationality);
    }

    @PutMapping("/{id}/flag")
    public String flagCriminal(@PathVariable Long id) {
        applicantService.flagCriminalRecord(id);
        return "Applicant flagged as criminal and scheduled interviews cancelled.";
    }

}
