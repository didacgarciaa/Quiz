package com.example.quiz_android;

import android.content.Context;
import android.widget.Button;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class Metode extends AppCompatActivity {
    public Metode(){}
    public static Pelicula[] generadorPelicules(String[] respostes, int[] imatges,Context context) {
        Pelicula[] arrayPelicules = new Pelicula[respostes.length];
        int contArray = 0;
        for (int i = 0; i < respostes.length; i++) {
            String[] idPistes = new String[]{"iron_man", "hulk", "avengers", "spider_man", "guardians_of_the_galaxy", "daredevil", "black_panther", "doctor_strange", "deadpool", "thor"};
            Pelicula pelicula = new Pelicula(respostes[i],GeneraArrayImatges(imatges,idPistes[i],contArray));
            Metode metode = new Metode();
            pelicula.setPistes(metode.GeneraArrayPistes(idPistes[i],context));
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
    public String[] GeneraArrayPistes(String idPista,Context context) {

        if (context != null) {
            Resources resources = context.getResources();
            int resourceId = resources.getIdentifier(idPista, "array", context.getPackageName());
            return resources.getStringArray(resourceId);
        } else {
            return new String[0];
        }
    }
    public static List<Integer> GeneraArrayImatges(int [] imatges,String idPista,int contArray){
        List<Integer> idImatges =new ArrayList<>();
        for (int i = contArray; contArray<imatges.length;i++){
            for(int t = 0; i<4;i++){
                idImatges.add(imatges[i]);
            }
        }
        return idImatges;
    }
}
