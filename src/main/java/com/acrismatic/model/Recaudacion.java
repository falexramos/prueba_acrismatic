package com.acrismatic.model;

import java.math.BigDecimal;
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
@Table(name = "recaudaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recaudacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal importe;
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "contadores_manuales_id", nullable = false)
	private ContadorManual contadorManual;
	
	@ManyToOne
	@JoinColumn(name = "maquina_id", nullable = false)
	private Maquina maquina;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

}
