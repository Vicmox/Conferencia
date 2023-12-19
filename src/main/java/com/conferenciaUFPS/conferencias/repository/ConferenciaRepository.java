/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conferenciaUFPS.conferencias.repository;

import com.conferenciaUFPS.conferencias.entity.Conferencia;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ConferenciaRepository extends JpaRepository<Conferencia, Long> {
    
    List<Conferencia> findByPlazoEnvioTrabajosBetween(LocalDate startDate, LocalDate endDate);
}
