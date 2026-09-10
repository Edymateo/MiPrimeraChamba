package taller;

// 3.4
import java.util.Scanner;

public class EtapaDeVida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad = -1; // valor inicial inválido a propósito, para entrar al ciclo

        while (edad < 1 || edad > 120) {
            System.out.print("Ingrese la edad: ");
            edad = sc.nextInt();
            if (edad < 1 || edad > 120) {
                System.out.println("Edad inválida, intenta de nuevo");
            }
        }

        String etapa;

        if (edad <= 12) {
            etapa = "Niñez";
        } else if (edad <= 17) {
            etapa = "Adolescencia";
        } else if (edad <= 25) {
            etapa = "Juventud";
        } else if (edad <= 59) {
            etapa = "Adultez";
        } else {
            etapa = "Tercera edad";
        }

        System.out.println(edad);
        System.out.println(etapa);

        sc.close();
    }
}
