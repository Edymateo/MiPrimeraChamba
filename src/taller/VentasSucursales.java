package taller;

// VentasSucursales
import java.util.Scanner;

class VentasSucursales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] ventas = new double[4][3];

        for (int sucursal = 0; sucursal <= 3; sucursal++) {
            for (int producto = 0; producto <= 2; producto++) {
                System.out.print("Ventas sucursal " + sucursal + ", producto " + producto + ": ");
                ventas[sucursal][producto] = Double.parseDouble(sc.nextLine().trim());
            }
        }

        for (int sucursal = 0; sucursal <= 3; sucursal++) {
            double totalSucursal = 0;
            for (int producto = 0; producto <= 2; producto++) {
                totalSucursal = totalSucursal + ventas[sucursal][producto];
            }
            System.out.println("Sucursal " + sucursal + ": " + totalSucursal);
        }

        for (int producto = 0; producto <= 2; producto++) {
            double totalProducto = 0;
            for (int sucursal = 0; sucursal <= 3; sucursal++) {
                totalProducto = totalProducto + ventas[sucursal][producto];
            }
            System.out.println("Producto " + producto + ": " + totalProducto);
        }

        double maxVenta = ventas[0][0];
        int sucMax = 0, prodMax = 0;
        for (int sucursal = 0; sucursal <= 3; sucursal++) {
            for (int producto = 0; producto <= 2; producto++) {
                if (ventas[sucursal][producto] > maxVenta) {
                    maxVenta = ventas[sucursal][producto];
                    sucMax = sucursal;
                    prodMax = producto;
                }
            }
        }

        System.out.println(maxVenta + " " + sucMax + " " + prodMax);
    }
}
