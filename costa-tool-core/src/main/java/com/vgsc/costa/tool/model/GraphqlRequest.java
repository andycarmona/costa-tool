package com.vgsc.costa.tool.model;

import lombok.Data;

@Data
public class GraphqlRequest {

    private String query;
    private Object variables;
}