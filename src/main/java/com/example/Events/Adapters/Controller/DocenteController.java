package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.Docente;
import com.example.Events.Domain.Service.IDocenteService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    


}
