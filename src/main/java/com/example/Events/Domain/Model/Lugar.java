package com.example.Events.Domain.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Lugar {

    @Getter
    @Setter
    int id;


    @Getter
    @Setter
    String lugar;
}
