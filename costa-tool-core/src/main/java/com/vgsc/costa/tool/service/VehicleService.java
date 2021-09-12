package com.vgsc.costa.tool.service;

import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class VehicleService  {

    private static VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Mono<Vehicle> insert(Vehicle vehicle) { return vehicleRepository.save( vehicle ); }

    public Flux<Vehicle> saveAll(List<Vehicle> vehicles) {
        return vehicleRepository.saveAll( vehicles );
    }

    public Mono<Vehicle> findById(String id) {
        return vehicleRepository.findById( id );
    }

    public Flux<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Mono<Void> deleteAll() {
        return vehicleRepository.deleteAll();
    }
}
