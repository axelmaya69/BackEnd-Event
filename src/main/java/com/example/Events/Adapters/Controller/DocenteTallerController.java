package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.DocenteTaller;
import com.example.Events.Domain.Repository.IDocenteTaller;
import com.example.Events.Domain.Service.IDocenteTallerService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
