package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class Taller {
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

    @Getter
    @Setter
    private String materiales;



    @ManyToOne
    @JoinColumn(name = "id_exponente")
    private Exponente exponente;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

    @OneToMany(mappedBy = "taller")
    private List<AlumnoTaller> alumnosTaller;

    @OneToMany(mappedBy = "taller")
    private List<DocenteTaller> docenteTaller;

    @Getter
    @Setter
    @ManyToOne
    private Lugar lugar;

    @Getter
    @Setter
    @ManyToOne
    private Informacion informacion;

    @Getter
    @Setter
    @ManyToOne
    private Evento evento;



}
