package com.vgsc.costa.tool.publisher;

import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.model.VehicleUpdate;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Slf4j
@Component
public class VehiclePublisher {
    private final Sinks.Many sink;

    public VehiclePublisher() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public Publisher<Vehicle> getVehiclePublisher(){
        return sink.asFlux().map(e-> ServerSentEvent.builder(e).build());
    }
}
