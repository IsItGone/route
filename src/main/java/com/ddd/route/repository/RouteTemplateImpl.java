package com.ddd.route.repository;

import com.ddd.route.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class RouteTemplateImpl implements RouteTemplate {

    private final ReactiveMongoTemplate mongoTemplate;

}
