package com.ddd.route.model;

import com.ddd.route.Route;
import java.util.List;
import lombok.Builder;
import org.bson.types.ObjectId;

@Builder
public record RouteResponse(String id, String name, List<String> stations) {

    public static RouteResponse convert(Route route) {
        return RouteResponse.builder()
                .id(route.getId())
                .name(route.getName())
                .stations(route.getStations().stream().map(ObjectId::toString).toList())
                .build();
    }

}
