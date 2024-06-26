package com.ddd.route.model;

import com.ddd.route.model.entity.Route;
import com.ddd.route.model.entity.StationInfo;
import com.ddd.route.model.request.RouteCreate;
import com.ddd.route.model.request.RouteUpdate;
import com.ddd.route.model.response.RouteResponse;
import com.ddd.route.model.response.StationInfoResponse;
import org.bson.types.ObjectId;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RouteMapper {

	Route toEntity(RouteCreate routeCreate);

	Route toEntity(RouteUpdate routeUpdate);

	RouteResponse toResponse(Route route);

	StationInfoResponse toResponse(StationInfo stationInfo);

	default ObjectId stringToObjectId(String id) {
		return new ObjectId(id);
	}

	default String objectIdToString(ObjectId objectId) {
		return objectId.toString();
	}

}
