package taller;

// 2.1
import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese los tres lados (a, b, c): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        boolean esValido = (a + b > c) && (a + c > b) && (b + c > a);

        if (!esValido) {
            System.out.println("No es un triángulo válido");
        } else {
            if (a == b && b == c) {
                System.out.println("Equilátero");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isósceles");
            } else {
                System.out.println("Escaleno");
            }
        }

        sc.close();
    }
}