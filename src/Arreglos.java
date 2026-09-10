public class Arreglos {
    public static void main(String[] args) {
        
    int [] notas = new int[5];
    
    notas[0] = 85;
    notas[1] = 85;
    notas[2] = 85;
    notas[3] = 85;
    notas[4] = 85;

    int [] edades = {18, 20, 22, 19, 21};

    System.out.println(notas[0]);

    for (int i = 0; i < edades.length; i++){
        System.out.println("Nota " + (i+1) + ":" + notas[i]);
    }
    for (int nota: notas){
        System.out.println(nota);
    }
    
}
}
