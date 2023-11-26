package com.example.quiz_android;

public class Resultat {
    private String puntuacion;
    private String fecha;
    private String racha;

    public Resultat(String puntuacion, String fecha, String racha) {
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.racha = racha;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRacha() {
        return racha;
    }

    public void setRacha(String racha) {
        this.racha = racha;
    }
}
