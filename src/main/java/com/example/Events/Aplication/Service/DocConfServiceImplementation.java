package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.DocenteConferencia;
import com.example.Events.Domain.Repository.IDocenteConferencia;
import com.example.Events.Domain.Service.IDocenteConferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocConfServiceImplementation implements IDocenteConferenciaService {

    private final IDocenteConferencia doConfRepo;

    @Autowired
    public DocConfServiceImplementation(IDocenteConferencia doConfRepo) {
        this.doConfRepo = doConfRepo;
    }


    @Override
    public DocenteConferencia crearDocenteConferencia(DocenteConferencia docenteConferencia) {
        return doConfRepo.save(docenteConferencia);
    }

    @Override
    public DocenteConferencia obtenerDocenteConferencia(int id) {
        return doConfRepo.findById(id).orElse(null);
    }

    @Override
    public List<DocenteConferencia> obtenerDocenteConferencias() {
        return doConfRepo.findAll();
    }



    @Override
    public DocenteConferencia actualizarDocenteConferencia(int id, DocenteConferencia docenteConferencia) {
        DocenteConferencia updateDocConf = doConfRepo.findById(id).get();
        if(doConfRepo.existsById(id)){
            updateDocConf.setDocente(docenteConferencia.getDocente());
            updateDocConf.setConferencia(docenteConferencia.getConferencia());
            return doConfRepo.save(updateDocConf);
        }
        return null;
    }

    @Override
    public void eliminarDocenteConferencia(int id) {
    doConfRepo.deleteById(id);
    }
}
