package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Administrador;
import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Repository.IAlumnoConferencia;
import com.example.Events.Domain.Service.IAlumnoConferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluConfServiceImplementation implements IAlumnoConferenciaService {

    private final IAlumnoConferencia aluconfRep;

    @Autowired
    public AluConfServiceImplementation(IAlumnoConferencia aluconfRep) {
        this.aluconfRep = aluconfRep;
    }


    @Override
    public AlumnoConferencia crearAlumnoConferencia(AlumnoConferencia alumnoConferencia) {
        return aluconfRep.save(alumnoConferencia);
    }

    @Override
    public AlumnoConferencia obtenerAlumnoConferencia(int id) {
        return aluconfRep.findById(id).orElse(null);
    }

    @Override
    public List<AlumnoConferencia> obtenerAlumnosConferencias() {
        return aluconfRep.findAll();
    }



    @Override
    public AlumnoConferencia actualizarAlumnoConferencia(int id, AlumnoConferencia alumnoConferencia) {
        AlumnoConferencia updateAlConf = aluconfRep.findById(id).get();
        if(aluconfRep.existsById(id)){
            updateAlConf.setConferencia(alumnoConferencia.getConferencia());
            updateAlConf.setAlumno(alumnoConferencia.getAlumno());
            return aluconfRep.save(updateAlConf);
        }
        return null;
    }

    @Override
    public void eliminarAlumnoConferencia(int id) {
    aluconfRep.deleteById(id);
    }
}
