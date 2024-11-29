package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Docente;
import com.example.Events.Domain.Repository.IDocente;
import com.example.Events.Domain.Service.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImplementation implements IDocenteService {

    private final IDocente docenteRep;

    @Autowired
    public DocenteServiceImplementation(IDocente docenteRep) {
        this.docenteRep = docenteRep;
    }


    @Override
    public Docente crearDocente(Docente docente) {
        return docenteRep.save(docente);
    }

    @Override
    public Docente obtenerDocente(int id) {
        return docenteRep.findById(id).orElse(null);
    }

    @Override
    public List<Docente> obtenerDocentes() {
        return docenteRep.findAll();
    }

    @Override
    public List<Docente> obtenerPorNombre(String docente) {
        return docenteRep.findByNombreContaining(docente);
    }

    @Override
    public Docente actualizarDocente(int id, Docente docente) {
        Docente updateDocente = docenteRep.findById(id).get();
        if(docenteRep.existsById(id)){
            updateDocente.setNombre(docente.getNombre());
            updateDocente.setApellidoM(docente.getApellidoM());
            updateDocente.setApellidoP(docente.getApellidoP());
            updateDocente.setNumeroControl(docente.getNumeroControl());
            updateDocente.setUsuario(docente.getUsuario());
            updateDocente.setPassword(docente.getPassword());
            return docenteRep.save(updateDocente);
        }
        return null;
    }

    @Override
    public void eliminarDocente(int id) {
    docenteRep.deleteById(id);
    }
}
