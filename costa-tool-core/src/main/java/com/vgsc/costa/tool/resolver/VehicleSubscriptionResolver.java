package com.vgsc.costa.tool.resolver;

import com.vgsc.costa.tool.domain.Vehicle;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class VehicleSubscriptionResolver implements GraphQLSubscriptionResolver {

    private Flux<Vehicle> vehicleEvents;

    @Autowired
    public VehicleSubscriptionResolver(Flux<Vehicle> vehicleEvents) {
        this.vehicleEvents = vehicleEvents;
    }

    public Publisher<Vehicle> vehicleCreation() {
        return vehicleEvents.map(vehicle -> {
            log.info("Publish vehicle {}", vehicle.getName());
            return vehicle;
        });
    }

}
