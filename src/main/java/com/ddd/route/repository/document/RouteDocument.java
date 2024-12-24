package com.ddd.route.repository.document;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "routes")
@Getter
@Builder
public class RouteDocument {

	@Id
	private String id;
	private String name;
	private List<StationDocumentInfo> departureStations;
	private List<StationDocumentInfo> arrivalStations;
}
