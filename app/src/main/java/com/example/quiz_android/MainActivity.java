package com.example.quiz_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    private Button[] buttons = new Button[4];
    private TextView textResposta;
    private ImageView imatge;
    private Button verificar;
    private RadioGroup radioGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Partida partida = new Partida();
        imatge = findViewById(R.id.imatge);
        verificar = findViewById(R.id.btnCheck);
        textResposta = findViewById(R.id.textResposta);

        int [] idImatges = Resources.getIdImatges();
        String[] respostes = Resources.getRespostes();
        Pelicula[] peliculas  = Metode.generadorPelicules(respostes,idImatges);

        for (int i = 0; i < 4; i++) {
            int ButtonId = getResources().getIdentifier("resposta" + (i + 1), "id", getPackageName());
            buttons[i] = findViewById(ButtonId);
        }
        Log.d("1","ewew");

        partida.mostrarPelicula(peliculas,imatge , buttons);


        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                partida.mostrarPelicula(peliculas,imatge , buttons);
            }
        });
    }
}