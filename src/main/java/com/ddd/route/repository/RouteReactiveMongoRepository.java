package com.ddd.route.repository;

import com.ddd.route.repository.document.RouteDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RouteReactiveMongoRepository extends
		ReactiveMongoRepository<RouteDocument, String> {

}
