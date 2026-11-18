package com.biblioteca.modelo;

/**
 * Asociación entre un Bibliotecario y un Recurso prestado a un lector.
 */
public class Prestamo {

    private String fecha;
    private String observacion;
    private String lector;
    private Recurso recurso;
    private Bibliotecario bibliotecario;

    public Prestamo(String fecha, String observacion, String lector,
                    Recurso recurso, Bibliotecario bibliotecario) {
        this.fecha = fecha;
        this.observacion = observacion;
        this.lector = lector;
        this.recurso = recurso;
        this.bibliotecario = bibliotecario;
    }

    public String getInfo() {
        return "Préstamo: " + fecha + " | Lector: " + lector
                + " | Recurso: " + recurso.getTitulo()
                + " | Bibliotecario: " + bibliotecario.getNombre()
                + " | Nota: " + observacion;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public String getFecha() {
        return fecha;
    }
}
