package com.example.Events.Domain.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public abstract class APersona {

    @Id
    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String nombre;

    String apellidoP;

    String apellidoM;



}
