package com.acrismatic.dto;

import lombok.Data;
@Data
public class RecaudacionIrregularDto {
	private long idRecaudacion;
	private long idManual;
    private long idAutomatico;
    private ContadoresManualesDto manuales;
    private ContadoresAutomaticosDto automaticos;
}
