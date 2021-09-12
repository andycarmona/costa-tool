package com.vgcs.costa.tool.repository;


import com.vgcs.costa.tool.domain.Vehicle;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends ReactiveCrudRepository<Vehicle, String> { }
