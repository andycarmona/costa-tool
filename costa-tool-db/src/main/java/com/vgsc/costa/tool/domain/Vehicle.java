package com.vgsc.costa.tool.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document
public class Vehicle {

    public Vehicle(){}

    public Vehicle(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    private String id;

    private String name;
}
