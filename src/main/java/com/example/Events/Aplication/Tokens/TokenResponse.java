package com.example.Events.Aplication.Tokens;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(
    @JsonProperty("acces_token")
    String access_token,
    @JsonProperty("refresh_token")
    String refresh_token
){
}
