package com.example.quiz_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Benvinguda extends AppCompatActivity {
    private Button start;
    private TextView bestScore;

    public Benvinguda(){}
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_benvinguda);
        start = findViewById(R.id.start);
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        tableLayout.setGravity(Gravity.CENTER);
        tableLayout.setStretchAllColumns(true);
        ImageView menuSettings = findViewById(R.id.menuSettings);

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
        getPuntuacio(getBaseContext(),tableLayout);

    }
    public void getPuntuacio(Context context, TableLayout tableLayout) {
        BD bdUtilitat = new BD(context);
        SQLiteDatabase bd = bdUtilitat.getWritableDatabase();
        String[] projeccio = {
                "data",
                "puntuacio",
                "ratxe"
        };

        String ordre = "puntuacio ASC";

        Cursor c = bd.query(
                "Resultats",  // taula
                projeccio,                               // columnes
                null,                                // columnes WHERE
                null,                            // valors WHERE
                null,                                     // GROUP
                null,                                     // HAVING
                ordre,
                "5"
        );

        int columnaPuntuacio = c.getColumnIndex("puntuacio");
        int columnaData = c.getColumnIndex("data");

        if (c.moveToFirst()) {
            int i = 0;
            do {
                i++;
                TableRow row = new TableRow(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                row.setLayoutParams(layoutParams);
                generarFila(row, c.getString(columnaData), c.getString(columnaPuntuacio), tableLayout, i);
            } while (c.moveToNext());
        } else {
            // Handle the case where the cursor is empty
            Log.d("CursorInfo", "Cursor is empty");
        }

        // Close the cursor and database when done
        c.close();
        bd.close();
    }

    public void generarFila(TableRow row, String data, String puntuacio ,TableLayout tableLayout,int i) {
        TextView textView2 = new TextView(this);
        textView2.setText(i + ". ");
        textView2.setPadding(16, 8, 16, 8);
        textView2.setGravity(Gravity.CENTER);
        textView2.setTextSize(18);  // Tamaño de texto más grande
        textView2.setTextColor(getResources().getColor(android.R.color.white));
        row.addView(textView2);

        TextView textView1 = new TextView(this);
        textView1.setText(puntuacio);
        textView1.setPadding(16, 8, 16, 8);
        textView1.setGravity(Gravity.CENTER);
        textView1.setTextSize(18);  // Tamaño de texto más grande
        textView1.setTextColor(getResources().getColor(android.R.color.white));
        row.addView(textView1);

        TextView textView = new TextView(this);
        textView.setText(data);
        textView.setPadding(16, 8, 16, 8);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(18);  // Tamaño de texto más grande
        textView.setTextColor(getResources().getColor(android.R.color.white));
        row.addView(textView);

        tableLayout.addView(row);
    }
}
