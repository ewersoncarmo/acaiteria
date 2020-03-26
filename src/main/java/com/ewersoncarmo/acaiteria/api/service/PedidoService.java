package com.ewersoncarmo.acaiteria.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewersoncarmo.acaiteria.api.domain.Acai;
import com.ewersoncarmo.acaiteria.api.domain.Adicionais;
import com.ewersoncarmo.acaiteria.api.domain.Adicional;
import com.ewersoncarmo.acaiteria.api.domain.Pedido;
import com.ewersoncarmo.acaiteria.api.domain.Sabor;
import com.ewersoncarmo.acaiteria.api.domain.Tamanho;
import com.ewersoncarmo.acaiteria.api.dto.request.PedidoRequestDTO;
import com.ewersoncarmo.acaiteria.api.dto.request.PersonalizacaoRequestDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.AcaiResponseDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.AdicionalResponseDTO;
import com.ewersoncarmo.acaiteria.api.dto.response.PedidoResponseDTO;
import com.ewersoncarmo.acaiteria.api.persistence.PedidoRepository;
import com.ewersoncarmo.acaiteria.api.service.exception.ServiceException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PedidoResponseDTO escolher(PedidoRequestDTO pedidoRequestDTO) {
		Pedido pedido = modelMapper.map(pedidoRequestDTO, Pedido.class);
		
		Tamanho tamanho = Tamanho.valueOf(pedido.getAcai().getTamanho());
		Sabor sabor = Sabor.valueOf(pedido.getAcai().getSabor());
		
		pedido.setTempoPreparo(tamanho.getTempoPreparo() + sabor.getTempoExtra());
		pedido.setValorTotal(tamanho.getValor());
		
		pedidoRepository.save(pedido);
		
		return modelMapper.map(pedido, PedidoResponseDTO.class);
	}

	public void personalizar(Long id, PersonalizacaoRequestDTO personalizacaoRequestDTO) {
		List<Adicionais> adicionais = personalizacaoRequestDTO.getAdicionais()
			.stream()
			.map(a -> modelMapper.map(a, Adicionais.class))
			.collect(Collectors.toList());
		
		Pedido pedido = findById(id);
		
		Acai acai = pedido.getAcai();
		
		acai.setAdicionais(adicionais);
		adicionais.forEach(a -> a.setAcai(acai));
		
		acai.getAdicionais().forEach(a -> {
			Adicional personalizacao = Adicional.valueOf(a.getAdicional());
			
			pedido.setTempoPreparo(pedido.getTempoPreparo() + personalizacao.getTempoPreparo());
			pedido.setValorTotal(pedido.getValorTotal() + personalizacao.getValor());
		});
		
		pedidoRepository.save(pedido);
	}

	public PedidoResponseDTO montar(Long id) {
		Pedido pedido = findById(id);
		Acai acai = pedido.getAcai();

		Tamanho tamanho = Tamanho.valueOf(acai.getTamanho());
		Sabor sabor = Sabor.valueOf(acai.getSabor());

		AcaiResponseDTO acaiResponseDTO = new AcaiResponseDTO();
		acaiResponseDTO.setTamanho(tamanho.getDescricao());
		acaiResponseDTO.setSabor(sabor.getDescricao());
		acaiResponseDTO.setValorItem(tamanho.getValor());
		acaiResponseDTO.setAdicionais(acai.getAdicionais()
				.stream()
				.map(a -> {
					Adicional valueOf = Adicional.valueOf(a.getAdicional());

					AdicionalResponseDTO adicional = new AdicionalResponseDTO();
					adicional.setAdicional(valueOf.getDescricao());
					adicional.setValorItem(valueOf.getValor());
					
					return adicional;
				})
				.collect(Collectors.toList()));
		
		PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
		pedidoResponseDTO.setId(pedido.getId());
		pedidoResponseDTO.setAcai(acaiResponseDTO);
		pedidoResponseDTO.setTempoPreparo(pedido.getTempoPreparo());
		pedidoResponseDTO.setValorTotal(pedido.getValorTotal());
		
		return pedidoResponseDTO;
	}

	private Pedido findById(Long id) {
		return pedidoRepository.findById(id)
				.orElseThrow(() -> new ServiceException("M-1", id));
	}
}
