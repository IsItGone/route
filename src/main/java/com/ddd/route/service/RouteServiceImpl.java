package com.ddd.route.service;

import com.ddd.route.exception.RouteNotFoundException;
import com.ddd.route.model.RouteMapper;
import com.ddd.route.model.request.RouteCreate;
import com.ddd.route.model.request.RouteUpdate;
import com.ddd.route.model.response.RouteResponse;
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
	private final RouteMapper routeMapper;

	@Override
	public Mono<RouteResponse> getRouteById(String id) {
		return routeRepository.findById(id)
				.switchIfEmpty(Mono.error(RouteNotFoundException::new))
				.map(routeMapper::toResponse);
	}

	@Override
	public Flux<RouteResponse> getRoutes() {
		return routeRepository.findAll().map(routeMapper::toResponse);
	}

	@Override
	public Mono<String> createRoute(RouteCreate routeCreate) {
		return routeRepository.insert(routeMapper.toEntity(routeCreate))
				.flatMap(route -> Mono.just(route.getId()));
	}

	@Override
	public Mono<Void> updateRoute(RouteUpdate routeUpdate) {
		return routeRepository.findById(routeUpdate.id())
				.switchIfEmpty(Mono.error(RouteNotFoundException::new))
				.flatMap(route -> routeRepository.save(routeMapper.toEntity(routeUpdate)))
				.then();
	}

	@Override
	public Mono<Void> deleteRouteById(String id) {
		return routeRepository.deleteById(id);
	}

}
