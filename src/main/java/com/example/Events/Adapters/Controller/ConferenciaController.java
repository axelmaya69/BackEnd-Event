package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.Conferencia;
import com.example.Events.Domain.Service.IConferenciaService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferencia")
public class ConferenciaController {

    private final IConferenciaService conferenciaService;

    public ConferenciaController(IConferenciaService conferenciaService) {
        this.conferenciaService = conferenciaService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Conferencia> getAllConferencias = conferenciaService.obtenerConferencias();
            return ResponseEntity.ok(getAllConferencias);
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
            Conferencia getConferencia = conferenciaService.obtenerConferencia(id);
            return ResponseEntity.ok(getConferencia);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreConferencia){
        try{
            List<Conferencia> getNameConferencia = conferenciaService.obtenerPorNombre(nombreConferencia);
            return ResponseEntity.ok(getNameConferencia);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postConf(@RequestBody Conferencia conferencia){
        try{
            Conferencia postConferencia = conferenciaService.crearConferencia(conferencia);
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
    public ResponseEntity<?> putConferencia(@PathVariable int id, @RequestBody Conferencia conferencia){
        try{
            Conferencia putConferencia = conferenciaService.actualizarConferencia(id,conferencia);
           return ResponseEntity.status(HttpStatus.CREATED).body("Editado con éxito");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteConf(@PathVariable int id) {
        try {
            conferenciaService.eliminarConferencia(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado exitosamente");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }
    }
    
