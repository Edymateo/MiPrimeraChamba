package com.biblioteca.modelo;

/**
 * Clase abstracta para cualquier recurso de la biblioteca (libro o digital).
 */
public abstract class Recurso {

    private String titulo;
    private String codigo;
    private int anio;

    public Recurso(String titulo, String codigo, int anio) {
        Validador.validarCodigo(codigo);
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (anio < 1450 || anio > 2026) {
            throw new IllegalArgumentException("Año inválido: " + anio);
        }
        this.titulo = titulo;
        this.codigo = codigo;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getAnio() {
        return anio;
    }

    /** Polimorfismo dinámico: cada subclase describe su información. */
    public abstract String obtenerInfo();
}
