package com.acrismatic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrismatic.dto.ClienteDto;
import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.service.ClienteService;

@RestController
@RequestMapping("/api/v1")
public class ClienteContorller {

	@Autowired
	private ClienteService clienteService;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/crearCliente")
	public RespuestaMensajeDTO crearCliente(@Validated  @RequestBody ClienteDto clienteGuadar) {
		return clienteService.crearCliente(clienteGuadar);
	}
}
