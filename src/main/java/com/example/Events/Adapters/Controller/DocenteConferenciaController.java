package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Docente;
import com.example.Events.Domain.Model.DocenteConferencia;
import com.example.Events.Domain.Service.IDocenteConferenciaService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
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

    @PostMapping("/post")
    public ResponseEntity<?> postDoConf(@RequestBody DocenteConferencia docenteConferencia){
        try{
            DocenteConferencia postDocenteConferencia = docenteConferenciaService.
                    crearDocenteConferencia(docenteConferencia);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado exitosamente");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El registro ya existe!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putDoConf(@PathVariable int id, @RequestBody DocenteConferencia docenteConferencia){
        try{
            DocenteConferencia updateDocenteConferencia = docenteConferenciaService.actualizarDocenteConferencia(id,docenteConferencia);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado con exito");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoConf(@PathVariable int id){
        try{
            docenteConferenciaService.eliminarDocenteConferencia(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado con éxito");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }
}
