package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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


}
