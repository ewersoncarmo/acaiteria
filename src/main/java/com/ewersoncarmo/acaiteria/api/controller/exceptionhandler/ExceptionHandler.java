package com.ewersoncarmo.acaiteria.api.controller.exceptionhandler;

import org.springframework.http.ResponseEntity;

import com.ewersoncarmo.acaiteria.api.dto.response.ResponseDTO;

public interface ExceptionHandler<T extends Exception> {

	ResponseEntity<ResponseDTO<Object>> handleException(T exception);
	
}
