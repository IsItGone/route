package com.ddd.route.repository;

import com.ddd.route.model.RouteMapper;
import com.ddd.route.service.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class RouteMongoRepository implements RouteRepository {

	private final RouteReactiveMongoRepository reactiveMongoRepository;
	private final RouteMapper routeMapper;

	@Override
	public Mono<Route> findById(String id) {
		return reactiveMongoRepository.findById(id).map(routeMapper::toRoute);
	}

	@Override
	public Flux<Route> findAll() {
		return reactiveMongoRepository.findAll().map(routeMapper::toRoute);
	}

	@Override
	public Mono<Route> save(Route route) {
		return reactiveMongoRepository.save(routeMapper.toRouteDocument(route))
				.map(routeMapper::toRoute);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return reactiveMongoRepository.deleteById(id);
	}

}
