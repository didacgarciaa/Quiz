package com.example.quiz_android;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class Pelicules {
    private String resposta;
    private int idFoto;

    public Pelicules(String name, int idFoto) {
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
