package com.vgsc.costa.tool.resolver;

import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.services.VehicleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private VehicleService vehicleService;
    private Sinks.Many<Vehicle> vehicleSink;

    @Autowired
    public VehicleMutationResolver(VehicleService vehicleService, Sinks.Many<Vehicle> vehicleSink) {
        this.vehicleService = vehicleService;
        this.vehicleSink = vehicleSink;
    }

    public Vehicle addVehicle(String id, String name) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setName(name);
        Vehicle savedVehicle = vehicleService.addVehicle(vehicle);
        vehicleSink.tryEmitNext(vehicle);
        return savedVehicle;
    }
}
