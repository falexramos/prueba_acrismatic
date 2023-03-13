package com.acrismatic.service.impl;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.acrismatic.dto.RecaudacionResponseDto;
import com.acrismatic.model.ContadorAutomatico;
import com.acrismatic.model.ContadorManual;
import com.acrismatic.model.Maquina;
import com.acrismatic.model.Recaudacion;
import com.acrismatic.repository.ContadorAutomaticoRepository;
import com.acrismatic.repository.RecaudacionRepository;
import com.acrismatic.service.RecaudacionService;

@RunWith(MockitoJUnitRunner.class)
public class RecaudacionServiceImplTest {


	@Mock
	private RecaudacionRepository recaudacionRepository;
	
	@Mock
	private ContadorAutomaticoRepository contadorAutomaticoRepository;
	
	@InjectMocks
	private RecaudacionService recaudacionService;
	
	@Test
	public void testGetRecaudacionesIrregulares() {
		
		
		LocalDate fechaInicio = LocalDate.parse("2022-01-01");
		LocalDate fechaFin = LocalDate.parse("2022-01-31");
		
		
		ContadorManual contadorManual = new ContadorManual();
		Maquina maquina = new Maquina();
		maquina.setNombre("maquina1");
		contadorManual.setMaquina(maquina);
		contadorManual.setEntradasManuales(100);
		contadorManual.setSalidasManuales(99);
		
		Recaudacion recaudacion = new Recaudacion();
		recaudacion.setId(1L);
		recaudacion.setContadorManual(contadorManual);
		
		ContadorAutomatico contadorAutomatico = new ContadorAutomatico();
		contadorAutomatico.setId(1L);
		contadorAutomatico.setMaquina(maquina);
		contadorAutomatico.setEntradasAutomaticas(100);
		contadorAutomatico.setSalidasAutomaticas(98);
		
		List<Recaudacion> recaudaciones = new ArrayList<>();
		recaudaciones.add(recaudacion);
		
		List<ContadorAutomatico> automaticos = new ArrayList<>();
		automaticos.add(contadorAutomatico);
		
		// Mockear comportamiento del repositorio
		when(recaudacionRepository.findByDate(
			fechaInicio.atStartOfDay(),
			fechaFin.atTime(LocalTime.MAX)
		)).thenReturn(recaudaciones);
		
		when(contadorAutomaticoRepository.findAll()).thenReturn(automaticos);
		
		
		RecaudacionResponseDto result = recaudacionService.recaudaciones(fechaInicio, fechaFin);
		
		long entradasManuales=100L;
		
		Assert.assertNotNull(result);
		Assert.assertEquals(maquina, result.getMaquina());
		
		Assert.assertEquals(1L, result.getRecaudacionesIrregulares().getIdRecaudacion());
		Assert.assertEquals(1L, result.getRecaudacionesIrregulares().getIdManual());
		Assert.assertEquals(1L, result.getRecaudacionesIrregulares().getIdAutomatico());

		Assert.assertEquals((Object) entradasManuales, (Object) result.getRecaudacionesIrregulares().getManuales().getEntradasManuales());
		Assert.assertEquals((Object) 99L, result.getRecaudacionesIrregulares().getManuales().getSalidasManuales());
		Assert.assertEquals((Object) 100, (Object) result.getRecaudacionesIrregulares().getAutomaticos().getEntradasAutomaticas());
		Assert.assertEquals((Object)98L, result.getRecaudacionesIrregulares().getAutomaticos().getSalidasAutomaticas());

	}	
}
