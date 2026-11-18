package com.biblioteca.modelo;

/**
 * Auxiliar de biblioteca, con un turno asignado.
 */
public class Auxiliar extends Personal {

    private String turno;

    public Auxiliar(String nombre, String id, String area, String turno) {
        super(nombre, id, area);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    /** SOBREESCRITURA (polimorfismo dinámico). */
    @Override
    public String generarReporte() {
        return "=== AUXILIAR ===\nNombre: " + getNombre()
                + "\nID: " + getId()
                + "\nÁrea: " + getArea()
                + "\nTurno: " + turno;
    }
}
