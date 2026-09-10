package taller;

// 2.2
import java.util.Scanner;

public class CalculoIMC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese peso y estatura: ");
        double peso = sc.nextDouble();
        double estatura = sc.nextDouble();

        double imc = peso / (estatura * estatura);
        String categoria;

        if (imc < 18.5) {
            categoria = "Bajo peso";
        } else if (imc <= 24.9) {
            categoria = "Peso normal";
        } else if (imc <= 29.9) {
            categoria = "Sobrepeso";
        } else {
            categoria = "Obesidad";
        }

        System.out.println(imc);
        System.out.println(categoria);

        sc.close();
    }
}
