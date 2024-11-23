package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;


    @Getter
    @Setter
    private String lugar;

    @Getter
    @Setter
    @OneToMany(mappedBy = "lugar")
    private List<Taller> talleres;

    @Getter
    @Setter
    @OneToMany(mappedBy = "lugar")
    private List<Conferencia> conferencias;

    @Getter
    @Setter
    @OneToMany(mappedBy = "lugar")
    private List<OtroEvento> otrosEventos;
}
