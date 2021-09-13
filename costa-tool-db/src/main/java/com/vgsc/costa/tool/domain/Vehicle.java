package com.vgsc.costa.tool.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    public Vehicle(){}

    public Vehicle(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    private String id;

    @Column(name = "name")
    private String name;
}
