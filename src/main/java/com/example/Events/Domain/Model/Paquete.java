package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @Column(unique = true)
    private String tipo;


    @OneToMany(mappedBy = "paquete")
    @Getter
    @Setter
    private List<Taller> talleres;

    @OneToMany(mappedBy = "paquete")
    @Getter
    @Setter
    private List<Conferencia> conferencias;

}
