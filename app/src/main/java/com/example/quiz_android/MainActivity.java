package com.example.quiz_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button rb1;
    private Button rb2;
    private Button rb3;
    private Button rb4;
    private TextView textResposta;
    private ImageView imatge;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb1 = findViewById(R.id.resposta1);
        rb2 = findViewById(R.id.resposta2);
        rb3 = findViewById(R.id.resposta3);
        rb4 = findViewById(R.id.resposta4);
        imatge = findViewById(R.id.imatge);
        textResposta = findViewById(R.id.textResposta);
        int [] idImatges = {
                R.drawable.ironman,
                R.drawable.hulk,
                R.drawable.avengers,
                R.drawable.spiderman,
                R.drawable.guardiansofthegalaxy,
                R.drawable.daredevil,
                R.drawable.blackpanther,
                R.drawable.doctorstrange,
                R.drawable.deadpool,
                R.drawable.thor
        };

        String[] respostes = {
                "Iron Man",
                "The Incredible Hulk",
                "The Avengers",
                "Spider-Man",
                "Guardians of the Galaxy",
                "Daredevil",
                "Black Panther",
                "Doctor Strange",
                "Deadpool",
                "Thor"

        };
        Metode.generadorPelicules(respostes,idImatges);
        Metode.mostrarPeliculaAleatoria(Metode.generadorPelicules(respostes,idImatges),imatge, rb1, rb2, rb3, rb4);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Metode.mostrarPeliculaAleatoria(Metode.generadorPelicules(respostes,idImatges),imatge, rb1, rb2, rb3, rb4);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Metode.mostrarPeliculaAleatoria(Metode.generadorPelicules(respostes,idImatges),imatge, rb1, rb2, rb3, rb4);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Metode.mostrarPeliculaAleatoria(Metode.generadorPelicules(respostes,idImatges),imatge, rb1, rb2, rb3, rb4);
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Metode.mostrarPeliculaAleatoria(Metode.generadorPelicules(respostes,idImatges),imatge, rb1, rb2, rb3, rb4);
            }
        });
    }
}