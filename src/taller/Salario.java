package taller;

import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese las horas: ");
        double horas = sc.nextDouble();

        System.out.print("Ingrese el valor por hora: ");
        double valorHora = sc.nextDouble();

        double salarioBruto = horas * valorHora;
        double descuentoSS  = salarioBruto * 0.08;
        double retencion    = salarioBruto * 0.05;
        double salarioNeto  = salarioBruto - descuentoSS - retencion;

        System.out.println(nombre);
        System.out.println(salarioBruto);
        System.out.println(descuentoSS);
        System.out.println(retencion);
        System.out.println(salarioNeto);

        sc.close();
    }
}