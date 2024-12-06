package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.DocenteTaller;
import com.example.Events.Domain.Repository.IDocenteTaller;
import com.example.Events.Domain.Service.IDocenteTallerService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docenteTaller")
public class DocenteTallerController {

    private final IDocenteTallerService docenteTallerService;


    public DocenteTallerController(IDocenteTallerService docenteTallerService) {
        this.docenteTallerService = docenteTallerService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<DocenteTaller> getDocentesTall = docenteTallerService.obtenerDocentesTalleres();
            return ResponseEntity.ok(getDocentesTall);
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
        try {
            DocenteTaller getDocenteTaller = docenteTallerService.obtenerDocenteTaller(id);
            return ResponseEntity.ok(getDocenteTaller);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postDocTaller(@RequestBody DocenteTaller docenteTaller){
        try{
            DocenteTaller postDocenteTaller = docenteTallerService.crearDocenteTaller(docenteTaller);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado exitosamente");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El registro ya existe!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    
}
