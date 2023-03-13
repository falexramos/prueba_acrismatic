package com.acrismatic.dto;

import lombok.Data;

@Data
public class RecaudacionResponseDto {
	private String maquina;
	private String cliente;
	private RecaudacionIrregularDto recaudacionesIrregulares;
	
	
}
