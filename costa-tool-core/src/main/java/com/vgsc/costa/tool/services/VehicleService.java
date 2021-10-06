package com.vgsc.costa.tool.services;


import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.publisher.VehiclePublisher;
import com.vgsc.costa.tool.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById( id );
    }

    public Iterable<Vehicle> getVehicles() { return vehicleRepository.findAll(); }
    
    public Vehicle addVehicle(Vehicle vehicle) { return vehicleRepository.save(vehicle); }

}
