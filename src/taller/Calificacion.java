package taller;

// 2.3
import java.util.Scanner;

public class Calificacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la nota (0.0 a 5.0): ");
        double nota = sc.nextDouble();

        char letra;
        String descripcion;

        if (nota >= 4.6) {
            letra = 'A';
            descripcion = "Excelente";
        } else if (nota >= 4.0) {
            letra = 'B';
            descripcion = "Sobresaliente";
        } else if (nota >= 3.5) {
            letra = 'C';
            descripcion = "Aceptable";
        } else if (nota >= 3.0) {
            letra = 'D';
            descripcion = "Aprobado mínimo";
        } else {
            letra = 'F';
            descripcion = "Reprobado";
        }

        System.out.println(nota);
        System.out.println(letra);
        System.out.println(descripcion);

        sc.close();
    }
}
