package com.example.Immigration.Management.System.RESTful.API.Repository;

import com.example.Immigration.Management.System.RESTful.API.Entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmigrationCenterRepository extends JpaRepository<ImmigrationCenter, Long> {
}
