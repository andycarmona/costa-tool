package com.vgsc.costa.tool.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleService vehicleService;

    public Vehicle getVehicleById(String id) { return vehicleService.getVehicleById(id).block(); }

    public Iterable<Vehicle> getVehicles() { return vehicleService.getVehicles().toIterable(); }
}
