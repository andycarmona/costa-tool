package com.vgsc.costa.tool.repository;


import com.vgsc.costa.tool.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vehicle", path = "vehicle")
public interface VehicleRepository extends JpaRepository<Vehicle, String> { }
