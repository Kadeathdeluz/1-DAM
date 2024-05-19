package exercicisB;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_B3 {

    public static void main(String[] args) {
        Rectangle r1, r2;
        int costatX, costatY;

        System.out.println("--------------- Rectangle 1 -----------------");
        r1 = new Rectangle(0,0,5,5);
        costatX = Math.abs(r1.x1 - r1.x2);
        costatY = Math.abs(r1.y1 - r1.y2);
        System.out.println("Coordenades de R1:"
                + "\n(X1,Y1) = (" + r1.x1 + "," + r1.y1 + ")"
                + "\n(X2,Y2) = (" + r1.x2 + "," + r1.y2 + ")");
        System.out.println("Perímetre de R1: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R1: " + (costatX * costatY));

        System.out.println("--------------- Rectangle 2 -----------------");
        r2 = new Rectangle(7,9,2,3);
        costatX = Math.abs(r2.x1 - r2.x2);
        costatY = Math.abs(r2.y1 - r2.y2);
        System.out.println("Coordenades de R2:"
                + "\n(X1,Y1) = (" + r2.x1 + "," + r2.y1 + ")"
                + "\n(X2,Y2) = ("+ r2.x2 + "," + r2.y2 + ")" );
        System.out.println("Perímetre de R2: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R2: " + (costatX * costatY));

        System.out.println("--------------- Rectangle 1 (modificat) -----------------");
        r1.x1 = 5;
        r1.y1 = 5;
        r1.x2 = 0;
        r1.y2 = 0;
        costatX = Math.abs(r1.x1 - r1.x2);
        costatY = Math.abs(r1.y1 - r1.y2);
        System.out.println("Coordenades de R1:"
                + "\n(X1,Y1) = (" + r1.x1 + "," + r1.y1 + ")"
                + "\n(X2,Y2) = (" + r1.x2 + "," + r1.y2 + ")");
        System.out.println("Perímetre de R1: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R1: " + (costatX * costatY));

        System.out.println("--------------- Rectangle 2 (modificat) -----------------");
        r2.x1 = 2;
        r2.y1 = 3;
        r2.x2 = 7;
        r2.y2 = 9;
        costatX = Math.abs(r2.x1 - r2.x2);
        costatY = Math.abs(r2.y1 - r2.y2);
        System.out.println("Coordenades de R2:"
                + "\n(X1,Y1) = (" + r2.x1 + "," + r2.y1 + ")"
                + "\n(X2,Y2) = ("+ r2.x2 + "," + r2.y2 + ")" );
        System.out.println("Perímetre de R2: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R2: " + (costatX * costatY));

    }
}

class Rectangle {

    int x1, y1, x2, y2;

    Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        //La condició és la contraria a (x1 < x2 && y1 < y2)
        if (x1 >= x2 || y1 >= y2) {
            System.err.println("ERROR al instanciar rectangle!");
        }
    }
}
