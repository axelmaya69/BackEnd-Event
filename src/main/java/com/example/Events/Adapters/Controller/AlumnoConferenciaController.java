package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Service.IAlumnoConferenciaService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AlumnoConferencia")
public class AlumnoConferenciaController {

    private final IAlumnoConferenciaService alumnoConferenciaService;


    public AlumnoConferenciaController(IAlumnoConferenciaService alumnoConferenciaService) {
        this.alumnoConferenciaService = alumnoConferenciaService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<AlumnoConferencia> aluConf = alumnoConferenciaService.obtenerAlumnosConferencias();
            return ResponseEntity.ok(aluConf);
        }
        catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al acceder a la base de datos, intente más tarde.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, intentelo más tarde");
        }
    }



}
