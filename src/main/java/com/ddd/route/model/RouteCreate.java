package com.ddd.route.model;

import com.ddd.route.Route;
import java.util.List;

public record RouteCreate(String name, List<String> stations) {

    public Route convert() {
        return Route.builder()
                .name(name)
                .stations(stations)
                .build();
    }
}
