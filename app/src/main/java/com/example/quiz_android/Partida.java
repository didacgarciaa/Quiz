package com.example.quiz_android;


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
    public boolean comprobarResposta(String resposta, Pelicula[] arrayPelicules, ProgressBar progressBar, TextView score,TextView textPista) {

        if(resposta.equals(arrayPelicules[contador].getResposta())){
            contador ++;
            ratxa ++;
            nErrors = 0;
            progressBar.incrementProgressBy(10);
            String text1 = String.valueOf(ratxa);
            score.setText("Ratxa: " + text1);
            textPista.setText("");
            FinalPartida();
            return true;
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
