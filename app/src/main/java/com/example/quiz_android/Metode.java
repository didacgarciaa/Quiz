package com.example.quiz_android;

import android.content.Context;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class Metode extends AppCompatActivity {
    public static Pelicula[] generadorPelicules(String[] respostes, int[] imatges) {
        Pelicula[] arrayPelicules = new Pelicula[respostes.length];
        for (int i = 0; i < respostes.length && i < imatges.length; i++) {
            Pelicula pelicula = new Pelicula(respostes[i], imatges[i]);
            arrayPelicules[i] = pelicula;
        }
        return arrayPelicules;
    }
    public static List<Integer> generarRespostas(Set<Integer> nums) {
            Random random = new Random();
            while (nums.size() < 4) {
                int numeroAleatorio = random.nextInt(10); // Generar un número entre 1 y 10
                nums.add(numeroAleatorio);
            }
            List<Integer> list = new ArrayList<>();
            for (Integer item : nums) {
                list.add(item);
            }
        Collections.shuffle(list);
        return list;
    }
}
