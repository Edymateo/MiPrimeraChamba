package taller;

// 3.5
import java.util.Scanner;
import java.util.ArrayList;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese a y b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cantidad = 0;
        int suma = 0;
        ArrayList<Integer> listaPrimos = new ArrayList<>();

        for (int numero = a; numero <= b; numero++) {
            if (numero < 2) {
                continue; // 0 y 1 no son primos, salta al siguiente número
            }

            boolean esPrimo = true;
            int divisor = 2;

            while (divisor <= Math.sqrt(numero) && esPrimo) {
                if (numero % divisor == 0) {
                    esPrimo = false; // encontró un divisor exacto, no es primo
                }
                divisor = divisor + 1;
            }

            if (esPrimo) {
                listaPrimos.add(numero);
                cantidad = cantidad + 1;
                suma = suma + numero;
            }
        }

        System.out.println(listaPrimos);
        System.out.println(cantidad);
        System.out.println(suma);

        sc.close();
    }
}
