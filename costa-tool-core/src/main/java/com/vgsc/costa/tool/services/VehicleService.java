package com.vgsc.costa.tool.services;


import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById( id );
    }

    public Iterable<Vehicle> getVehicles() { return vehicleRepository.findAll(); }
    
    public Vehicle addVehicle(Vehicle vehicle) {return vehicleRepository.save(vehicle); }

}
