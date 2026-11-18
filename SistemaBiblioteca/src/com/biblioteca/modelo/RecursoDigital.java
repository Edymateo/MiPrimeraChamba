package com.biblioteca.modelo;

/**
 * Recurso digital (PDF, EPUB, video, etc.). Clase final: no puede heredarse.
 */
public final class RecursoDigital extends Recurso {

    private String formato;
    private int tamanoMB;

    public RecursoDigital(String titulo, String codigo, int anio, String formato, int tamanoMB) {
        super(titulo, codigo, anio);
        if (tamanoMB <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor a 0 MB.");
        }
        this.formato = formato;
        this.tamanoMB = tamanoMB;
    }

    public String getFormato() {
        return formato;
    }

    public int getTamanoMB() {
        return tamanoMB;
    }

    /** SOBREESCRITURA. */
    @Override
    public String obtenerInfo() {
        return "Recurso digital: " + getTitulo() + " | Código: " + getCodigo() + " | Año: " + getAnio()
                + " | Formato: " + formato + " | Tamaño: " + tamanoMB + " MB";
    }
}
