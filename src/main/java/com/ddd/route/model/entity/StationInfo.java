package com.ddd.route.model.entity;

import lombok.Builder;
import org.bson.types.ObjectId;

@Builder
public record StationInfo(ObjectId stationId, String stopTime) {

}
