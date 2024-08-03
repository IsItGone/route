package com.ddd.route.exception;

import com.ddd.route.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
public class AdviceController {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Mono<ErrorResponse> routeNotFoundException(RouteNotFoundException e) {
		log.error(ErrorCode.ROUTE_NOT_FOUND.getMessage(), e.fillInStackTrace());
		return Mono.just(ErrorResponse.create(ErrorCode.ROUTE_NOT_FOUND.getMessage()));
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Mono<ErrorResponse> exception(Exception e) {
		log.error(ErrorCode.UNKNOWN_ERROR.getMessage(), e.fillInStackTrace());
		return Mono.just(ErrorResponse.create(ErrorCode.UNKNOWN_ERROR.getMessage()));
	}
}
