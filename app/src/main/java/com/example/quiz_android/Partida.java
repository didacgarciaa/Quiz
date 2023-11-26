package com.example.quiz_android;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.util.Log;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Partida extends AppCompatActivity {
    public static int contador = 0;
    private LocalDateTime fechaActual = LocalDateTime.now();
    public static int nErrors = 0;
    public static  int ratxa = 0;

    public Partida(){}

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
    public boolean comprobarResposta(String resposta, Pelicula[] arrayPelicules, ProgressBar progressBar, TextView score,Context context,TextView textPista) {

        if(resposta.equals(arrayPelicules[contador].getResposta())){
            contador ++;
            ratxa ++;
            if(contador == 10){
                LocalDateTime fechaFinal = LocalDateTime.now();
                Duration duracion = Duration.between(fechaActual, fechaFinal);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String fechaFormateada = fechaActual.format(formatter);
                @SuppressLint("DefaultLocale") String duracionFormateada = String.format("%02d:%02d:%02d",
                        duracion.toHours(), duracion.toMinutes() % 60, duracion.getSeconds() % 60);

                String fechaFinalFormateada = fechaFinal.format(formatter);


                if (context != null) {
                    Log.d("TAG", context.toString());

                    BD bdUtilitat = new BD(context);
                    SQLiteDatabase bd = bdUtilitat.getWritableDatabase();

                    ContentValues valores = new ContentValues();
                    valores.put("data", fechaFormateada);
                    valores.put("puntuacio", duracionFormateada);
                    valores.put("ratxe", ratxa);
                    long id;
                    id = bd.insert("Resultats",null,valores);
                    Intent intent = new Intent(context, Benvinguda.class);
                    startActivity(intent);

                    bd.close();
                }

                return true;
            }
            else{
                nErrors = 0;
            progressBar.incrementProgressBy(10);
                String text1 = String.valueOf(ratxa);
                score.setText("Ratxa: " + text1);
            textPista.setText("");
            FinalPartida();
                return true;
            }

        }
        else{
            ratxa = 0;
            nErrors++;
            progressBar.setProgress(0);
            String text1 = String.valueOf(ratxa);
            score.setText("Ratxa: " + text1);
            String[]pistes = arrayPelicules[contador].getPistes();
            textPista.setText(pistes[nErrors]);
            FinalPartida();
            return false;
        }
    }
    public void FinalPartida(){
        if(ratxa == 10) {
            Intent intent = new Intent(Partida.this, Benvinguda.class);
            startActivity(intent);
        }
    }

}
