package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class InscripcionTaller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    int id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    @Getter
    @Setter
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_taller")
    @Getter
    @Setter
    private Taller taller;


}
