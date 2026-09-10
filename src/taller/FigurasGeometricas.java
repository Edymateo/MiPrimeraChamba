package taller;

import java.util.Scanner;

public class FigurasGeometricas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese base y altura del rectángulo: ");
        double base = sc.nextDouble();
        double altura = sc.nextDouble();

        System.out.print("Ingrese el radio del círculo: ");
        double radio = sc.nextDouble();

        double areaRectangulo      = base * altura;
        double perimetroRectangulo = 2 * (base + altura);
        double areaCirculo         = Math.PI * radio * radio;
        double circunferencia      = 2 * Math.PI * radio;

        System.out.println(areaRectangulo);
        System.out.println(perimetroRectangulo);
        System.out.println(areaCirculo);
        System.out.println(circunferencia);

        sc.close();
    }
}