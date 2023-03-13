package com.acrismatic.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acrismatic.dto.ClienteDto;
import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.Cliente;
import com.acrismatic.repository.ClienteRepository;
import com.acrismatic.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public RespuestaMensajeDTO crearCliente(ClienteDto cliente) {
		
		ModelMapper modelMapper = new ModelMapper();
		RespuestaMensajeDTO respuestaMensajeDTO = new RespuestaMensajeDTO();
		try {
			if(cliente.equals(null)) {
				throw new IllegalArgumentException("Los Datos no pueden estar vacios");
			}
			clienteRepository.save(modelMapper.map(cliente, Cliente.class));
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.CREATED.value());
			respuestaMensajeDTO.setMensage("Cliente creado con éxito");
		} catch (Exception e) {
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuestaMensajeDTO.setMensage(e.getMessage());
		}
		
		
		return respuestaMensajeDTO;
	}

}
