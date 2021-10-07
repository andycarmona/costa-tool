package com.vgsc.costa.tool.handlers;

import com.vgsc.costa.tool.model.VehicleDto;
import com.vgsc.costa.tool.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class VehicleHandler {

    private VehicleService vehicleService;

    @Autowired
    public VehicleHandler(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public  Mono<ServerResponse> getVehicleById(ServerRequest request) {
        String id = request.pathVariable( "id" );
        return ServerResponse.ok().contentType( MediaType.APPLICATION_JSON )
                .body( vehicleService.getVehicleById( id ), VehicleDto.class );
    }

    public Mono<ServerResponse> getAllVehicles(ServerRequest request){
        return ServerResponse.ok().contentType( MediaType.APPLICATION_JSON ).body(vehicleService.getVehicles(), VehicleDto[].class);
    }
}
