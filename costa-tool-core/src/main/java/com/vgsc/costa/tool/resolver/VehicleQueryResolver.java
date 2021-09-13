package com.vgsc.costa.tool.resolver;

import com.vgsc.costa.tool.domain.Vehicle;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleQueryResolver implements GraphQLResolver<Vehicle> {

    private final com.vgcs.costatool.service.VehicleService vehicleService;

    public VehicleQueryResolver(com.vgcs.costatool.service.VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleService.findById(id);
    }

    public Iterable<Vehicle> getVehicles() { return vehicleService.findAll(); }
}
