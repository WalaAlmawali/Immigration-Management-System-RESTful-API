package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.Entities.VisaApplication;
import com.example.Immigration.Management.System.RESTful.API.Services.VisaApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visas")
public class VisaApplicationController {
    private final VisaApplicationService visaService;

    public VisaApplicationController(VisaApplicationService visaService) {
        this.visaService = visaService;
    }

    @PostMapping("/submit/{applicantId}")
    public VisaApplication submitVisa(
            @PathVariable Long applicantId,
            @RequestParam String type) {

        return visaService.submitApplication(applicantId, type);
    }

    @PutMapping("/{visaId}/assign/{officerId}")
    public VisaApplication assignOfficer(
            @PathVariable Long visaId,
            @PathVariable Long officerId) {

        return visaService.assignOfficer(visaId, officerId);
    }

    @PutMapping("/{visaId}/process")
    public VisaApplication processVisa(
            @PathVariable Long visaId,
            @RequestParam String status,
            @RequestParam String notes) {

        return visaService.processVisa(visaId, status, notes);
    }
    @GetMapping("/applicant/{applicantId}")
    public List<VisaApplication> getVisasByApplicant(
            @PathVariable Long applicantId) {

        return visaService.getVisasByApplicant(applicantId);
    }
    @GetMapping("/status/{status}")
    public List<VisaApplication> getVisasByStatus(
            @PathVariable String status) {

        return visaService.getVisasByStatus(status);
    }
}
