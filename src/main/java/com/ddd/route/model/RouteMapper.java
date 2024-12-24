package com.ddd.route.model;

import com.ddd.route.model.request.RouteCreate;
import com.ddd.route.model.request.RouteUpdate;
import com.ddd.route.model.response.RouteResponse;
import com.ddd.route.model.response.StationInfoResponse;
import com.ddd.route.repository.document.RouteDocument;
import com.ddd.route.repository.document.StationDocumentInfo;
import com.ddd.route.service.Route;
import org.bson.types.ObjectId;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RouteMapper {

	Route toRoute(RouteDocument routeDocument);

	Route toRoute(RouteCreate routeCreate);

	Route toRoute(RouteUpdate routeUpdate);

	RouteDocument toRouteDocument(Route route);

	RouteResponse toRouteResponse(Route route);

	StationInfoResponse toResponse(StationDocumentInfo stationDocumentInfo);

	default ObjectId stringToObjectId(String id) {
		return new ObjectId(id);
	}

	default String objectIdToString(ObjectId objectId) {
		return objectId.toString();
	}

}
