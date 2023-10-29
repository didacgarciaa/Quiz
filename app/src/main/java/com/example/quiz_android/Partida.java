package com.example.quiz_android;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Partida {
    public static int contador = 0;

    public Partida(){

    }

    public static void mostrarPelicula(Pelicula[] arrayPelicules, ImageView imatge , Button[] buttons) {


        int idFoto = arrayPelicules[contador].getFoto();
        imatge.setImageResource(idFoto);

        Set<Integer> numerosUnicos = new HashSet<>();

        numerosUnicos.add(contador);
        List<Integer> list = Metode.generarRespostas(numerosUnicos);

       Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext() && i < 4) {
            Integer n = iterator.next();

            buttons[i].setText(arrayPelicules[n].getResposta());
            i++;
        }

    }
    public static boolean comprobarResposta(String resposta,Pelicula[] arrayPelicules) {

        if(resposta.equals(arrayPelicules[contador].getResposta())){
            contador ++;
            return true;
        }
        else{
            return false;
        }
    }

}
