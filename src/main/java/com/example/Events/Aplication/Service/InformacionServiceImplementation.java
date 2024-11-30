package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Informacion;
import com.example.Events.Domain.Repository.IInformacion;
import com.example.Events.Domain.Service.IInformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionServiceImplementation implements IInformacionService {

    private final IInformacion infoRep;
    @Autowired
    public InformacionServiceImplementation(IInformacion infoRep) {
        this.infoRep = infoRep;
    }


    @Override
    public Informacion crearInformacion(Informacion informacion) {
        return infoRep.save(informacion);
    }

    @Override
    public Informacion obtenerInformacion(int id) {
        return infoRep.findById(id).orElse(null);
    }

    @Override
    public List<Informacion> obtenerInformaciones() {
        return infoRep.findAll();
    }

    @Override
    public List<Informacion> obtenerPorNombre(String informacion) {
        return infoRep.findByNombreContaining(informacion);
    }

    @Override
    public Informacion actualizarInformacion(int id, Informacion informacion) {
        Informacion updateInformacion = infoRep.findById(id).get();
        if(infoRep.existsById(id)){
            updateInformacion.setFechaInicio(informacion.getFechaInicio());
            updateInformacion.setFechaFin(informacion.getFechaFin());
            return infoRep.save(updateInformacion);
        }
        return  null;
    }

    @Override
    public void eliminarInformacion(int id) {
    infoRep.deleteById(id);
    }
}
