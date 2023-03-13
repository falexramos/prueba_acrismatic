package com.acrismatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrismatic.model.ContadorAutomatico;

@Repository
public interface ContadorAutomaticoRepository extends JpaRepository<ContadorAutomatico, Long> {
}
