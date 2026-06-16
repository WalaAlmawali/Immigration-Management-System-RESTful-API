package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.Entities.BorderControlOfficer;
import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationOfficer;
import com.example.Immigration.Management.System.RESTful.API.Services.OfficerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {

    private final OfficerService officerService;

    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    @PostMapping
    public ImmigrationOfficer hireOfficer(@RequestBody ImmigrationOfficer officer) {
        return officerService.hireOfficer(officer);
    }

    @PostMapping("/border")
    public BorderControlOfficer hireBorderOfficer(@RequestBody BorderControlOfficer officer) {

        return officerService.hireBorderOfficer(officer);
    }

    @GetMapping("/{id}")
    public ImmigrationOfficer getOfficerById(@PathVariable Long id) {

        return officerService.getOfficerById(id);
    }

    @PutMapping("/{id}/promote")
    public ImmigrationOfficer promoteOfficer(
            @PathVariable Long id,
            @RequestParam String rank,
            @RequestParam int clearance) {

        return officerService.promoteOfficer(id, rank, clearance);
    }

    @PutMapping("/{id}/transfer/{centerId}")
    public ImmigrationOfficer transferOfficer(
            @PathVariable Long id,
            @PathVariable Long centerId) {

        return officerService.transferOfficer(id, centerId);
    }
}
