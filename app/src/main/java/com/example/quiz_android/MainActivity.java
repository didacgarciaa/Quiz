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

import java.util.Random;


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

        mostrarRespuestas();

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarRespuestas();
            }
        });
    }
    public void mostrarRespuestas (){

        radioGroup.clearCheck();

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

        Random random = new Random();
        int respostaCorrecta = random.nextInt  (10);
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
                respostes[respostaCorrecta],
                respostes[respostaIncorrecta1],
                respostes[respostaIncorrecta2],
                respostes[respostaIncorrecta3]
        };
        barrejaRespostes(respostesValides);
        imatge.setImageResource(idImatges[respostaCorrecta]);

        rb1.setText(respostesValides[0]);
        rb2.setText(respostesValides[1]);
        rb3.setText(respostesValides[2]);
        rb4.setText(respostesValides[3]);

        int seleccioFinal = radioGroup.getCheckedRadioButtonId();
        comprovador(seleccioFinal,respostes,respostaCorrecta);

    }

    public void barrejaRespostes(String[] respostesValides) {
        Random random = new Random();
        for (int i = respostesValides.length - 1; i > 0; i--) {
            int index = random.nextInt(i);
            String respostaSelecionada = respostesValides[i];
            respostesValides[i] = respostesValides[index];
            respostesValides[index] = respostaSelecionada;
        }
    }

    public void comprovador(int seleccioFinal,String[] respostes,int respostaCorrecta){
        for (int i = 0; i < 5; i++) {
            if(seleccioFinal == rb1.getId()){
                if(rb1.getText().toString().equals(respostes[respostaCorrecta])){
                    textResposta.setText("Has encertat");
                }
            } else if (seleccioFinal == rb2.getId()) {
                if(rb2.getText().toString().equals(respostes[respostaCorrecta])){
                    textResposta.setText("Has encertat");
                }
            } else if (seleccioFinal == rb2.getId()) {
                if(rb3.getText().toString().equals(respostes[respostaCorrecta])){
                    textResposta.setText("Has encertat");
                }
            } else if (seleccioFinal == rb4.getId()) {
                if(rb3.getText().toString().equals(respostes[respostaCorrecta])){
                    textResposta.setText("Has encertat");
                }
            } else{
                textResposta.setText("T'has equivocat");
            }
        }
    }


}