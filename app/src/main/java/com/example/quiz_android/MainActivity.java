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

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private TextView textResposta;
    private ImageView imatge;
    private Button verificar;
    private RadioGroup radioGroup;

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
        verificar = findViewById(R.id.btnCheck);
        textResposta = findViewById(R.id.textResposta);
        radioGroup = findViewById(R.id.radioGroup);
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
        Metode.mostrarPeliculaAleatoria(Metode.generadorPelicules(respostes,idImatges),imatge, radioGroup, rb1, rb2, rb3, rb4);

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Metode.mostrarPeliculaAleatoria(Metode.generadorPelicules(respostes,idImatges),imatge, radioGroup, rb1, rb2, rb3, rb4);
            }
        });
    }
}