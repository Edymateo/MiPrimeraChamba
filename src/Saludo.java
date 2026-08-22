import java.util.Scanner;

public class Saludo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Como te llamas?: " );
        String nombre = sc.nextLine();

        System.out.print("Escribe tu edad: ");
        int edad = sc.nextInt();

        System.out.println("Hola " + nombre + " tu edad es " + edad + " años" );

        sc.close();
    }


    
}