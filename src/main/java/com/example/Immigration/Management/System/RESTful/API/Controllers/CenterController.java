package com.example.Immigration.Management.System.RESTful.API.Controllers;

import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationCenter;
import com.example.Immigration.Management.System.RESTful.API.Services.ImmigrationCenterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/centers")

public class CenterController {

    private final ImmigrationCenterService centerService;

    public CenterController(ImmigrationCenterService centerService) {
        this.centerService = centerService;
    }

    @PostMapping
    public ImmigrationCenter createCenter(@RequestBody ImmigrationCenter center) {
        return centerService.createCenter(center);
    }

    @GetMapping("/{id}")
    public ImmigrationCenter getCenter(@PathVariable Long id) {
        return centerService.getCenterById(id);
    }
}
