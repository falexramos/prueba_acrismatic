package com.acrismatic.service;


import java.time.LocalDate;

import com.acrismatic.dto.RecaudacionResponseDto;
import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.Recaudacion;


public interface RecaudacionService {
	RecaudacionResponseDto recaudaciones(LocalDate  fechaInicio, LocalDate  fechaFin);

	RespuestaMensajeDTO crearRecaudacion(Recaudacion recaudacionGuadar);
}
