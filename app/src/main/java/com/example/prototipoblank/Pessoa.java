package com.example.prototipoblank;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Pessoa extends SugarRecord implements Serializable {

    private String nome;
    private String email;

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
