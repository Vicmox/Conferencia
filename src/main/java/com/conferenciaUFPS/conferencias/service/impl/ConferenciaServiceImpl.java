/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conferenciaUFPS.conferencias.service.impl;

import com.conferenciaUFPS.conferencias.entity.Conferencia;
import com.conferenciaUFPS.conferencias.repository.ConferenciaRepository;
import com.conferenciaUFPS.conferencias.service.ConferenciaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ConferenciaServiceImpl implements ConferenciaService {

    @Autowired
    ConferenciaRepository repositorio;

    @Override
    public List<Conferencia> conferenciasDentroDePlazoDeEntrega(LocalDate fechaInicial, LocalDate fechaFinal) {
        return this.repositorio.findByPlazoEnvioTrabajosBetween(fechaInicial, fechaFinal);
    }

}
