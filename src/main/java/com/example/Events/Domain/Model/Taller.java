package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Getter
    @Setter
    String fK_exponente;

    @Getter
    cd@Setter
    String tipoAcceso;



}
