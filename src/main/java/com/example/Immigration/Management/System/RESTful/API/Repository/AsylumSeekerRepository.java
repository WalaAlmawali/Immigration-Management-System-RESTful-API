package com.example.Immigration.Management.System.RESTful.API.Repository;

import com.example.Immigration.Management.System.RESTful.API.Entities.AsylumSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsylumSeekerRepository extends JpaRepository<AsylumSeeker, Long> {
}
