package com.ddd.route.model;

import com.ddd.route.Route;
import com.ddd.route.model.request.RouteCreate;
import com.ddd.route.model.request.RouteUpdate;
import com.ddd.route.model.response.RouteResponse;
import java.util.Collections;
import java.util.Optional;
import org.bson.types.ObjectId;

public class RouteConverter {

	public static Route toEntity(RouteCreate routeCreate) {
		return Route.builder()
				.name(routeCreate.name())
				.stations(Optional.ofNullable(routeCreate.stations())
						.orElse(Collections.emptyList()).stream()
						.map(ObjectId::new).toList())
				.build();
	}

	public static Route toEntity(RouteUpdate routeUpdate) {
		return Route.builder()
				.id(routeUpdate.id())
				.name(routeUpdate.name())
				.stations(Optional.ofNullable(routeUpdate.stations())
						.orElse(Collections.emptyList()).stream()
						.map(ObjectId::new).toList())
				.build();
	}

	public static RouteResponse toResponse(Route route) {
		return RouteResponse.builder()
				.id(route.getId())
				.name(route.getName())
				.stations(route.getStations().stream().map(ObjectId::toString).toList())
				.build();
	}
}
