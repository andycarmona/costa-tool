package com.vgsc.costa.tool.repository;


import com.vgsc.costa.tool.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> { }
public interface VehicleRepository extends R2dbcRepository<Vehicle, String> { }
