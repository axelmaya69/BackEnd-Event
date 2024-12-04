package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Service.IAlumnoConferenciaService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnoConferencia")
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
    @GetMapping("/get/{id}")
        public ResponseEntity<?> getById(@PathVariable int id){
            try{
                AlumnoConferencia getAlumnoConferencia = alumnoConferenciaService.obtenerAlumnoConferencia(id);
                return ResponseEntity.ok(getAlumnoConferencia);
        }catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error, inténtelo más tarde.");
            }
    }
    @PostMapping("/post")
    public ResponseEntity<?> postAlumnoConferencia(@RequestBody AlumnoConferencia alumnoConferencia){
        try{
            AlumnoConferencia postAlumnoConferencia = alumnoConferenciaService.crearAlumnoConferencia(alumnoConferencia);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado con éxito");
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El registro ya existe!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putAlumnoConferencia(@PathVariable int id, @RequestBody AlumnoConferencia alumnoConferencia){
        try{
            AlumnoConferencia putAlumnoConferencia = alumnoConferenciaService.actualizarAlumnoConferencia(id, alumnoConferencia);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado con éxito");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAlumnoConferencia(@PathVariable int id){
     try{
         alumnoConferenciaService.eliminarAlumnoConferencia(id);
         return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado exitosamente");
     }catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                 " inténtelo más tarde.");
     }
    }


}
