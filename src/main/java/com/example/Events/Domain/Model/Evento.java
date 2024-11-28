package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;


    @Getter
    @Setter
    @OneToMany(mappedBy = "evento")
    private List<Conferencia> conferencias;

    @Getter
    @Setter
    @OneToMany(mappedBy = "evento")
    private List<Taller> talleres;

    @Getter
    @Setter
    @OneToMany(mappedBy = "evento")
    private List<OtroEvento> otrosEventos;


}
