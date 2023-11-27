package com.example.quiz_android;

import java.util.List;

public class Pelicula {
    private String resposta;
    private String[] pistes;
    private List<Integer> idFoto;

    public Pelicula(String name, List<Integer>idFoto) {
        this.resposta = name;
        this.idFoto = idFoto;
    }

    public String getResposta() {
        return resposta;
    }

    public String[] getPistes(){return pistes;};
    public void setPistes(String[] pistes){this.pistes = pistes;}
    public List<Integer> getFoto() {
        return idFoto;
    }

}
