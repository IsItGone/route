package com.ddd.route.model.response;

import java.util.List;
import lombok.Builder;

@Builder
public record RouteResponse(String id, String name, List<StationInfoResponse> departureStations,
							List<StationInfoResponse> arrivalStations) {

}
