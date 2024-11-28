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
    @Getter
    @Setter
    private Exponente exponente;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    @Getter
    @Setter
    private Paquete paquete;

    @OneToMany(mappedBy = "taller")
    @Getter
    @Setter
    private List<AlumnoTaller> alumnosTaller;

    @OneToMany(mappedBy = "taller")
    @Getter
    @Setter
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
