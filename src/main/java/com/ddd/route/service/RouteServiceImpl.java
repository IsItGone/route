package com.ddd.route.service;

import com.ddd.route.Route;
import com.ddd.route.exception.RouteNotFoundException;
import com.ddd.route.model.RouteCreate;
import com.ddd.route.model.RouteUpdate;
import com.ddd.route.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
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
        return routeRepository.findById(id)
                .switchIfEmpty(Mono.error(RouteNotFoundException::new));
    }

    @Override
    public Flux<Route> getRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Mono<String> createRoute(RouteCreate routeCreate) {
        return routeRepository.insert(routeCreate.convert())
                .flatMap(route -> Mono.just(route.getId()));
    }

    @Override
    public Mono<Void> updateRoute(RouteUpdate routeUpdate) {
        return routeRepository.findById(routeUpdate.id())
                .switchIfEmpty(Mono.error(RouteNotFoundException::new))
                .flatMap(route -> routeRepository.save(routeUpdate.convert())).then();
    }

    @Override
    public Mono<Void> deleteRouteById(String id) {
        return routeRepository.deleteById(id);
    }

    @Override
    public Mono<Void> addStationToRoute(String routeId, String stationId) {
        return routeRepository.findById(routeId)
                .switchIfEmpty(Mono.error(RouteNotFoundException::new))
                .flatMap(route -> {
                    route.getStations().add(new ObjectId(stationId));
                    return routeRepository.save(route);
                }).then();
    }

    @Override
    public Mono<Void> removeStationFromRoute(String routeId, String stationId) {
        return routeRepository.findById(routeId)
                .switchIfEmpty(Mono.error(RouteNotFoundException::new))
                .flatMap(route -> {
                    route.getStations().remove(new ObjectId(stationId));
                    return routeRepository.save(route);
                }).then();
    }
    
}
