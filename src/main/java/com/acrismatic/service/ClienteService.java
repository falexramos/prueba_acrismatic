package com.acrismatic.service;

import com.acrismatic.dto.ClienteDto;
import com.acrismatic.dto.RespuestaMensajeDTO;

public interface ClienteService {
	
	RespuestaMensajeDTO crearCliente(ClienteDto cliente);
}
