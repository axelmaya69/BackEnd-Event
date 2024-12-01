package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.DocenteTaller;
import com.example.Events.Domain.Repository.IDocenteTaller;
import com.example.Events.Domain.Service.IDocenteTallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocTallServiceImplementation implements IDocenteTallerService {

    private final IDocenteTaller docTallRep;

    @Autowired
    public DocTallServiceImplementation(IDocenteTaller docTallRep) {
        this.docTallRep = docTallRep;
    }


    @Override
    public DocenteTaller crearDocenteTaller(DocenteTaller docenteTaller) {
        return docTallRep.save(docenteTaller);
    }

    @Override
    public DocenteTaller obtenerDocenteTaller(int id) {
        return docTallRep.findById(id).orElse(null);
    }

    @Override
    public List<DocenteTaller> obtenerDocentesTalleres() {
        return docTallRep.findAll();
    }


    @Override
    public DocenteTaller actualizarDocenteTaller(int id, DocenteTaller docenteTaller) {
        DocenteTaller updateDocTall = docTallRep.findById(id).get();
        if(docTallRep.existsById(id)){
            updateDocTall.setTaller(docenteTaller.getTaller());
            updateDocTall.setDocente(docenteTaller.getDocente());
            return docTallRep.save(updateDocTall);
        }
        return null;
    }

    @Override
    public void eliminarDocenteTaller(int id) {
    docTallRep.deleteById(id);
    }
}
