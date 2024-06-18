package com.ddd.route.model;

import com.ddd.route.Route;
import com.ddd.route.model.request.RouteCreate;
import com.ddd.route.model.request.RouteUpdate;
import com.ddd.route.model.response.RouteResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RouteMapper {

	Route toEntity(RouteCreate routeCreate);

	Route toEntity(RouteUpdate routeUpdate);

	RouteResponse toResponse(Route route);

	default List<String> objectIdListToStringList(List<ObjectId> list) {
		return Optional.ofNullable(list).orElse(Collections.emptyList())
				.stream().map(ObjectId::toString).toList();
	}

	default List<ObjectId> stringListToObjectIdList(List<String> list) {
		return Optional.ofNullable(list).orElse(Collections.emptyList())
				.stream().map(ObjectId::new).toList();
	}

	default ObjectId stringToObjectId(String id) {
		return new ObjectId(id);
	}

	default String objectIdToString(ObjectId objectId) {
		return objectId.toString();
	}

}
