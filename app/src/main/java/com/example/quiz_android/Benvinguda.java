package com.example.quiz_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class Benvinguda extends AppCompatActivity {
    private Button start;
    private TextView bestScore;

    public Benvinguda(){}
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_benvinguda);
        start = findViewById(R.id.start);
        ImageView menuSettings = findViewById(R.id.menuSettings);
        bestScore = findViewById(R.id.bestScore);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Benvinguda.this, MainActivity.class);
                startActivity(intent);
            }
        });
        menuSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Benvinguda.this, Setting.class);
                startActivity(intent);
            }
        });
    }
}
