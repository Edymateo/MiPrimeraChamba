package com.biblioteca.app;

import com.biblioteca.excepciones.PersonalNoEncontradoException;
import com.biblioteca.excepciones.PrestamoInvalidoException;
import com.biblioteca.excepciones.RecursoNoEncontradoException;
import com.biblioteca.excepciones.SeccionLlenaException;
import com.biblioteca.modelo.Auxiliar;
import com.biblioteca.modelo.Biblioteca;
import com.biblioteca.modelo.Bibliotecario;
import com.biblioteca.modelo.Libro;
import com.biblioteca.modelo.Prestamo;
import com.biblioteca.modelo.Recurso;
import com.biblioteca.modelo.RecursoDigital;
import com.biblioteca.modelo.Seccion;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menú principal del Sistema de Gestión de Biblioteca Universitaria.
 */
public class App {

    private static final ArrayList<Recurso> recursosRegistrados = new ArrayList<>();
    private static Biblioteca biblioteca;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        biblioteca = new Biblioteca("Biblioteca Central Los Libertadores");

        Bibliotecario b1 = new Bibliotecario("Marta Rojas", "B001", "Circulación");
        Bibliotecario b2 = new Bibliotecario("Julián Pardo", "B002", "Referencia");
        Auxiliar a1 = new Auxiliar("Diana Cruz", "A001", "Catalogación", "Tarde");

        biblioteca.agregarPersonal(b1);
        biblioteca.agregarPersonal(b2);
        biblioteca.agregarPersonal(a1);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");
            System.out.println();
            switch (opcion) {
                case 1:  registrarRecurso(sc); break;
                case 2:  listarRecursosRegistrados(); break;
                case 3:  ubicarRecurso(sc); break;
                case 4:  registrarPrestamo(sc); break;
                case 5:  verRecursosSeccion(sc); break;
                case 6:  verPrestamosBibliotecario(sc); break;
                case 7:  darDeBajaRecurso(sc); break;
                case 8:  buscarRecursoPorCodigo(sc); break;
                case 9:  biblioteca.generarReporteGeneral(); break;
                case 10: crearSeccion(sc); break;
                case 0:  System.out.println("Saliendo del sistema. ¡Hasta pronto!"); break;
                default: System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== " + biblioteca.getNombre() + " =====");
        System.out.println("1. Registrar recurso");
        System.out.println("2. Listar recursos registrados");
        System.out.println("3. Ubicar recurso en una sección");
        System.out.println("4. Registrar préstamo");
        System.out.println("5. Ver recursos de una sección");
        System.out.println("6. Ver préstamos de un bibliotecario");
        System.out.println("7. Dar de baja un recurso de una sección");
        System.out.println("8. Buscar recurso por código");
        System.out.println("9. Reporte general de la biblioteca");
        System.out.println("10. Crear nueva sección");
        System.out.println("0. Salir");
    }

    // ------------------------------------------------------------------
    // Utilidades de lectura
    // ------------------------------------------------------------------

