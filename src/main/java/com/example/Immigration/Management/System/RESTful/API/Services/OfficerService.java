package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationOfficerRepository;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {

    private final ImmigrationOfficerRepository officerRepository;
    private final ImmigrationCenterRepository centerRepository;


}
