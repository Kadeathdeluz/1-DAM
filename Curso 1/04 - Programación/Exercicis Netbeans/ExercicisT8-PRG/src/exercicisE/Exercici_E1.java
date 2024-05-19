package exercicisE;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_E1 {
    public static void main(String[] args) {
        Punt punt1, punt2, punt3;
        //i es un contador per a aumentar la llegibilitat dels prints
        int i = 1;
        
        System.out.println("PUNT " + i++);
        punt1 = new Punt(5,5);
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++);
        punt2 = new Punt(10,10);
        punt2.imprimirPunt();
        
        System.out.println("PUNT ALEATORI (3)");
        punt3 = Punt.creaPuntAleatori();
        punt3.imprimirPunt();
        
        //Es torna a posar a 1
        i = 1; 
        
        System.out.println("PUNT " + i + " modificat.");
        punt1.setX(1);
        punt1.setY(1);
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt1.desplaça(1, 1);
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt2.desplaça(-2, -2);
        punt2.imprimirPunt();

        System.out.println("\nDISTANCIA entre P3 y P2: " + punt3.distancia(punt2) + " unitat(s).\n");
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt3.setXY(3, 3);
        punt3.imprimirPunt();
        
        System.out.println("\nDISTANCIA entre P3 y P2: " + punt3.distancia(punt2) + " unitat(s).\n");
        
    }
    
    
}

class Punt {
    private int x, y;
    
    Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getX() {
        return this.x;
    }
    
    boolean setX(int x){
        this.x = x;
        return true;
    }
    
    int getY() {
        return this.y;
    }
    
    boolean setY(int y){
        this.y = y;
        return true;
    }
    
    boolean setXY(int x, int y) {
        this.x = x;
        this.y = y;
        
        return true;
    }
    
    
    void desplaça(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    int distancia(Punt b) {
        int xB = b.getX(), yB = b.getY();
        
        return (int) Math.sqrt( Math.pow(xB - this.x, 2) + Math.pow(yB - this.y, 2) );
    }
    
    @Override public String toString() {
        return "Coordenada X: " + getX() + "\nCoordenada Y: " + getY() + "";
    }
    
    public void imprimirPunt() {
        System.out.println("======== PUNT (" + getX() + "," + getY() + ") ========\n" + 
                toString());
    }
    
    public static Punt creaPuntAleatori() {
        final int MAX = 100, MIN = -100;
        Punt punt;
        int x, y;
        
        x = (int) (Math.random() * (MAX-MIN) + MIN);
        y = (int) (Math.random() * (MAX-MIN) + MIN);
        
        punt = new Punt(x,y);
        
        return punt;
    }
}
