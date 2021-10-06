package com.vgsc.costa.tool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class VehicleUpdate {
    private String id;
    private String name;
    private String createdOn;
}
