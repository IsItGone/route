package com.ddd.route.service;

import com.ddd.route.Route;
import com.ddd.route.model.RouteCreate;
import com.ddd.route.model.RouteUpdate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteService {

	Mono<Route> getRouteById(String id);

	Flux<Route> getRoutes();

	Mono<String> createRoute(RouteCreate routeCreate);

	Mono<Void> updateRoute(RouteUpdate routeUpdate);

	Mono<Void> deleteRouteById(String id);

	Mono<Void> addStationToRoute(String routeId, String stationId);

	Mono<Void> removeStationFromRoute(String routeId, String stationId);
}

