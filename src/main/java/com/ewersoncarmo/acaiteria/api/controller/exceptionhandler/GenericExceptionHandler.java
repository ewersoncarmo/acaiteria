package com.ewersoncarmo.acaiteria.api.controller.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ewersoncarmo.acaiteria.api.dto.response.ErroResponseDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.ResponseDTO;

@Component
public class GenericExceptionHandler implements ExceptionHandler<Exception> {

	@Autowired
	private MessageSource messageSource;

    @Override
	public ResponseEntity<ResponseDTO<Object>> handleException(Exception exception) {
		String mensagem = messageSource.getMessage("M-2", null, LocaleContextHolder.getLocale());
		
		ErroResponseDTO erro = new ErroResponseDTO("M-2: " + mensagem);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ResponseDTO.comErro(erro));
	}

}
