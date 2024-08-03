package com.ddd.route.model.response;

public record ErrorResponse(String error) {

	public static ErrorResponse create(String message) {
		return new ErrorResponse(message);
	}
}
