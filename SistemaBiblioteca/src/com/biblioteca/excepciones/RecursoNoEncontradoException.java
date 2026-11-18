package com.biblioteca.excepciones;

/**
 * Se lanza cuando no existe un recurso con el código buscado.
 */
public class RecursoNoEncontradoException extends Exception {
    public RecursoNoEncontradoException(String codigo) {
        super("Recurso con código " + codigo + " no encontrado.");
    }
}
