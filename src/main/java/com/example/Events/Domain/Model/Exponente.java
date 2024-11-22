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
    int id;

    @Getter
    @Setter
    String nombre;

    @Getter
    @Setter
    String apellidoP;

    @Getter
    @Setter
    String apellidoM;

    @Getter
    @Setter
    String correoElectronico;

    @Getter
    @Setter
    String descripcion;

    @OneToMany(mappedBy = "exponente")
    private List<Taller> talleres;


    @OneToMany(mappedBy = "exponente")
    private List<Conferencia> conferencias;
}
