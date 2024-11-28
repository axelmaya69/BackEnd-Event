package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Exponente {
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
    private String apellidoP;

    @Getter
    @Setter
    private String apellidoM;

    @Getter
    @Setter
    private String correoElectronico;

    @Getter
    @Setter
    private String descripcion;

    @OneToMany(mappedBy = "exponente")
    @Getter
    @Setter
    private List<Taller> talleres;


    @OneToMany(mappedBy = "exponente")
    @Getter
    @Setter
    private List<Conferencia> conferencias;
}
