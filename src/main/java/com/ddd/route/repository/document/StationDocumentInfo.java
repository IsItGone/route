package com.ddd.route.repository.document;

import lombok.Builder;
import org.bson.types.ObjectId;

@Builder
public record StationDocumentInfo(ObjectId stationId, String stopTime) {

}
