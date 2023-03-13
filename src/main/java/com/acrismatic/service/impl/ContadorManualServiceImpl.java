package com.acrismatic.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.ContadorManual;
import com.acrismatic.repository.ContadorManualRepository;
import com.acrismatic.service.ContadorManualService;


@Service
public class ContadorManualServiceImpl implements ContadorManualService{
	
	@Autowired
	private ContadorManualRepository contadorManualRepository;
	
	@Override
	public List<ContadorManual> findByDate(LocalDate fechaInicio, LocalDate fechaFin) {
		return contadorManualRepository.findByDate(fechaInicio,fechaFin);
	}

	@Override
	public RespuestaMensajeDTO crearContadorManual(ContadorManual contadoresManualesDto) {
				
		RespuestaMensajeDTO respuestaMensajeDTO = new RespuestaMensajeDTO();
		try {
			if(contadoresManualesDto.equals(null)) {
				throw new IllegalArgumentException("Los Datos no pueden estar vacios");
			}
			contadorManualRepository.save(contadoresManualesDto);
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.CREATED.value());
			respuestaMensajeDTO.setMensage("Contador Manual creado con éxito");
		} catch (Exception e) {
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuestaMensajeDTO.setMensage(e.getMessage());
		}
		
		
		return respuestaMensajeDTO;
	}
	
}
