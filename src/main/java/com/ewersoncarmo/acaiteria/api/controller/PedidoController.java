package com.ewersoncarmo.acaiteria.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ewersoncarmo.acaiteria.api.dto.request.PedidoRequestDTO;
import com.ewersoncarmo.acaiteria.api.dto.request.PersonalizacaoRequestDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.PedidoResponseDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.ResponseDTO;
import com.ewersoncarmo.acaiteria.api.service.PedidoService;

@RestController
@RequestMapping("/api/v1/acai")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/escolher")
	public ResponseEntity<Void> escolher(@Valid @RequestBody PedidoRequestDTO pedidoRequestDTO) {
		PedidoResponseDTO pedidoResponseDTO = pedidoService.escolher(pedidoRequestDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(pedidoResponseDTO.getId())
			.toUri();
		
		return ResponseEntity.created(uri)
				.build();
	}
	
	@PostMapping("/{id}/personalizar")
	public ResponseEntity<Void> personalizar(@Valid @RequestBody PersonalizacaoRequestDTO personalizacaoRequestDTO,
			@PathVariable("id") Long id) {
		pedidoService.personalizar(id, personalizacaoRequestDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}
	
	@GetMapping("/{id}/montar")
	public ResponseEntity<ResponseDTO<PedidoResponseDTO>> montar(@PathVariable("id") Long id) {
		PedidoResponseDTO pedidoResponseDTO = pedidoService.montar(id);
		
		return ResponseEntity.ok()
				.body(new ResponseDTO<>(pedidoResponseDTO));
	}
}
