package com.biblioteca.modelo;

import com.biblioteca.excepciones.RecursoNoEncontradoException;
import com.biblioteca.excepciones.SeccionLlenaException;
import java.util.ArrayList;

/**
 * Sección de la biblioteca. AGREGACIÓN con Recurso: la sección puede existir
 * sin recursos y los recursos existen independientemente de la sección.
 * Guarda ArrayList<Recurso> (tipo abstracto) para aceptar libros y recursos digitales.
 */
public class Seccion {

    private String nombre;
    private int capacidad;
    private ArrayList<Recurso> recursos;

    public Seccion(String nombre, int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser mayor a 0.");
        }
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.recursos = new ArrayList<>();
    }

    public void agregarRecurso(Recurso r) throws SeccionLlenaException {
        if (recursos.size() >= capacidad) {
            throw new SeccionLlenaException("Sección " + nombre + " sin espacio disponible.");
        }
        recursos.add(r);
        System.out.println("Recurso " + r.getTitulo() + " ubicado en sección " + nombre);
    }

    public void retirarRecurso(String codigo) throws RecursoNoEncontradoException {
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i).getCodigo().equals(codigo)) {
                recursos.remove(i);
                System.out.println("Recurso dado de baja.");
                return;
            }
        }
        throw new RecursoNoEncontradoException(codigo);
    }

    public Recurso buscarRecurso(String codigo) throws RecursoNoEncontradoException {
        for (Recurso r : recursos) {
            if (r.getCodigo().equals(codigo)) {
                return r;
            }
        }
        throw new RecursoNoEncontradoException(codigo);
    }

    public void listarRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos en esta sección.");
            return;
        }
        for (Recurso r : recursos) {
            System.out.println(r.obtenerInfo()); // polimorfismo dinámico
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }
}
