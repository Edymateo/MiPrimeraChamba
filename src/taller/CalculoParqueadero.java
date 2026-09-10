package taller;

// 2.4
import java.util.Scanner;

public class CalculoParqueadero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tipo de vehículo (1, 2 o 3): ");
        int tipo = sc.nextInt();

        System.out.print("Ingrese las horas: ");
        double horas = sc.nextDouble();

        double primeraHora;
        double horaAdicional;

        switch (tipo) {
            case 1:
                primeraHora = 2000;
                horaAdicional = 1500;
                break;
            case 2:
                primeraHora = 4000;
                horaAdicional = 3000;
                break;
            case 3:
                primeraHora = 5000;
                horaAdicional = 4000;
                break;
            default:
                System.out.println("Tipo de vehículo no válido");
                sc.close();
                return; // TERMINAR PROGRAMA
        }

        double total = primeraHora + (horaAdicional * (horas - 1));
        System.out.println(total);

        sc.close();
    }
}