package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class Conferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String descripcion;



    @ManyToOne
    @JoinColumn(name = "id_exponente")
    private Exponente exponente;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

    @OneToMany(mappedBy = "conferencia")
    private List<AlumnoConferencia> alumnosConferencia;

    @OneToMany(mappedBy = "conferencia")
    private List<DocenteConferencia> docenteConferencia;


    @Getter
    @Setter
    @ManyToOne
    private Lugar lugar;

    @Getter
    @Setter
    @ManyToOne
    private Evento evento;

    @Getter
    @Setter
    @ManyToOne
    private Informacion informacion;
}
