package com.acrismatic.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acrismatic.dto.ContadoresAutomaticosDto;
import com.acrismatic.dto.ContadoresManualesDto;
import com.acrismatic.dto.RecaudacionIrregularDto;
import com.acrismatic.dto.RecaudacionResponseDto;
import com.acrismatic.dto.RespuestaMensajeDTO;
import com.acrismatic.model.ContadorAutomatico;
import com.acrismatic.model.Recaudacion;
import com.acrismatic.repository.ContadorAutomaticoRepository;
import com.acrismatic.repository.RecaudacionRepository;
import com.acrismatic.service.RecaudacionService;

@Service
public class RecaudacionServiceImpl implements RecaudacionService {

	@Autowired
	private RecaudacionRepository recaudacionRepository;

	@Autowired
	private ContadorAutomaticoRepository ContadorAutomaticoRepository;

	@Override
	public RecaudacionResponseDto recaudaciones(LocalDate fechaInicio, LocalDate fechaFin) {
		RecaudacionResponseDto recaudacionResponseDto = new RecaudacionResponseDto();
		RecaudacionIrregularDto recaudacionIrregularDto = new RecaudacionIrregularDto();
		List<Recaudacion> recaudaciones = recaudacionRepository.findByDate(fechaInicio.atStartOfDay(),
				fechaFin.atTime(LocalTime.MAX));
		
		if(recaudaciones.isEmpty()) {
			throw new IllegalArgumentException("Las recaudaciones estan vacías.");
		}//else if(recaudaciones.size()>1) {
		//	throw new IllegalArgumentException("Las recaudaciones devulve mas de un valor.");
		//}
		
		
		List<ContadorAutomatico> automaticos = ContadorAutomaticoRepository.findAll();
		List<ContadorAutomatico> automaticosFiltro = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		
		for (Recaudacion recaudacion : recaudaciones) {
			automaticosFiltro = automaticos.stream()
					.filter(a -> a.getMaquina().equals(recaudacion.getContadorManual().getMaquina()))
					.filter(a -> a.getEntradasAutomaticas()
							.equals(recaudacion.getContadorManual().getEntradasManuales()))
					.filter(a -> a.getSalidasAutomaticas().equals(recaudacion.getContadorManual().getSalidasManuales()))
					.collect(Collectors.toList());
			
			recaudacionIrregularDto.setIdRecaudacion(recaudacion.getId());
			recaudacionIrregularDto.setIdManual(recaudacion.getContadorManual().getId());
			
			recaudacionIrregularDto.setManuales(modelMapper.map(recaudacion.getContadorManual(), ContadoresManualesDto.class));
			
		}
		
		Collections.sort(automaticos, Comparator.comparing(ContadorAutomatico::getId));
		
		int index = automaticos.indexOf(automaticosFiltro.get(0));
		int prevIndex = index > 0 ? index - 1 : -1;
		
		if (prevIndex != -1) {
			automaticos.get(prevIndex);
			recaudacionResponseDto.setMaquina(automaticos.get(prevIndex).getMaquina().getNombre());
			recaudacionResponseDto.setCliente(automaticos.get(prevIndex).getMaquina().getCliente().getNombre());
			recaudacionIrregularDto.setIdAutomatico(automaticos.get(prevIndex).getId());
			recaudacionIrregularDto.setAutomaticos(modelMapper.map(automaticos.get(prevIndex), ContadoresAutomaticosDto.class));
		}
		
		recaudacionResponseDto.setRecaudacionesIrregulares(recaudacionIrregularDto);
		
		return recaudacionResponseDto;
	}

	@Override
	public RespuestaMensajeDTO crearRecaudacion(Recaudacion recaudacionGuadar) {
		RespuestaMensajeDTO respuestaMensajeDTO = new RespuestaMensajeDTO();
		try {
			if(recaudacionGuadar.equals(null)) {
				throw new IllegalArgumentException("Los Datos no pueden estar vacios");
			}
			recaudacionRepository.save(recaudacionGuadar);
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.CREATED.value());
			respuestaMensajeDTO.setMensage("Recaudacion creado con éxito");
		} catch (Exception e) {
			respuestaMensajeDTO.setCodigoStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuestaMensajeDTO.setMensage(e.getMessage());
		}
		
		
		return respuestaMensajeDTO;
	}


}
