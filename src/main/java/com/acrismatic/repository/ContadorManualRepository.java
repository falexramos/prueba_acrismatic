package com.acrismatic.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acrismatic.model.ContadorManual;

@Repository
public interface ContadorManualRepository extends JpaRepository<ContadorManual, Long> {

	
	@Query("SELECT cm FROM ContadorManual cm WHERE cm.fecha BETWEEN :fechaInicio AND :fechaFin")
	List<ContadorManual> findByDate(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
	
}
