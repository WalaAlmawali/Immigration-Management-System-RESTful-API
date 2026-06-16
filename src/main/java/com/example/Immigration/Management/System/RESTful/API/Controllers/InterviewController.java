package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.Entities.Interview;
import com.example.Immigration.Management.System.RESTful.API.Services.InterviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping("/schedule/{applicantId}/{officerId}")
    public Interview scheduleInterview(
            @PathVariable Long applicantId,
            @PathVariable Long officerId,
            @RequestParam String date) {

        return interviewService.scheduleInterview(
                applicantId,
                officerId,
                date
        );
    }

    @PutMapping("/{id}/complete")
    public Interview completeInterview(
            @PathVariable Long id) {

        return interviewService.completeInterview(id);
    }

    @PutMapping("/{id}/cancel")
    public Interview cancelInterview(
            @PathVariable Long id) {

        return interviewService.cancelInterview(id);
    }

    @GetMapping("/officer/{officerId}/date/{date}")
    public List<Interview> getOfficerSchedule(
            @PathVariable Long officerId,
            @PathVariable String date) {

        return interviewService.getOfficerSchedule(officerId, date);
    }
}
