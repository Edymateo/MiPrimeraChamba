package com.biblioteca.excepciones;

/**
 * Se lanza cuando no existe personal (bibliotecario) con el id buscado.
 */
public class PersonalNoEncontradoException extends Exception {
    public PersonalNoEncontradoException(String id) {
        super("No existe personal registrado con id " + id + ".");
    }
}
