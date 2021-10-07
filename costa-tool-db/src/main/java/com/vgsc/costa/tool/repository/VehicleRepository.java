package com.vgsc.costa.tool.repository;


import com.vgsc.costa.tool.domain.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends ReactiveMongoRepository<Vehicle, String> { }
