package com.ddd.route.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RouteTemplateImpl implements RouteTemplate {

    private final ReactiveMongoTemplate mongoTemplate;

}
