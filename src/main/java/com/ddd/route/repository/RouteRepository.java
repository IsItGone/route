package com.ddd.route.repository;

import com.ddd.route.model.entity.Route;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RouteRepository extends ReactiveMongoRepository<Route, String>, RouteTemplate {

}
