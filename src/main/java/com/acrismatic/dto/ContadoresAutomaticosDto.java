package com.acrismatic.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ContadoresAutomaticosDto {
    private Long entradasAutomaticas;
    private Long salidasAutomaticas;
    private LocalDateTime fecha;
}
