package com.example.quiz_android;

public class Resources {
    private static  int [] idImatges = {
            R.drawable.ironman4,
            R.drawable.hulk4,
            R.drawable.avengers4,
            R.drawable.spiderman4,
            R.drawable.guardiansofthegalaxy4,
            R.drawable.daredevil4,
            R.drawable.blackpanther4,
            R.drawable.doctorstrange4,
            R.drawable.deadpool4,
            R.drawable.thor4
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

