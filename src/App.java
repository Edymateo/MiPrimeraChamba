public class App {
    public static void main(String[] args) throws Exception {

        Punto p1 = new Punto();
        System.out.println(p1.getX());
        System.out.println(p1.getY());

        p1.setX(2);
        p1.setY(3);

        System.out.println(p1.getX());
        System.out.println(p1.getY());
        System.out.println(p1.modulo());

        Punto p2 = new Punto(2, 3);

        System.out.println(p2.getX());
        System.out.println(p2.getY());

        Punto p3 = new Punto(8);

        System.out.println(p3.getX());
        System.out.println(p3.getY());

        Punto p4 = new Punto();

        System.out.println(p4.getX());
        System.out.println(p4.getY());

    }
}
