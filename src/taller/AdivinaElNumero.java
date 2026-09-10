package taller;

// 3.2
import java.util.Scanner;
import java.util.Random;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int secreto = rand.nextInt(100) + 1; // número aleatorio entre 1 y 100
        int intentos = 0;
        int numero;

        do {
            System.out.print("Ingrese su intento: ");
            numero = sc.nextInt();
            intentos = intentos + 1;

            if (numero > secreto) {
                System.out.println("El número es menor");
            } else if (numero < secreto) {
                System.out.println("El número es mayor");
            } else {
                System.out.println("¡Correcto! " + intentos + " intentos");
            }
        } while (numero != secreto);

        sc.close();
    }
}



