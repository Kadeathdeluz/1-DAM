package exercicisC;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_C3 {

    public static void main(String[] args) {
        Rectangle r1, r2;
        int costatX, costatY;

        System.out.println("--------------- Rectangle 1 -----------------");
        r1 = new Rectangle(0, 0, 5, 5);
        costatX = Math.abs(r1.getX1() - r1.getX2());
        costatY = Math.abs(r1.getY1() - r1.getY2());
        System.out.println("Perímetre de R1: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R1: " + (costatX * costatY));

        System.out.println("--------------- Rectangle 2 -----------------");
        r2 = new Rectangle(7, 9, 2, 3);
        costatX = Math.abs(r2.getX1() - r2.getX2());
        costatY = Math.abs(r2.getY1() - r2.getY2());
        System.out.println("Perímetre de R2: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R2: " + (costatX * costatY));


        System.out.println("--------------- Rectangle 1 (modificat) -----------------");
        r1.setX1(5);
        r1.setY1(5);
        r1.setX2(0);
        r1.setY2(0);
        costatX = Math.abs(r1.getX1() - r1.getX2());
        costatY = Math.abs(r1.getY1() - r1.getY2());
        System.out.println("Perímetre de R1: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R1: " + (costatX * costatY));

        System.out.println("--------------- Rectangle 2 (modificat) -----------------");
        r2.setX1(2);
        r2.setY1(3);
        r2.setX2(7);
        r2.setY2(9);
        costatX = Math.abs(r2.getX1() - r2.getX2());
        costatY = Math.abs(r2.getY1() - r2.getY2());
        System.out.println("Perímetre de R2: " + (costatX * 2 + costatY * 2));
        System.out.println("Àrea de R2: " + (costatX * costatY));

    }
}

class Rectangle {

    private int x1, y1, x2, y2;

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

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        if (x1 < this.x2) {
            this.x1 = x1;
        } else {
            System.err.println("NO es pot guardar el valor " + x1 + " per a X1");
        }
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        if (y1 < this.y2) {
            this.y1 = y1;
        } else {
            System.err.println("NO es pot guardar el valor " + y1 + " per a Y1");
        }
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        if (x2 > this.x1) {
            this.x2 = x2;
        } else {
            System.err.println("NO es pot guardar el valor " + x2 + " per a X2");
        }
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        if (y2 > y1) {
            this.y2 = y2;
        }
        else {
            System.err.println("NO es pot guardar el valor " + y2 + " per a Y2");
        }
    }

}
