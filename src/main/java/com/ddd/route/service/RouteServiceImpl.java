package com.ddd.route.service;

import com.ddd.route.exception.RouteNotFoundException;
import com.ddd.route.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
@Slf4j
public class RouteServiceImpl implements RouteService {

	private final RouteRepository routeRepository;

	@Override
	public Mono<Route> getRouteById(String id) {
		return routeRepository.findById(id).switchIfEmpty(Mono.error(RouteNotFoundException::new));
	}

	@Override
	public Flux<Route> getRoutes() {
		return routeRepository.findAll();
	}

	@Override
	public Mono<Void> upsertRoute(Route route) {
		return routeRepository.save(route).then();
	}

	@Override
	public Mono<Void> deleteRouteById(String id) {
		return routeRepository.deleteById(id);
	}

}
