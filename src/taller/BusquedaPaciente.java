package taller;

// BusquedaPaciente
import java.util.Scanner;

class BusquedaPaciente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pacientes = new String[8];

        for (int i = 0; i <= 7; i++) {
            System.out.print("pacientes[" + i + "]: ");
            pacientes[i] = sc.nextLine();
        }

        System.out.print("Nombre a buscar: ");
        String nombreBuscado = sc.nextLine().trim();

        int posicion = -1;

        for (int i = 0; i <= 7; i++) {
            if (pacientes[i].equalsIgnoreCase(nombreBuscado)) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            System.out.println("Encontrado en posición " + posicion);
        } else {
            System.out.println("No encontrado");
        }
    }
}
