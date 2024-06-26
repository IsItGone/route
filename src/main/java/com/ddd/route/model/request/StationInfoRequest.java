package com.ddd.route.model.request;

import lombok.Builder;

@Builder
public record StationInfoRequest(String stationId, String stopTime) {

}
