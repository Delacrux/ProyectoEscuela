package com.mycompany.proyectoescuela;

public class RecursosDigitales {
    // --------------- Atributos  ---------------
    private String tituloMaterial;
    private String url;
    private String detalles;
    
    // --------------- Constructor  --------------
    public RecursosDigitales(String tituloMaterial, String url, String detalles) {
        this.tituloMaterial = tituloMaterial;
        this.url = url;
        this.detalles = detalles;
    }
    // --------------- Getter y Setter  ---------------
    public String getTituloMaterial() {
        return tituloMaterial;
    }

    public void setTituloMaterial(String tituloMaterial) {
        this.tituloMaterial = tituloMaterial;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    
    
    
    
    
}
