package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.APersona;
import com.example.Events.Domain.Model.Rol;
import com.example.Events.Domain.Repository.IAPersona;
import com.example.Events.Domain.Repository.IRol;
import com.example.Events.Domain.Service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;

public class RolServiceImplementation  implements IRolesService {

    private final IRol rol;

    @Autowired
    private IRolesService rolesService;

    @Autowired
    private IAPersona iaPersona;

    public RolServiceImplementation(IRol rol) {
        this.rol = rol;
    }


    @Override
    public Rol crearRol(String nombre, String descripcion) {
        Rol rols = new Rol();
        rols.setNombre(nombre);
        rols.setDescripcion(descripcion);
        return rol.save(rols);
    }

    @Override
    public void asignarRol(APersona persona, String nombreRol) {
        Rol rolx = rol.findByNombre(nombreRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombreRol));
        persona.getRoles().add(rolx);
        iaPersona.save(persona);

    }
}
