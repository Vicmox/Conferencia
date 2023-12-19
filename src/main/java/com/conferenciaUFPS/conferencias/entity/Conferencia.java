package com.conferenciaUFPS.conferencias.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Conferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fecha;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "plazo_envio_trabajos")
    private LocalDate plazoEnvioTrabajos;
    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;
    
    @ManyToMany
    @JoinTable(name = "conferencia_topico",
            joinColumns = @JoinColumn(name = "conferencia_id"),
            inverseJoinColumns = @JoinColumn(name = "topico_id"))
    private List<Topico> topicos;


   

}
