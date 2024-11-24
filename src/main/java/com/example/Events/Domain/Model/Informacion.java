package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class Informacion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    @Setter
    private Date fechaInicio;

    @Getter
    @Setter
    private Date fechaFin;

    @OneToMany(mappedBy = "informacion")
    private List<Conferencia> conferencias;

    @OneToMany(mappedBy = "informacion")
    private List<Taller> talleres;

    @OneToMany(mappedBy = "informacion")
    private List<OtroEvento> otrosEventos;

}
