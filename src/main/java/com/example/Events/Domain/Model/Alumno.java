package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Alumno implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
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
    @Column(unique = true)
    private String numeroDeControl;

    @Getter
    @Setter
    @Column(unique = true)
    private String usuario;

    @Getter
    @Setter
    private String password;


    @OneToOne
    @Getter
    @Setter
    private Paquete paquete;

    @OneToOne
    @Getter
    @Setter
    private Escuela universidad;

    @OneToMany(mappedBy = "alumno")
    @Getter
    @Setter
    private List<AlumnoConferencia> alumnosConferencia;

    @OneToMany(mappedBy = "alumno")
    @Getter
    @Setter
    private List<AlumnoTaller> alumnosTaller;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public String getPassword() {
        return this.password; // Usa tu campo de contraseña
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Cambia si quieres manejar bloqueo de cuentas
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Cambia si quieres manejar expiración de credenciales
    }

    @Override
    public boolean isEnabled() {
        return true; // Cambia si quieres manejar habilitación de cuentas
    }



}

