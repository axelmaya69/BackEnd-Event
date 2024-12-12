package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Service.IAlumnoService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
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

    @GetMapping("/get")
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


    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreAlumno){
        try{
            List<Alumno> getAlumnoByName = alumnoService.obtenerPorNombre(nombreAlumno);
            return ResponseEntity.ok(getAlumnoByName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }


    @PostMapping("/post")
    public ResponseEntity<?> postAlumno(@RequestBody Alumno alumno){
        try{
            Alumno postAlumno = alumnoService.crearAlumno(alumno);
            return ResponseEntity.status(HttpStatus.CREATED).body("Alumno creado exitosamente");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El registro ya existe!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putAlumno(@PathVariable int id, @RequestBody Alumno alumno){
        try{
            Alumno putAlumnoController = alumnoService.actualizarAlumno(id,alumno);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado con éxito");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable int id){
        try{
            alumnoService.eliminarAlumno(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado exitosamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }



}
