package com.vgsc.costa.tool.config;

import com.vgsc.costa.tool.handlers.VehicleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
@ComponentScan("com.vgsc.costa.tool.handlers")
public class VehicleRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> root (VehicleHandler vehicleHandler){
        return RouterFunctions.route()
                .GET("/vehicle/{id}", RequestPredicates.accept( MediaType.APPLICATION_JSON ) , vehicleHandler::getVehicleById )
                .GET("vehicles", RequestPredicates.accept( MediaType.APPLICATION_JSON ), vehicleHandler::getAllVehicles)
                .build();
    }
}
