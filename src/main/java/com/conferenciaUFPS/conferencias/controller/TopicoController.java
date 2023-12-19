package com.conferenciaUFPS.conferencias.controller;

import com.conferenciaUFPS.conferencias.entity.Topico;
import com.conferenciaUFPS.conferencias.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Endpoint para crear un tópico
    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody Topico topico) {
        Topico nuevoTopico = topicoRepository.save(topico);
        return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los tópicos
    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return new ResponseEntity<>(topicos, HttpStatus.OK);
    }

    // Endpoint para obtener un tópico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElse(null);

        if (topico != null) {
            return new ResponseEntity<>(topico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para actualizar un tópico
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topicoActualizado) {
        if (topicoRepository.existsById(id)) {
            topicoActualizado.setId(id);
            Topico topicoActualizadoDB = topicoRepository.save(topicoActualizado);
            return new ResponseEntity<>(topicoActualizadoDB, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

