package com.ddd.route.model;

import com.ddd.route.Route;
import java.util.List;

public record RouteUpdate(String id, String name, List<String> stations) {

    public Route convert() {
        return Route.builder()
                .id(id)
                .name(name)
                .stations(stations)
                .build();
    }
}
