package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Evento;
import com.example.Events.Domain.Service.IEventoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final IEventoService eventoService;


    public EventoController(IEventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Evento> getEventos = eventoService.obtenerEventos();
            return ResponseEntity.ok(getEventos);
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
            Evento getEvento = eventoService.obtenerEvento(id);
            return ResponseEntity.ok(getEvento);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    

}
