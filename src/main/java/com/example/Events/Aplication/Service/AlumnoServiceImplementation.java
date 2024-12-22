package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Repository.IAlumno;
import com.example.Events.Domain.Service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlumnoServiceImplementation implements IAlumnoService, UserDetailsService {


    private final IAlumno aluRepo;


    @Autowired
    public AlumnoServiceImplementation(IAlumno aluRepo) {
        this.aluRepo = aluRepo;
    }

    @Override
    public Alumno crearAlumno(Alumno alumno) {
        return aluRepo.save(alumno);
    }

    @Override
    public Alumno obtenerAlumno(int id) {
        return aluRepo.findById(id).orElse(null);
    }

    @Override
    public List<Alumno> obtenerAlumnos() {
        return aluRepo.findAll();
    }

    @Override
    public List<Alumno> obtenerPorNombre(String alumno) {
        return aluRepo.findByNombreContaining(alumno);
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumno) {
        Alumno updateAlumno = aluRepo.findById(id).get();
        if(aluRepo.existsById(id)){
            updateAlumno.setNombre(alumno.getNombre());
            updateAlumno.setApellidoP(alumno.getApellidoP());
            updateAlumno.setApellidoM(alumno.getApellidoM());
            updateAlumno.setNumeroDeControl(alumno.getNumeroDeControl());
            updateAlumno.setUsuario(alumno.getUsuario());
            updateAlumno.setPassword(alumno.getPassword());

        return aluRepo.save(updateAlumno);
        }
        return null;
    }

    @Override
    public void eliminarAlumno(int id) {
    aluRepo.deleteById(id);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
}
