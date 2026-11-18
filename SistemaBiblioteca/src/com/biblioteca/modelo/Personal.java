package com.biblioteca.modelo;

/**
 * Clase abstracta que representa a cualquier miembro del personal de la biblioteca.
 */
public abstract class Personal {

    private String nombre;
    private String id;
    private String area;

    public Personal(String nombre, String id, String area) {
        Validador.validarNombre(nombre);
        this.nombre = nombre;
        this.id = id;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    /** Polimorfismo dinámico: cada subclase define su propio reporte. */
    public abstract String generarReporte();
}
