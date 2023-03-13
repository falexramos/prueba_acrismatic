package com.acrismatic.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contadores_automaticos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContadorAutomatico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private Maquina maquina;

    private Integer entradasAutomaticas;

    private Integer salidasAutomaticas;

    private LocalDateTime  fecha;

}
