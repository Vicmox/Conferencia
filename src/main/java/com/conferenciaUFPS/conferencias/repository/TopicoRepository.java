package com.conferenciaUFPS.conferencias.repository;

import com.conferenciaUFPS.conferencias.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{
    
}
