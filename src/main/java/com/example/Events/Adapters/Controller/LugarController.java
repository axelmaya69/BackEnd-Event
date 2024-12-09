package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Lugar;
import com.example.Events.Domain.Service.ILugarService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lugar")
public class LugarController {

    private final ILugarService lugarService;


    public LugarController(ILugarService lugarService) {
        this.lugarService = lugarService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Lugar> getAllLugares = lugarService.obtenerLugares();
            return ResponseEntity.ok(getAllLugares);
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
            Lugar getLugar = lugarService.obtenerLugar(id);
            return ResponseEntity.ok(getLugar);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    


}
