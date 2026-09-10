package taller;

import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double celsius, fahrenheit, kelvin;

        System.out.print("Ingrese la temperatura en Celsius: ");
        celsius = sc.nextDouble();

        fahrenheit = (celsius * 9 / 5) + 32;
        kelvin = celsius + 273.15;

        System.out.printf("%.2f%n", celsius);
        System.out.printf("%.2f%n", fahrenheit);
        System.out.printf("%.2f%n", kelvin);

        sc.close();
    }
}