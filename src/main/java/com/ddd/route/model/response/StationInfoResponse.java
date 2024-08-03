package com.ddd.route.model.response;

import lombok.Builder;

@Builder
public record StationInfoResponse(String stationId, String stopTime) {

}
