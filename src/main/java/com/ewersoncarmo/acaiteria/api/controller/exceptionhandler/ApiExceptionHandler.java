package com.ewersoncarmo.acaiteria.api.controller.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ewersoncarmo.acaiteria.api.dto.response.ResponseDTO;
import com.ewersoncarmo.acaiteria.api.service.exception.ServiceException;

@ControllerAdvice
public class ApiExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);
	
	@Autowired
	private ServiceExceptionHandler serviceExceptionHandler;
	
	@Autowired
	private MethodArgumentNotValidExceptionHandler methodArgumentNotValidExceptionHandler;
	
	@Autowired
	private GenericExceptionHandler genericExceptionHandler;
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ResponseDTO<Object>> handleServiceException(ServiceException exception) {
		return serviceExceptionHandler.handleException(exception);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO<Object>> handleServiceException(MethodArgumentNotValidException exception) {
		return methodArgumentNotValidExceptionHandler.handleException(exception);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<Object>> handleException(Exception exception) {
	    LOG.error("Erro inesperado: ", exception);

	    return genericExceptionHandler.handleException(exception);
    }
}
