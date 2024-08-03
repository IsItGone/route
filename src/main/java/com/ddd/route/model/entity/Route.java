package com.ddd.route.model.entity;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "routes")
@Getter
@Builder
public class Route {

	@Id
	private String id;
	private String name;
	private List<StationInfo> departureStations;
	private List<StationInfo> arrivalStations;
}
