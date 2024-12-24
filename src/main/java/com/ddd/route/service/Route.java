package com.ddd.route.service;

import java.util.List;

public record Route(String id, String name, List<StationInfo> departureStations,
					List<StationInfo> arrivalStations) {

}
