package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class Taller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String nombre;

    @Getter
    @Setter
    String descripcion;

    @Getter
    @Setter
    String materiales;

    @ManyToOne
    @JoinColumn(name = "id_exponente")
    private Exponente exponente;
    



}
