package com.mymedicalappointment.model;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Login {
    private Integer id;
    private String email;
    private String password;


    public Login(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Login() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id != null){
            this.id = id;
        } else {
            throw new IllegalArgumentException("The User Id cant is empty");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }
}
