package com.ddd.route.model;

import com.ddd.route.Route;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;

public record RouteCreate(String name, List<String> stations) {

    public Route convert() {
        return Route.builder()
                .name(name)
                .stations(Optional.ofNullable(stations)
                        .orElse(Collections.emptyList()).stream()
                        .map(ObjectId::new).toList())
                .build();
    }

}
