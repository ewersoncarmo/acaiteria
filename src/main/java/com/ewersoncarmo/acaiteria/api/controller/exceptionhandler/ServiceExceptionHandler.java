package com.ewersoncarmo.acaiteria.api.controller.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ewersoncarmo.acaiteria.api.dto.response.ErroResponseDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.ResponseDTO;
import com.ewersoncarmo.acaiteria.api.service.exception.ServiceException;

@Component
public class ServiceExceptionHandler implements ExceptionHandler<ServiceException> {

	@Autowired
	private MessageSource messageSource;

	@Override
	public ResponseEntity<ResponseDTO<Object>> handleException(ServiceException exception) {
		String mensagem = messageSource.getMessage(exception.getCodigoErro(), exception.getParametros(), LocaleContextHolder.getLocale());
		
		ErroResponseDTO erro = new ErroResponseDTO(exception.getCodigoErro() + ": " + mensagem);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseDTO.comErro(erro));
	}

}
