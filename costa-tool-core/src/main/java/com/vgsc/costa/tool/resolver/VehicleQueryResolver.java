package com.vgsc.costa.tool.resolver;

import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.services.VehicleService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleQueryResolver implements GraphQLResolver<Vehicle> {

    private final VehicleService vehicleService;

    public VehicleQueryResolver(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleService.getVehicleById(id);
    }

    public Iterable<Vehicle> getVehicles() { return vehicleService.getVehicles(); }
}
