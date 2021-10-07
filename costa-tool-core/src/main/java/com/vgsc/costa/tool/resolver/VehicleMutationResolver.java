package com.vgsc.costa.tool.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Optional;

@Component
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleService vehicleService;
    private final Sinks.Many<Vehicle> vehicleSink;

    @Autowired
    public VehicleMutationResolver(VehicleService vehicleService, Sinks.Many<Vehicle> vehicleSink) {
        this.vehicleService = vehicleService;
        this.vehicleSink = vehicleSink;
    }

    public Vehicle addVehicle(String id, String name) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setName(name);
        Mono<Vehicle> savedVehicle = vehicleService.addVehicle(vehicle);
        vehicleSink.tryEmitNext(vehicle);
        return savedVehicle.block();
    }
}
