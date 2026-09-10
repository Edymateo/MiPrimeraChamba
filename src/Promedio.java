import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nota1: " );
        double nota1 = sc.nextDouble();

        System.out.print("Nota2: ");
        double nota2 = sc.nextDouble();
        
        System.out.print("Nota3: ");
        double nota3 = sc.nextDouble();

        double promedio = (nota1 + nota2 + nota3) / 3;

        System.out.println(promedio);

        double nota = promedio;
        
        if (nota >= 90) {
            System.out.println("Excelente");
        } else if (nota >= 70) {
            System.out.println("Bueno");
        } else if (nota >= 60) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }

        sc.close();
}
}

