package com.example.quiz_android;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BD extends SQLiteOpenHelper {
    private static final String SQL_CREACIO_TAULA = "CREATE TABLE IF NOT EXISTS Resultats (" +
            "codi INT PRIMARY KEY," +
            "puntuacio INT," +
            "ratxe VARCHAR(255)," +
            "data DATE" +
            ")";

    private static final String SQL_ESBORRAT_TAULA = "DROP TABLE IF EXISTS "
            + "Resultats";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Resultats.db";

    public BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREACIO_TAULA);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_ESBORRAT_TAULA);
        onCreate(db);
    }
}

 
