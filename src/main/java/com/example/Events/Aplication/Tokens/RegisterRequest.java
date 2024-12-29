package com.example.Events.Aplication.Tokens;

public record RegisterRequest(
    String numeroDeControl,
    String usuario,
    String password
) {
}
