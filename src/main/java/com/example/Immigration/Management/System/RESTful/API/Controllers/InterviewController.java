package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.Services.InterviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

}
