package taller;

// TresEnRaya
import java.util.Scanner;

class TresEnRaya {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }

        int turno = 1;
        boolean hayGanador = false;
        boolean tableroLleno = false;
        char simbolo = ' ';

        while (!hayGanador && !tableroLleno) {
            simbolo = (turno == 1) ? 'X' : 'O';
            mostrarTablero(tablero);
            System.out.println("Turno del jugador " + simbolo);

            int fila = -1, columna = -1;
            boolean celdaValida;
            do {
                int[] entrada = leerFilaColumna();
                fila = entrada[0];
                columna = entrada[1];
                celdaValida = (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2)
                        && (tablero[fila][columna] == ' ');
                if (!celdaValida) {
                    System.out.println("Celda inválida, intenta de nuevo");
                }
            } while (!celdaValida);

            tablero[fila][columna] = simbolo;
            hayGanador = verificarGanador(tablero, simbolo);

            tableroLleno = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == ' ') {
                        tableroLleno = false;
                    }
                }
            }

            if (!hayGanador) {
                turno = (turno == 1) ? 2 : 1;
            }
        }

        mostrarTablero(tablero);
        if (hayGanador) {
            System.out.println("Ganó el jugador " + simbolo);
        } else {
            System.out.println("Empate");
        }
    }

    static boolean verificarGanador(char[][] tablero, char simbolo) {
        for (int f = 0; f < 3; f++) {
            if (tablero[f][0] == simbolo && tablero[f][1] == simbolo && tablero[f][2] == simbolo) {
                return true;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (tablero[0][c] == simbolo && tablero[1][c] == simbolo && tablero[2][c] == simbolo) {
                return true;
            }
        }
        if (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) {
            return true;
        }
        if (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo) {
            return true;
        }
        return false;
    }

    static int[] leerFilaColumna() {
        int fila = -1, columna = -1;
        try {
            System.out.print("Fila (0-2): ");
            fila = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Columna (0-2): ");
            columna = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            fila = -1;
            columna = -1;
        }
        return new int[] { fila, columna };
    }

    static void mostrarTablero(char[][] tablero) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
}