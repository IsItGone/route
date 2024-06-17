package com.ddd.route.model.request;

import java.util.List;

public record RouteCreate(String name, List<String> stations) {

}
