package com.acrismatic.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acrismatic.dto.RecaudacionResponseDto;
import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.Recaudacion;
import com.acrismatic.service.RecaudacionService;

@RestController
@RequestMapping("/api/v1")
public class RecaudacionesContorller {

	@Autowired
	private RecaudacionService recaudacionService;

	@CrossOrigin(origins = "*")
	@GetMapping("/recaudaciones")
	public RecaudacionResponseDto getRecaudacionesIrregulares(
			@RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
			@RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
		return recaudacionService.recaudaciones(fechaInicio, fechaFin);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/crearRecaudacion")
	public RespuestaMensajeDTO crearRecaudacion(@Validated  @RequestBody Recaudacion recaudacionGuadar) {
		return recaudacionService.crearRecaudacion(recaudacionGuadar);
	}

}
