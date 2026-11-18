package com.biblioteca.modelo;

import com.biblioteca.excepciones.PrestamoInvalidoException;
import java.util.ArrayList;

/**
 * Bibliotecario: registra préstamos de recursos a lectores.
 */
public class Bibliotecario extends Personal {

    private ArrayList<Prestamo> prestamos;

    public Bibliotecario(String nombre, String id, String area) {
        super(nombre, id, area);
        this.prestamos = new ArrayList<>();
    }

    /** SOBRECARGA 1: préstamo sin observación (se usa "Préstamo estándar"). */
    public void registrarPrestamo(String fecha, String lector, Recurso recurso)
            throws PrestamoInvalidoException {
        validarDatosBasicos(fecha, lector, recurso);
        Prestamo p = new Prestamo(fecha, "Préstamo estándar", lector, recurso, this);
        prestamos.add(p);
        System.out.println("Préstamo registrado: " + recurso.getTitulo() + " a " + lector);
    }

    /** SOBRECARGA 2: préstamo con observación. */
    public void registrarPrestamo(String fecha, String lector, String observacion, Recurso recurso)
            throws PrestamoInvalidoException {
        validarDatosBasicos(fecha, lector, recurso);
        if (observacion == null || observacion.trim().isEmpty()) {
            throw new PrestamoInvalidoException("La observación no puede estar vacía.");
        }
        Prestamo p = new Prestamo(fecha, observacion, lector, recurso, this);
        prestamos.add(p);
        System.out.println("Préstamo registrado: " + recurso.getTitulo() + " a " + lector
                + " (" + observacion + ")");
    }

    /** Validaciones comunes a ambas versiones de registrarPrestamo. */
    private void validarDatosBasicos(String fecha, String lector, Recurso recurso)
            throws PrestamoInvalidoException {
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new PrestamoInvalidoException("La fecha no puede estar vacía.");
        }
        if (lector == null || lector.trim().isEmpty()) {
            throw new PrestamoInvalidoException("Debe indicarse el nombre del lector.");
        }
        if (recurso == null) {
            throw new PrestamoInvalidoException("Debe indicarse un recurso válido.");
        }
    }

    /** SOBREESCRITURA (polimorfismo dinámico). */
    @Override
    public String generarReporte() {
        return "=== BIBLIOTECARIO ===\nNombre: " + getNombre()
                + "\nID: " + getId()
                + "\nÁrea: " + getArea()
                + "\nPréstamos registrados: " + prestamos.size();
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
}
