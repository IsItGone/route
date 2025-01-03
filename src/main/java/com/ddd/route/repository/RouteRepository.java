package com.ddd.route.repository;

import com.ddd.route.service.Route;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteRepository {

	Mono<Route> findById(String id);

	Flux<Route> findAll();

	Mono<Route> save(Route route);

	Mono<Void> deleteById(String id);
}
