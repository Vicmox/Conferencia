package com.conferenciaUFPS.conferencias.service;

import com.conferenciaUFPS.conferencias.entity.Conferencia;


import java.time.LocalDate;
import java.util.List;

public interface ConferenciaService {

    public List<Conferencia> conferenciasDentroDePlazoDeEntrega(LocalDate fechaInicial, LocalDate fechaFinal);

}
