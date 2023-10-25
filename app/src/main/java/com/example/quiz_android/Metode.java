package com.example.quiz_android;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Button;

import java.util.Random;

public class Metode {
    public static Pelicula[] generadorPelicules(String[] respostes, int[] imatges) {
        Pelicula[] arrayPelicules = new Pelicula[respostes.length];
        for (int i = 0; i < respostes.length && i < imatges.length; i++) {
            Pelicula pelicula = new Pelicula(respostes[i], imatges[i]);
            arrayPelicules[i] = pelicula;
        }
        return arrayPelicules;
    }

/*
    public static void mostrarPelicula(Pelicula[] arrayPelicules, ImageView imatge , Button[] buttons) {

        Random random = new Random();

        int respostaCorrecta = random.nextInt(arrayPelicules.length);
        int idFoto = arrayPelicules[respostaCorrecta].getFoto();
        imatge.setImageResource(idFoto);
        int respostaIncorrecta1, respostaIncorrecta2, respostaIncorrecta3;



        do {
            respostaIncorrecta1 = random.nextInt(10);
        }while(respostaIncorrecta1 == respostaCorrecta);
        do {
            respostaIncorrecta2 = random.nextInt(10);
        }while(respostaIncorrecta2 == respostaCorrecta || respostaIncorrecta2 ==respostaIncorrecta1);
        do {
            respostaIncorrecta3 = random.nextInt(10);
        }while(respostaIncorrecta3 == respostaCorrecta || respostaIncorrecta3 == respostaIncorrecta1 || respostaIncorrecta3 == respostaIncorrecta2);

        String [] respostesValides = {
                arrayPelicules[respostaCorrecta].getResposta(),
                arrayPelicules[respostaIncorrecta1].getResposta(),
                arrayPelicules[respostaIncorrecta2].getResposta(),
                arrayPelicules[respostaIncorrecta3].getResposta()
        };
        barrejaRespostes(respostesValides);
        rb1.setText(respostesValides[0]);
        rb2.setText(respostesValides[1]);
        rb3.setText(respostesValides[2]);
        rb4.setText(respostesValides[3]);

    }

    public static void barrejaRespostes(String[] respostesValides) {
        Random random = new Random();
        for (int i = respostesValides.length - 1; i > 0; i--) {
            int index = random.nextInt(i);
            String respostaSelecionada = respostesValides[i];
            respostesValides[i] = respostesValides[index];
            respostesValides[index] = respostaSelecionada;
        }
    }

*/
}
