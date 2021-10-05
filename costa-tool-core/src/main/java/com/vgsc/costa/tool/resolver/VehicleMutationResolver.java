package com.vgsc.costa.tool.resolver;

import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.services.VehicleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private VehicleService vehicleService;

    public Vehicle addVehicle(String id, String name) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setName(name);
        return vehicleService.addVehicle(vehicle);
    }
}
