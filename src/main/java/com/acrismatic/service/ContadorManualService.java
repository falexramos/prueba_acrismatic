package com.acrismatic.service;

import java.time.LocalDate;
import java.util.List;

import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.ContadorManual;

public interface ContadorManualService {
	
	List<ContadorManual> findByDate(LocalDate fechaInicio, LocalDate fechaFin);

	RespuestaMensajeDTO crearContadorManual(ContadorManual contadoresManualesDto);
	
	
}
