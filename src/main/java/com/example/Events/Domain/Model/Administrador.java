package com.example.Events.Domain.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Administrador extends APersona{

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles = new ArrayList<>();
}
