package com.ddd.route.controller;

import com.ddd.route.exception.RouteNotFoundException;
import com.ddd.route.model.RouteMapper;
import com.ddd.route.model.request.RouteCreate;
import com.ddd.route.model.request.RouteUpdate;
import com.ddd.route.model.response.RouteResponse;
import com.ddd.route.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@Slf4j
public class RouteController {

	private final RouteService routeService;
	private final RouteMapper routeMapper;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> healthCheck() {
		return Mono.just("OK");
	}

	@GetMapping("/error")
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> errorCheck() {
		return Mono.error(RouteNotFoundException::new);
	}

	@GetMapping("/routes/{routeId}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<RouteResponse> getRoute(@PathVariable String routeId) {
		return routeService.getRouteById(routeId).map(routeMapper::toRouteResponse);
	}

	@GetMapping("/routes")
	@ResponseStatus(HttpStatus.OK)
	public Flux<RouteResponse> getRoutes() {
		return routeService.getRoutes().map(routeMapper::toRouteResponse);
	}

	@PostMapping("/routes")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Void> createRoute(@RequestBody RouteCreate routeCreate) {
		return routeService.upsertRoute(routeMapper.toRoute(routeCreate)).then();
	}

	@PutMapping("/routes")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Void> updateRoute(@RequestBody RouteUpdate routeUpdate) {
		return routeService.upsertRoute(routeMapper.toRoute(routeUpdate)).then();
	}

	@DeleteMapping("/routes/{routeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteRoute(@PathVariable String routeId) {
		return routeService.deleteRouteById(routeId).then();
	}

}
