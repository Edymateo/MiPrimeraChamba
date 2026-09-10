package taller;

// InvertirArreglo
import java.util.Scanner;

class InvertirArreglo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] arreglo = new int[n];

        for (int i = 0; i <= n - 1; i++) {
            System.out.print("arreglo[" + i + "]: ");
            arreglo[i] = Integer.parseInt(sc.nextLine().trim());
        }

        System.out.print("Original: ");
        imprimirArreglo(arreglo);

        for (int i = 0; i <= (n / 2 - 1); i++) {
            int temp = arreglo[i];
            arreglo[i] = arreglo[n - 1 - i];
            arreglo[n - 1 - i] = temp;
        }

        System.out.print("Invertido: ");
        imprimirArreglo(arreglo);
    }

    static void imprimirArreglo(int[] arreglo) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}