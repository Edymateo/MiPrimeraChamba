package taller;
// 1.5
import java.util.Scanner;

public class NotaFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese p1, p2 y pf: ");
        double p1 = sc.nextDouble();
        double p2 = sc.nextDouble();
        double pf = sc.nextDouble();

        double definitiva = (p1 * 0.30) + (p2 * 0.30) + (pf * 0.40);
        String estado = (definitiva >= 3.0) ? "Aprobado" : "Reprobado";

        System.out.printf("%.2f%n", definitiva);
        System.out.println(estado);

        sc.close();
    }
}