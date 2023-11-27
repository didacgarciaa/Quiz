package com.example.quiz_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button[] buttons = new Button[4];
    private ImageView imatge;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Partida partida = new Partida();
        imatge = findViewById(R.id.imatge);
        ImageView backArrow = findViewById(R.id.backArrow);
        ImageView menuSettings = findViewById(R.id.menuSettings);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView score = findViewById(R.id.score);
        TextView textPista = findViewById(R.id.textPista);

        int [] idImatges = Resources.getIdImatges();
        String[] respostes = Resources.getRespostes();
        String[] pistes = getResources().getStringArray(R.array.pistes);
        Pelicula[] peliculas  = Metode.generadorPelicules(respostes,idImatges,this);

        for (int i = 0; i < 4; i++) {
            int ButtonId = getResources().getIdentifier("resposta" + (i + 1), "id", getPackageName());
            buttons[i] = findViewById(ButtonId);
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(partida.comprobarResposta(buttons[finalI].getText().toString(),peliculas,progressBar,score,getBaseContext(),textPista,imatge)){
                        partida.mostrarPelicula(peliculas,imatge ,buttons);
                    }
                }
            });
        }
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Benvinguda.class);
                finish();
                startActivity(intent);
            }
        });
        menuSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Torna-ho a intentar quan acabis la partida", Toast.LENGTH_SHORT).show();
            }
        });

        partida.mostrarPelicula(peliculas,imatge,buttons);

    }
}