package com.vgcs.costatool.service;


import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.repository.VehicleRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> findById(String id) {
        return vehicleRepository.findById( id );
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

}
