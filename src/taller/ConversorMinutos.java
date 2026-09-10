package taller;

// 1.4
import java.util.Scanner;

public class ConversorMinutos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese los minutos: ");
        int minutos = sc.nextInt();

        int segundosTotales = minutos * 60;
        int horas    = minutos / 60;
        int minResto = minutos % 60;
        int segResto = segundosTotales % 60;

        System.out.println(horas);
        System.out.println(minResto);
        System.out.println(segResto);
        System.out.println(segundosTotales);

        sc.close();
    }
}
