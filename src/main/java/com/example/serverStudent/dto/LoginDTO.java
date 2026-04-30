package com.example.serverStudent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

public class LoginDTO {
    @NotEmpty(message = "login do not empty")
    @JsonProperty("login")
    private String login;

    @NotEmpty(message = "password do not empty")
    @JsonProperty("password")
    private String password;

    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
