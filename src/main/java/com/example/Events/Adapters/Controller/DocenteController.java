package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.Docente;
import com.example.Events.Domain.Model.DocenteConferencia;
import com.example.Events.Domain.Service.IDocenteService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    private final IDocenteService docenteService;


    public DocenteController(IDocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Docente> getDocentes = docenteService.obtenerDocentes();
            return ResponseEntity.ok(getDocentes);
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
            Docente getDocente = docenteService.obtenerDocente(id);
            return ResponseEntity.ok(getDocente);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreDocente){
        try{
            List<Docente> getDocente = docenteService.obtenerPorNombre(nombreDocente);
            return ResponseEntity.ok(getDocente);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postDocente(@RequestBody Docente docente){
        try{
            Docente postDocente = docenteService.crearDocente(docente);
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
    public ResponseEntity<?> putDocente(@PathVariable int id, @RequestBody Docente docente){
        try{
            Docente putDocente = docenteService.actualizarDocente(id, docente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado con éxito");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                " inténtelo más tarde");
        }
    }
    


}
