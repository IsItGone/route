package com.ddd.route.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteService {

	Mono<Route> getRouteById(String id);

	Flux<Route> getRoutes();

	Mono<Void> upsertRoute(Route route);

	Mono<Void> deleteRouteById(String id);
}

