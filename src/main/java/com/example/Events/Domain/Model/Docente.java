package com.example.Events.Domain.Model;

import jakarta.persistence.Entity;

@Entity
public class Docente {


    int id;


    String nombre;

    String apellidoP;

    String apellidoM;

    int fkConferencia;

    int fkTaller;
    



}
