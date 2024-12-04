package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.DocenteConferencia;
import com.example.Events.Domain.Service.IDocenteConferenciaService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/docenteConferencia")
public class DocenteConferenciaController {

    private final IDocenteConferenciaService docenteConferenciaService;


    public DocenteConferenciaController(IDocenteConferenciaService docenteConferenciaService) {
        this.docenteConferenciaService = docenteConferenciaService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<DocenteConferencia> getAll = docenteConferenciaService.obtenerDocenteConferencias();
            return ResponseEntity.ok(getAll);
        }
        catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al acceder a la base de datos, intente más tarde.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, intentelo más tarde");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById (@PathVariable int id){
        try {
            DocenteConferencia getDocenteConferencia = docenteConferenciaService.obtenerDocenteConferencia(id);
            return ResponseEntity.ok(getDocenteConferencia);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    




}