    /** Insiste hasta recibir un entero válido (protege contra InputMismatchException). */
    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // consumir el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida: debe ingresar un número entero.");
                sc.nextLine(); // limpiar el buffer
            }
        }
    }

    private static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    /**
     * Decisión de equipo (ver README): primero se busca en las secciones de la
     * biblioteca y, si no está ubicado, en la lista de recursos registrados.
     */
    private static Recurso buscarRecursoGlobal(String codigo) throws RecursoNoEncontradoException {
        try {
            return biblioteca.buscarRecurso(codigo);
        } catch (RecursoNoEncontradoException e) {
            Recurso r = buscarEnRegistrados(codigo);
            if (r == null) {
                throw e;
            }
            return r;
        }
    }

    private static Recurso buscarEnRegistrados(String codigo) {
        for (Recurso r : recursosRegistrados) {
            if (r.getCodigo().equals(codigo)) {
                return r;
            }
        }
        return null;
    }

    // ------------------------------------------------------------------
    // Opciones del menú
    // ------------------------------------------------------------------

    /** Opción 1. */
    private static void registrarRecurso(Scanner sc) {
        int tipo = leerEntero(sc, "Tipo de recurso (1 = Libro, 2 = Digital): ");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido");
            return;
        }
        String titulo = leerTexto(sc, "Título: ");
        String codigo = leerTexto(sc, "Código: ");
        if (buscarEnRegistrados(codigo) != null) {
            System.out.println("Error: ya existe un recurso registrado con el código " + codigo + ".");
            return;
        }
        int anio = leerEntero(sc, "Año de publicación: ");
        try {
            Recurso nuevo;
            if (tipo == 1) {
                String autor = leerTexto(sc, "Autor: ");
                int paginas = leerEntero(sc, "Número de páginas: ");
                nuevo = new Libro(titulo, codigo, anio, autor, paginas);
            } else {
                String formato = leerTexto(sc, "Formato (PDF, EPUB, MP4...): ");
                int tamano = leerEntero(sc, "Tamaño en MB: ");
                nuevo = new RecursoDigital(titulo, codigo, anio, formato, tamano);
            }
            recursosRegistrados.add(nuevo);
            System.out.println("Recurso registrado correctamente: " + nuevo.obtenerInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /** Opción 2. */
    private static void listarRecursosRegistrados() {
        if (recursosRegistrados.isEmpty()) {
            System.out.println("No hay recursos registrados.");
            return;
        }
        System.out.println("--- Recursos registrados ---");
        for (Recurso r : recursosRegistrados) {
            System.out.println(r.obtenerInfo()); // polimorfismo dinámico
        }
    }

    /** Opción 3. */
    private static void ubicarRecurso(Scanner sc) {
        String codigo = leerTexto(sc, "Código del recurso a ubicar: ");
        Recurso recurso = buscarEnRegistrados(codigo);
        if (recurso == null) {
            System.out.println("Error: el recurso con código " + codigo + " no está registrado.");
            return;
        }
        try {
            biblioteca.buscarRecurso(codigo);
            System.out.println("Error: el recurso ya está ubicado en una sección.");
            return;
        } catch (RecursoNoEncontradoException e) {
            // No está ubicado todavía: se puede continuar
        }
        mostrarSecciones();
        String nombreSeccion = leerTexto(sc, "Nombre de la sección: ");
        Seccion seccion = biblioteca.buscarSeccion(nombreSeccion);
        if (seccion == null) {
            System.out.println("Error: la sección '" + nombreSeccion + "' no existe.");
            return;
        }
        try {
            seccion.agregarRecurso(recurso);
        } catch (SeccionLlenaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /** Opción 4. */
    private static void registrarPrestamo(Scanner sc) {
        biblioteca.listarBibliotecarios();
        String id = leerTexto(sc, "ID del bibliotecario: ");
        try {
            Bibliotecario bibliotecario = biblioteca.buscarBibliotecario(id);
            String codigo = leerTexto(sc, "Código del recurso: ");
            Recurso recurso = buscarRecursoGlobal(codigo);
            String fecha = leerTexto(sc, "Fecha (dd/mm/aaaa): ");
            String lector = leerTexto(sc, "Nombre del lector: ");
            String resp = leerTexto(sc, "¿Desea agregar una observación? (s/n): ");
            if (resp.equalsIgnoreCase("s")) {
                String observacion = leerTexto(sc, "Observación: ");
                bibliotecario.registrarPrestamo(fecha, lector, observacion, recurso);
            } else {
                bibliotecario.registrarPrestamo(fecha, lector, recurso);
            }
        } catch (PersonalNoEncontradoException | RecursoNoEncontradoException
                 | PrestamoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /** Opción 5. */
    private static void verRecursosSeccion(Scanner sc) {
        mostrarSecciones();
        String nombreSeccion = leerTexto(sc, "Nombre de la sección: ");
        Seccion seccion = biblioteca.buscarSeccion(nombreSeccion);
        if (seccion == null) {
            System.out.println("Error: la sección '" + nombreSeccion + "' no existe.");
            return;
        }
        System.out.println("--- Recursos en " + seccion.getNombre() + " ---");
        seccion.listarRecursos();
    }

    /** Opción 6. */
    private static void verPrestamosBibliotecario(Scanner sc) {
        biblioteca.listarBibliotecarios();
        String id = leerTexto(sc, "ID del bibliotecario: ");
        try {
            Bibliotecario b = biblioteca.buscarBibliotecario(id);
            ArrayList<Prestamo> prestamos = b.getPrestamos();
            if (prestamos.isEmpty()) {
                System.out.println(b.getNombre() + " no tiene préstamos registrados.");
                return;
            }
            System.out.println("--- Préstamos de " + b.getNombre() + " ---");
            for (Prestamo p : prestamos) {
                System.out.println(p.getInfo());
            }
        } catch (PersonalNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /** Opción 7. */
    private static void darDeBajaRecurso(Scanner sc) {
        mostrarSecciones();
        String nombreSeccion = leerTexto(sc, "Nombre de la sección: ");
        Seccion seccion = biblioteca.buscarSeccion(nombreSeccion);
        if (seccion == null) {
            System.out.println("Error: la sección '" + nombreSeccion + "' no existe.");
            return;
        }
        String codigo = leerTexto(sc, "Código del recurso a dar de baja: ");
        try {
            seccion.retirarRecurso(codigo);
        } catch (RecursoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /** Opción 8. */
    private static void buscarRecursoPorCodigo(Scanner sc) {
        String codigo = leerTexto(sc, "Código del recurso: ");
        try {
            Recurso r = biblioteca.buscarRecurso(codigo);
            System.out.println("Encontrado (ubicado en sección): " + r.obtenerInfo());
        } catch (RecursoNoEncontradoException e) {
            Recurso r = buscarEnRegistrados(codigo);
            if (r != null) {
                System.out.println("Encontrado (registrado, sin sección): " + r.obtenerInfo());
            } else {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /** Opción 10. */
    private static void crearSeccion(Scanner sc) {
        String nombre = leerTexto(sc, "Nombre de la nueva sección: ");
        int capacidad = leerEntero(sc, "Capacidad: ");
        try {
            biblioteca.agregarSeccion(nombre, capacidad);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarSecciones() {
        System.out.print("Secciones disponibles: ");
        ArrayList<Seccion> secciones = biblioteca.getSecciones();
        for (int i = 0; i < secciones.size(); i++) {
            System.out.print(secciones.get(i).getNombre() + (i < secciones.size() - 1 ? ", " : "\n"));
        }
    }
}
