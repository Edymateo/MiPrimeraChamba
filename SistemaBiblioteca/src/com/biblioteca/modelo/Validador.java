package com.biblioteca.modelo;

/**
 * Clase de utilidad con validaciones reutilizables.
 * No se instancia: constructor privado y métodos estáticos.
 */
public class Validador {

    private Validador() {
        // Evita la instanciación
    }

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        for (char c : nombre.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("El nombre no puede contener números: " + nombre);
            }
        }
    }

    public static void validarCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty() || codigo.contains(" ")) {
            throw new IllegalArgumentException("Código inválido: no puede ser vacío ni tener espacios.");
        }
    }
}
