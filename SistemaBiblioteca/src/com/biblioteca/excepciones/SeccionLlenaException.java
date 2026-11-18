package com.biblioteca.excepciones;

/**
 * Se lanza cuando se intenta ubicar un recurso en una sección
 * que ya alcanzó su capacidad máxima.
 */
public class SeccionLlenaException extends Exception {
    public SeccionLlenaException(String mensaje) {
        super(mensaje);
    }
}
