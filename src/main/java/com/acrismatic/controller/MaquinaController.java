package com.acrismatic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrismatic.dto.MaquinaDto;
import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.service.MaquinaService;

@RestController
@RequestMapping("/api/v1")
public class MaquinaController {
	@Autowired
	private MaquinaService maquinaService;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/crearMaquina")
	public RespuestaMensajeDTO crearMaquina(@Validated @RequestBody MaquinaDto maquinaGuadar) {
		return maquinaService.crearMaquina(maquinaGuadar);
	}
}
