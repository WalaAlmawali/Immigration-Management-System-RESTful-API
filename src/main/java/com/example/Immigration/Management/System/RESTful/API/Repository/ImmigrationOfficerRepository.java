package com.example.Immigration.Management.System.RESTful.API.Repository;

import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmigrationOfficerRepository extends JpaRepository<ImmigrationOfficer, Long> {
}
