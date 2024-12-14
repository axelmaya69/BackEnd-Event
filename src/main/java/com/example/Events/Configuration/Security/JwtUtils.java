package com.example.Events.Configuration.Security;

import com.example.Events.Domain.Model.Alumno;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {



    public String generarJWT(String usuario){
    return Jwts.builder()
            .setSubject(usuario)
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime()+ ${EXPIRATION_TIME}))
        //investigar como agregar variables de entorno dentro deuna clase
    }


}
