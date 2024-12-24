package com.ddd.route.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	ROUTE_NOT_FOUND("Route not found"),
	UNKNOWN_ERROR("Unknown error");

	private final String message;

}
