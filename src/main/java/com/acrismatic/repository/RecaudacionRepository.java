package com.acrismatic.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acrismatic.model.Recaudacion;

@Repository
public interface RecaudacionRepository extends JpaRepository<Recaudacion, Long> {

	 @Query("SELECT r FROM Recaudacion r WHERE r.fecha >= :fechaInicio AND r.fecha <= :fechaFin ")
	    List<Recaudacion> findByDate(
	            @Param("fechaInicio") LocalDateTime  fechaInicio,
	            @Param("fechaFin") LocalDateTime  fechaFin);

}
