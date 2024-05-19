package exercicisE;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_E3 {

    public static void main(String[] args) {
        Rectangle r1, r2;

        System.out.println("--------------- Rectangle 1 -----------------");
        r1 = new Rectangle(0, 0, 5, 5);
        r1.imprimirDadesRectangle();

        System.out.println("--------------- Rectangle 2 -----------------");
        r2 = new Rectangle(2, 3, 7, 9);
        r2.imprimirDadesRectangle();

        System.out.println("--------------- Rectangle 1 (modificat V.1) -----------------");
        r1.setAll(5,5,0,0);
        r1.imprimirDadesRectangle();
        
        System.out.println("--------------- Rectangle 1 (modificat V.2) -----------------");
        r1.setAll(1,1,4,4);
        r1.imprimirDadesRectangle();

        System.out.println("--------------- Rectangle 2 (modificat) -----------------");
        System.out.println("DE UN EN UN");
        r2.setX1(8);
        r2.setY1(10);
        r2.setX2(7);
        r2.setY2(9);
        System.out.println("DE DOS EN DOS");
        r2.setX1Y1(7, 7);
        r2.setX2Y2(8, 10);
        System.out.println("ELS CUATRE");
        r2.setAll(1, 2, 6, 8);
        r2.imprimirDadesRectangle();
    }
}

class Rectangle {

    private static final int MIN = 0, MAX = 100;
    private int x1, y1, x2, y2;

    Rectangle(int x1, int y1, int x2, int y2) {
      if(validaCoordenades(x1,y1,x2,y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
      }
        if (x1 < x2 && y1 < y2) {
        } else {
            System.err.println("THREAD: (" + Thread.currentThread().toString() + ") ERROR al instanciar rectangle! (" + this.x1 + "," + this.y1 + "),(" + this.x2 + "," + this.y2 + ")");
        }
    }
    
    public boolean entreMinYMax(int coordenada) {
        return coordenada <= MAX && coordenada >= MIN;
    }

    private boolean validaCoordenades(int x1, int y1, int x2, int y2) {
        return entreMinYMax(x1) && entreMinYMax(y1) && entreMinYMax(x2) && entreMinYMax(y2);
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        if (x1 < this.x2 && entreMinYMax(x1)) {
            this.x1 = x1;
        } else {
            System.err.println("THREAD: (" + Thread.currentThread().toString() + ") NO es pot guardar el valor " + x1 + " per a X1");
        }
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        if (y1 < this.y2 && entreMinYMax(y1)) {
            this.y1 = y1;
        } else {
            System.err.println("THREAD: (" + Thread.currentThread().toString() + ") NO es pot guardar el valor " + y1 + " per a Y1");
        }
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        if (x2 > this.x1 && entreMinYMax(x2)) {
            this.x2 = x2;
        } else {
            System.err.println("THREAD: (" + Thread.currentThread().toString() + ") NO es pot guardar el valor " + x2 + " per a X2");
        }
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        if (y2 > y1 && entreMinYMax(y2)) {
            this.y2 = y2;
        }
        else {
            System.err.println("THREAD: (" + Thread.currentThread().toString() + ") NO es pot guardar el valor " + y2 + " per a Y2");
        }
    }
    
    public void setX1Y1(int x1, int y1) {
            setX1(x1);
            setY1(y1);
    }

    public void setX2Y2(int x2, int y2) {
        setX2(x2);
        setY2(y2);
    }

    public void setAll(int x1, int y1, int x2, int y2) {
        if (x1 < x2 && y1 < y2 && validaCoordenades(x1, y1, x2, y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        } else {
            System.err.println("THREAD: (" + Thread.currentThread().toString() + ") NO es poden guardar els valors (" + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
        }
    }

    public int calculaPerimetre() {
        int costatX, costatY;

        //El costatX (l'ample) és la diferencia entre les coordenades x1 i x2 en valor absolut (sense signe)
        costatX = Math.abs( getX1() - getX2() );

        //El costatY (l'alt) és la diferencia entre les coordenades y1 i y2 en valor absolut (sense signe)
        costatY = Math.abs( getY1() - getY2() );

        return (costatX * 2 + costatY * 2);
    }

    public int calculaArea() {
        int costatX, costatY;

        //El costatX (l'ample) és la diferencia entre les coordenades x1 i x2 en valor absolut (sense signe)
        costatX = Math.abs( getX1() - getX2() );

        //El costatY (l'alt) és la diferencia entre les coordenades y1 i y2 en valor absolut (sense signe)
        costatY = Math.abs( getY1() - getY2() );

        return costatX * costatY;
    }

    public String mostraCoordenades() {
        return "(X1,Y1) = (" + getX1() + "," + getY1() + ")\n" + "(X2,Y2) = (" + getX2() + "," + getY2() + ")";
    }

    public void imprimirDadesRectangle() {
        System.out.println(mostraCoordenades()
                + "\nPerímetre = " + calculaPerimetre()
                + "\nÀrea = " + calculaArea());
    }

}
