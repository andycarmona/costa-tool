package com.vgsc.costa.tool.config;

import com.vgsc.costa.tool.domain.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

@Configuration
public class VehicleSubscription {

    @Bean
    public Sinks.Many<Vehicle> vehicleSink() {
        return Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
    }

    @Bean
    public Flux<Vehicle> vehicleFlux(Sinks.Many<Vehicle> vehicleSink) {
        return vehicleSink.asFlux();
    }
}
