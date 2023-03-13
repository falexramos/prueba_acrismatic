package com.acrismatic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.ContadorManual;
import com.acrismatic.service.ContadorManualService;

@RestController
@RequestMapping("/api/v1")
public class ContadorManualController {

	@Autowired
	private ContadorManualService contadorManualService;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/crearContadorManual")
	public RespuestaMensajeDTO crearContadorManual(@Validated  @RequestBody ContadorManual ContadoresManualesDto) {
		return contadorManualService.crearContadorManual(ContadoresManualesDto);
	}
}
