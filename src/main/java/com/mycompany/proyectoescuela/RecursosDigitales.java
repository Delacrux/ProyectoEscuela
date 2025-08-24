package com.mycompany.proyectoescuela;

public class RecursosDigitales {
    // --------------- Atributos  ---------------
    private String tituloMaterial;
    private String url;
    private String detalles;
    
    // --------------- Constructor  --------------
    public RecursosDigitales(String titulo, String url, String detalles) {
        this.tituloMaterial = titulo;
        this.url = url;
        this.detalles = detalles;
    }
    // --------------- Getter y Setter  ---------------
    public String getTituloMaterial() {
        return tituloMaterial;
    }
    public String getDetalles() {
        return detalles;
    }
    public String getUrl() {
        return url;
    }
    
    public void setTituloMaterial(String tituloMaterial) {
        this.tituloMaterial = tituloMaterial;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void imprimirRecursoDigital() {
        System.out.println(" =============================== ");
        System.out.println(" Título: " + this.tituloMaterial);
        System.out.println("URL: " + this.url);
        System.out.println("Detalles: " + this.detalles);
        System.out.println(" =============================== ");
    }
    
    
    
    
    
}
