package com.ddd.route.service;

import com.ddd.route.model.request.RouteCreate;
import com.ddd.route.model.request.RouteUpdate;
import com.ddd.route.model.response.RouteResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteService {

	Mono<RouteResponse> getRouteById(String id);

	Flux<RouteResponse> getRoutes();

	Mono<String> createRoute(RouteCreate routeCreate);

	Mono<Void> updateRoute(RouteUpdate routeUpdate);

	Mono<Void> deleteRouteById(String id);
}

