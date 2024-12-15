package com.example.Events.Configuration.Security;

import com.example.Events.Domain.Model.Alumno;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {


    @Value("${EXPIRATION_TIME}")
    private String expiracion;

    @Value("${SECRET_KEY}")
    private String llave;

    public String generarJWT(String usuario){
    return Jwts.builder()
            .setSubject(usuario)
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime()+ expiracion))
            .signWith(SignatureAlgorithm.HS256,llave)
            .compact();
    }

    public String getUserFromJWT(String token){
        return Jwts.parser()
                .setSigningKey(llave)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //valudar token

    public boolean validateJWT(String token){
        try{
            Jwts.parser().setSigningKey(llave).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            System.err.println("Token inválido "+ e.getMessage());
            return false;
        }
    }


}
