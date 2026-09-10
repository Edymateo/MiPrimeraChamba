import java.util.Scanner;

public class CiclosAnidados {
    public static void main(String[] args) {
    /*for (int fila = 1; fila <= 4; fila++){
        for(int col = 1; col <=4; col++){
            System.out.print("* ");
        }
    }
    //brak 
    for (int i = 1; i <= 10 ; i++){
        if(i == 5) break;
        System.out.println(i);
    }
    //continue
    for (int i = 1; i <= 10; i++){
        if(i % 2 == 0) continue;
        System.out.println(i);
    }
    
    int contador = 1;

    while( contador <= 5){
        System.out.println("Vuelta numero " + contador);
        contador++;
    }*/
    
    Scanner sc = new Scanner(System.in);
    

    /*while( edad < 0 || edad > 120){
        System.out.println("Ingresa tu edad entre 0 a 120:  " );
        edad = sc.nextInt();
        if (edad < 0 || edad > 120){
            System.out.println("Edad invalida, intentaro de nuevo.");
        }*/
    

    int opcion = -1;
    do {
        System.out.println("----- MENU-----  " );
        System.out.println("1. SALUDAR  " );
        System.out.println("2. COMO ESTAS ");
        System.out.println("3.DESPEDIR ");
        System.out.println("0. SALIR ");
        opcion = sc.nextInt();
        
        if (opcion == 1) {
            System.out.println("¡Hola¡ ");
            break;
        } else if (opcion == 2) {
            System.out.println("!Bien y tu?! ");
            break;
        } else if (opcion == 3) {
            System.out.println("!Adios¡ ");
            break; 
        } 
    } while (opcion != 0);
    System.out.println("Saliendo ");
    
}
}

