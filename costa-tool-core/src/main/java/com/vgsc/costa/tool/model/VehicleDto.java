package com.vgsc.costa.tool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto {

    public VehicleDto(){}

    public VehicleDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;

    private String name;

}
