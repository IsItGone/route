package com.ddd.route.model.request;

import java.util.List;

public record RouteUpdate(String id, String name, List<StationInfoRequest> departureStations,
						  List<StationInfoRequest> arrivalStations) {

}
