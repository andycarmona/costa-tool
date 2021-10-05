package com.vgsc.costa.tool.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vgsc.costa.tool.domain.Vehicle;
import com.vgsc.costa.tool.model.VehiclesDto;
import com.vgsc.costa.tool.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MockoonClient {

    public MockoonClient() {
    }

    public void saveVehicles(VehicleRepository vehicleRepository) {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String baseUrl = "http://localhost:3004/vehicle/list";
        HttpGet getRequest = new HttpGet( baseUrl );
        try (CloseableHttpClient httpClient = closeableHttpClient;
             CloseableHttpResponse response = httpClient.execute( getRequest )) {
            try {
                String result = EntityUtils.toString( response.getEntity() );
                if (result != null) {
                    List<Vehicle> vehicleEntityList = convertToVehicleEntity( result );
                    if (vehicleEntityList != null && !vehicleEntityList.isEmpty()) {
                        vehicleRepository.saveAll( vehicleEntityList );
                    }
                }
            } catch (JsonProcessingException e) {
                log.error( "Fail on parsing Json" );
            }
        } catch (ClientProtocolException e) {
            log.error( "Fail on client configuration" );
        } catch (IOException e) {
            log.error( "Fail on client creation" );
        }
    }


    private List<Vehicle> convertToVehicleEntity(String rawResult) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleEntityList = new ArrayList<>();
        VehiclesDto vehiclesDto = mapper.readValue( rawResult, VehiclesDto.class );
        if (vehiclesDto != null && !vehiclesDto.getVehicles().isEmpty()) {
            vehicleEntityList = vehiclesDto.getVehicles()
                    .stream()
                    .map( vehicle -> new Vehicle( vehicle.getId(), vehicle.getName() ) )
                    .collect( Collectors.toList() );
        }
        return vehicleEntityList;
    }
}
