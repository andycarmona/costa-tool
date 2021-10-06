package com.vgsc.costa.tool.resolver;

import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.services.VehicleService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@AllArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleService vehicleService;

    public Mono<Vehicle> getVehicleById(String id) {
        return vehicleService.getVehicleById(id);
    }

    public Flux<Vehicle> getVehicles() { return vehicleService.getVehicles(); }
}
