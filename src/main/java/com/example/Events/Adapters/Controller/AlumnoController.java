package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Service.IAlumnoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private final IAlumnoService alumnoService;


    public AlumnoController(IAlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("get")
    public ResponseEntity<?> getAll(){
        try {
            List<Alumno> getAlumnos = alumnoService.obtenerAlumnos();
            return ResponseEntity.ok(getAlumnos);
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
    public  ResponseEntity<?> getById(@PathVariable int id){
        try{
            Alumno getAlumno = alumnoService.obtenerAlumno(id);
            return ResponseEntity.ok(getAlumno);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }
    @PostMapping("/post")
    public ResponseEntity<?> postAlumno(@RequestBody Alumno alumno){
        try{
            
        }
    }




}
