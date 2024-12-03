package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class OtroEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @Column(unique = true)
    private String nombre;

    @Getter
    @Setter
    private String descripcion;



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

