package com.example.quiz_android;

public class Resources {
    private static  int [] idImatges = {
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

    private static  String[] respostes = {
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


    public static int [] getIdImatges() {
        return idImatges;
    }

    public static String[] getRespostes() {
        return respostes;
    }
}

