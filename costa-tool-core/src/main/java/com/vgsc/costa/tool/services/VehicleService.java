package com.vgsc.costa.tool.services;


import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Mono<Vehicle> getVehicleById(String id) { return vehicleRepository.findById( id ); }

    public Flux<Vehicle> getVehicles() { return vehicleRepository.findAll(); }

    public Mono<Vehicle> addVehicle(Vehicle vehicle) { return vehicleRepository.save(vehicle); }

}
