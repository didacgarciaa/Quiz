package com.example.quiz_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaFinal extends AppCompatActivity {
    public PantallaFinal(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_final);
        ImageView backArrow = findViewById(R.id.backArrow);
        ImageView menuSettings = findViewById(R.id.menuSettings);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaFinal.this, Benvinguda.class);
                finish();
                startActivity(intent);
            }
        });
        menuSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaFinal.this, Setting.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
