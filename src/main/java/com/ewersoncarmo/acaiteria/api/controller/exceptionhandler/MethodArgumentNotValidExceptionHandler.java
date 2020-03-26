package com.ewersoncarmo.acaiteria.api.controller.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.ewersoncarmo.acaiteria.api.dto.response.ErroResponseDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.ResponseDTO;

@Component
public class MethodArgumentNotValidExceptionHandler implements ExceptionHandler<MethodArgumentNotValidException> {

	@Override
	public ResponseEntity<ResponseDTO<Object>> handleException(MethodArgumentNotValidException exception) {
		List<ErroResponseDTO> erros = exception.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(f -> {
					ErroResponseDTO erroResponseDTO = new ErroResponseDTO();
					erroResponseDTO.setCampo(f.getField());
					erroResponseDTO.setMensagem(String.format("Campo %s %s", f.getField(), f.getDefaultMessage()));
					
					return erroResponseDTO;
				})
				.collect(Collectors.toList());
		
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				 .body(ResponseDTO.comErros(erros));
	}

}
