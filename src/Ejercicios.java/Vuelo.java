public class Vuelo {
    private String numero;
    private String origen;
    private String destino;
    private int ocupacion;
    private int capacidadMaxima;

    public Vuelo() {
    }

    public Vuelo(String numero, String origen, String destino) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        ocupacion = 0;
    }

    public Vuelo(String numero, String origen, String destino, int ocupacion, int capacidadMaxima) {
    this.numero = numero;
    this.origen = origen;
    this.destino = destino;
    this.ocupacion = ocupacion;
    this.capacidadMaxima = capacidadMaxima;
}

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setOcupacion(int ocupacion) {
        if (ocupacion < 0 || ocupacion > capacidadMaxima) {
            System.out.println("ocupación invalida");
        } else {
            this.ocupacion = ocupacion;
        }
    }

    public void mostrarInfo() {
        System.out.println("Vuelo: " + numero);
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        System.out.println("Ocupación: " + ocupacion + "/" + capacidadMaxima);
    }

    public void embarcar(int pasajeros) {
        if ((ocupacion + pasajeros) > capacidadMaxima) {
            System.out.println("No hay suficiente espacio para embarcar " + pasajeros + " pasajeros");
        } else {
            ocupacion = ocupacion + pasajeros;
            System.out.println(pasajeros + " pasajeros embarcados");
        }
    }

    public void desembarcar(int pasajeros) {
        if ((ocupacion - pasajeros) < 0) {
            ocupacion = 0;
            System.out.println("No se puede desembarcar esa cantidad");
        } else {
            ocupacion = ocupacion - pasajeros;
            System.out.println(pasajeros + " pasajeros desembarcados");
        }
    }
}