package com.example.quiz_android;

public class Pelicula {
    private String resposta;
    private int idFoto;

    public Pelicula(String name, int idFoto) {
        this.resposta = name;
        this.idFoto = idFoto;
    }

    public String getResposta() {
        return resposta;
    }

    public int getFoto() {
        return idFoto;
    }
}
