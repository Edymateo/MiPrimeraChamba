package com.biblioteca.modelo;

import com.biblioteca.excepciones.PersonalNoEncontradoException;
import com.biblioteca.excepciones.RecursoNoEncontradoException;
import java.util.ArrayList;

/**
 * Biblioteca. COMPOSICIÓN con Seccion: la biblioteca crea sus secciones
 * internamente y, si la biblioteca desaparece, sus secciones también.
 */
public class Biblioteca {

    private String nombre;
    private ArrayList<Seccion> secciones;
    private ArrayList<Personal> personal;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.secciones = new ArrayList<>();
        this.personal = new ArrayList<>();
        // Secciones iniciales creadas internamente (composición)
        secciones.add(new Seccion("Referencia", 10));
        secciones.add(new Seccion("Literatura", 8));
        secciones.add(new Seccion("Ciencias", 6));
    }

    /** La Biblioteca crea el objeto Seccion internamente (se conserva la composición). */
    public void agregarSeccion(String nombre, int capacidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la sección no puede estar vacío.");
        }
        if (buscarSeccion(nombre) != null) {
            throw new IllegalArgumentException("Ya existe una sección llamada '" + nombre + "'.");
        }
        Seccion s = new Seccion(nombre, capacidad); // puede lanzar IllegalArgumentException
        secciones.add(s);
        System.out.println("Sección '" + nombre + "' creada con capacidad " + capacidad);
    }

    public void agregarPersonal(Personal p) {
        personal.add(p);
        System.out.println(p.getNombre() + " registrado en la biblioteca.");
    }

    public Seccion buscarSeccion(String nombre) {
        for (Seccion s : secciones) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                return s;
            }
        }
        return null;
    }

    public Recurso buscarRecurso(String codigo) throws RecursoNoEncontradoException {
        for (Seccion s : secciones) {
            try {
                return s.buscarRecurso(codigo);
            } catch (RecursoNoEncontradoException e) {
                // No está en esta sección: seguir buscando en la siguiente
            }
        }
        throw new RecursoNoEncontradoException(codigo);
    }

    public Bibliotecario buscarBibliotecario(String id) throws PersonalNoEncontradoException {
        for (Personal p : personal) {
            if (p instanceof Bibliotecario && p.getId().equals(id)) {
                return (Bibliotecario) p;
            }
        }
        throw new PersonalNoEncontradoException(id);
    }

    /** Lista solo los bibliotecarios del personal real (sin datos quemados). */
    public void listarBibliotecarios() {
        System.out.println("--- Bibliotecarios disponibles ---");
        boolean hay = false;
        for (Personal p : personal) {
            if (p instanceof Bibliotecario) {
                System.out.println(p.getId() + " - " + p.getNombre() + " (" + p.getArea() + ")");
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay bibliotecarios registrados.");
        }
    }

    public void generarReporteGeneral() {
        System.out.println("========== REPORTE GENERAL: " + nombre + " ==========");
        System.out.println("--- Secciones ---");
        for (Seccion s : secciones) {
            System.out.println("Sección: " + s.getNombre() + " | Ocupación: "
                    + s.getRecursos().size() + "/" + s.getCapacidad());
        }
        System.out.println("--- Personal (total: " + personal.size() + ") ---");
        for (Personal p : personal) {
            System.out.println(p.generarReporte()); // polimorfismo dinámico
            System.out.println();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }
}
