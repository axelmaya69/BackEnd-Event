package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.OtroEvento;
import com.example.Events.Domain.Service.IOtroEventoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/otroEvento")
public class OtroEventoController {

    private final IOtroEventoService otroEventoService;


    public OtroEventoController(IOtroEventoService otroEventoService) {
        this.otroEventoService = otroEventoService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<OtroEvento> getAllOEv = otroEventoService.obtenerOtrosEventos();
            return ResponseEntity.ok(getAllOEv);
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
