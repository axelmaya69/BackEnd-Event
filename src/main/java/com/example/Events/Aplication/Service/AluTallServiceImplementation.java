package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.AlumnoTaller;
import com.example.Events.Domain.Repository.IAlumnoTaller;
import com.example.Events.Domain.Service.IAlumnoTallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluTallServiceImplementation implements IAlumnoTallerService {

    private final IAlumnoTaller aluTallRep;

    @Autowired
    public AluTallServiceImplementation(IAlumnoTaller aluTallRep) {
        this.aluTallRep = aluTallRep;
    }


    @Override
    public AlumnoTaller crearAlumnoTaller(AlumnoTaller alumnotaller) {
        return aluTallRep.save(alumnotaller);
    }

    @Override
    public AlumnoTaller obtenerAlumnoTaller(int id) {
        return aluTallRep.findById(id).orElse(null);
    }

    @Override
    public List<AlumnoTaller> obtenerAlumnosTalleres() {
        return aluTallRep.findAll();
    }



    @Override
    public AlumnoTaller actualizarAlumnoTaller(int id, AlumnoTaller alumnotaller) {
        AlumnoTaller updateAlTall = aluTallRep.findById(id).get();
        if(aluTallRep.existsById(id)){
            updateAlTall.setAlumno(alumnotaller.getAlumno());
            updateAlTall.setTaller(alumnotaller.getTaller());
            return aluTallRep.save(updateAlTall);
        }
        return null;
    }

    @Override
    public void eliminarAlumnoTaller(int id) {
    aluTallRep.deleteById(id);
    }
}
