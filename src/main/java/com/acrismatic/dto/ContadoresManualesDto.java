package com.acrismatic.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ContadoresManualesDto {
    private Long entradasManuales;
    private Long salidasManuales;
    private LocalDateTime fecha;
}
