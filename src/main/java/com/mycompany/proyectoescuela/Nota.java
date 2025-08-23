package com.mycompany.proyectoescuela;

public class Nota {
// --------------- Atributos  ---------------
    private float nota;
    private String detalleNota;
// --------------- Constructor  ---------------
    public Nota(float nota, String detalle) {
    this.nota = nota;
    this.detalleNota = detalle;
    }
// --------------- Getter y Setter  ---------------
    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getDetalleNota() {
        return detalleNota;
    }

    public void setDetalleNota(String detalleNota) {
        this.detalleNota = detalleNota;
    }





}