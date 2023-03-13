package com.acrismatic.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acrismatic.dto.MaquinaDto;
import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.Maquina;
import com.acrismatic.repository.MaquinaRepository;
import com.acrismatic.service.MaquinaService;

@Service
public class MaquinaServiceImpl implements MaquinaService{
	
	@Autowired
	private MaquinaRepository maquinaRepository;
	
	@Override
	public RespuestaMensajeDTO crearMaquina(MaquinaDto maquina) {
		ModelMapper modelMapper = new ModelMapper();
		RespuestaMensajeDTO respuestaMensajeDTO = new RespuestaMensajeDTO();
		try {
			if(maquina.equals(null)) {
				throw new IllegalArgumentException("Los Datos no pueden estar vacios");
			}
			maquinaRepository.save(modelMapper.map(maquina, Maquina.class));
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.CREATED.value());
			respuestaMensajeDTO.setMensage("Maquina creada con éxito");
		} catch (Exception e) {
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuestaMensajeDTO.setMensage(e.getMessage());
		}
		
		
		return respuestaMensajeDTO;
	}

}
