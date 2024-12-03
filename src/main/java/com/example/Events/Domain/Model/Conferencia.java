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
    @Column(unique = true)
    private String nombre;

    @Getter
    @Setter
    private String descripcion;



    @ManyToOne
    @JoinColumn(name = "id_exponente")
    @Getter
    @Setter
    private Exponente exponente;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    @Getter
    @Setter
    private Paquete paquete;

    @OneToMany(mappedBy = "conferencia")
    @Getter
    @Setter
    private List<AlumnoConferencia> alumnosConferencia;

    @OneToMany(mappedBy = "conferencia")
    @Getter
    @Setter
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
