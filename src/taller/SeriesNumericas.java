package taller;

// 3.3
import java.util.Scanner;

public class SeriesNumericas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese n: ");
        int n = sc.nextInt();

        // Serie 1: naturales
        int sumaNaturales = 0;
        for (int i = 1; i <= n; i++) {
            sumaNaturales = sumaNaturales + i;
        }
        int formulaNaturales = n * (n + 1) / 2;

        // Serie 2: pares
        int sumaPares = 0;
        for (int i = 1; i <= n; i++) {
            sumaPares = sumaPares + (2 * i);
        }
        int formulaPares = n * (n + 1);

        // Serie 3: cuadrados
        int sumaCuadrados = 0;
        for (int i = 1; i <= n; i++) {
            sumaCuadrados = sumaCuadrados + (i * i);
        }
        int formulaCuadrados = n * (n + 1) * (2 * n + 1) / 6;

        // Imprimir cada suma junto a su fórmula, para verificar que coinciden
        System.out.println(sumaNaturales + " - " + formulaNaturales);
        System.out.println(sumaPares + " - " + formulaPares);
        System.out.println(sumaCuadrados + " - " + formulaCuadrados);

        sc.close();
    }
}
