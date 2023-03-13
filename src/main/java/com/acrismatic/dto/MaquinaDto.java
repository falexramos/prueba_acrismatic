package com.acrismatic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaquinaDto {
	private Long id;
    private String nombre;
    private ClienteDto cliente;
}
