package com.ddd.route.controller;

import com.ddd.route.model.RouteCreate;
import com.ddd.route.model.RouteResponse;
import com.ddd.route.model.RouteUpdate;
import com.ddd.route.service.RouteService;
import com.ddd.route.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> healthCheck() {
        return Mono.just("OK");
    }

    @GetMapping("/routes/{routeId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<RouteResponse> getRoute(@PathVariable String routeId) {
        return routeService.getRouteById(routeId).map(RouteResponse::convert);
    }

    @GetMapping("/routes")
    @ResponseStatus(HttpStatus.OK)
    public Flux<RouteResponse> getRoutes() {
        return routeService.getRoutes().map(RouteResponse::convert);
    }

    @PostMapping("/routes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> createRoute(@RequestBody RouteCreate routeCreate) {
        return routeService.createRoute(routeCreate).then();
    }

    @PutMapping("/routes")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> updateRoute(@RequestBody RouteUpdate routeUpdate) {
        return routeService.updateRoute(routeUpdate).then();
    }

    @DeleteMapping("/routes/{routeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRoute(@PathVariable String routeId) {
        return routeService.deleteRouteById(routeId).then();
    }

    }

}
