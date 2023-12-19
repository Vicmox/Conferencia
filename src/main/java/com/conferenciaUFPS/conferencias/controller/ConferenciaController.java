package com.conferenciaUFPS.conferencias.controller;

import com.conferenciaUFPS.conferencias.entity.Conferencia;
import com.conferenciaUFPS.conferencias.repository.ConferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/conferencias")
public class ConferenciaController {

    @Autowired
    private ConferenciaRepository conferenciaRepository;

    // Endpoint para crear una conferencia
    @PostMapping
    @ResponseBody
    public ResponseEntity<Conferencia> crearConferencia(@RequestBody Conferencia conferencia) {
        Conferencia nuevaConferencia = conferenciaRepository.save(conferencia);
        return new ResponseEntity<>(nuevaConferencia, HttpStatus.CREATED);
    }

    // Endpoint para obtener todas las conferencias
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Conferencia>> listarConferencias() {
        List<Conferencia> conferencias = conferenciaRepository.findAll();
        return new ResponseEntity<>(conferencias, HttpStatus.OK);
    }

    // Endpoint para obtener una conferencia por ID
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Conferencia> obtenerConferenciaPorId(@PathVariable Long id) {
        Conferencia conferencia = conferenciaRepository.findById(id)
                .orElse(null);

        if (conferencia != null) {
            return new ResponseEntity<>(conferencia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para actualizar una conferencia
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Conferencia> actualizarConferencia(@PathVariable Long id, @RequestBody Conferencia conferenciaActualizada) {
        if (conferenciaRepository.existsById(id)) {
            conferenciaActualizada.setId(id);
            Conferencia conferenciaActualizadaDB = conferenciaRepository.save(conferenciaActualizada);
            return new ResponseEntity<>(conferenciaActualizadaDB, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una conferencia
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> eliminarConferencia(@PathVariable Long id) {
        if (conferenciaRepository.existsById(id)) {
            conferenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/view")
    public String showView() {

        return "conferencias";
    }

}
