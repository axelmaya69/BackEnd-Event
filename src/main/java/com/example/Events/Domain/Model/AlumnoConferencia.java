package com.example.Events.Domain.Model;

import jakarta.persistence.*;

@Entity
public class InscripcionConferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_conferencia")
    private Conferencia conferencia;


}
