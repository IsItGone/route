package com.ddd.route.model.request;

import java.util.List;

public record RouteCreate(String name, List<StationInfoRequest> departureStations,
						  List<StationInfoRequest> arrivalStations) {

}
