package taller;

// 3.1
import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese n: ");
        int n = sc.nextInt();

        // Tabla simple del 1 al 12
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%4d%n", n * i);
        }

        // Cuadrícula: tablas del 1 al n
        for (int fila = 1; fila <= n; fila++) {
            for (int columna = 1; columna <= 12; columna++) {
                System.out.printf("%4d", fila * columna);
            }
            System.out.println();
        }

        sc.close();
    }
}