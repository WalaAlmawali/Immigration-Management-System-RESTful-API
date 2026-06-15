package com.example.Immigration.Management.System.RESTful.API.Services;

import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationCenter;
import com.example.Immigration.Management.System.RESTful.API.Repository.ImmigrationCenterRepository;
import org.springframework.stereotype.Service;

@Service
public class ImmigrationCenterService {

    private final ImmigrationCenterRepository centerRepository;

    public ImmigrationCenterService(ImmigrationCenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public ImmigrationCenter createCenter(ImmigrationCenter center) {
        if (center.getName() == null || center.getName().isEmpty()) {
            throw new RuntimeException("Center name cannot be empty");
        }

        return centerRepository.save(center);
    }

    public ImmigrationCenter getCenterById(Long id){
        return centerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Center not found"));
    }

}
