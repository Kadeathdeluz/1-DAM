package exercicisC;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_C1 {
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
        
        System.out.println("PUNT " + i++);
        punt3 = new Punt(-3,7);
        punt3.imprimirPunt();
        
        //Es torna a posar a 1
        i = 1; 
        
        System.out.println("PUNT " + i + " modificat.");
        punt1.setX(1);
        punt1.setY(1);
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt1.setX(punt1.getX() + 1);
        punt1.setY(punt1.getY() + 1);
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt2.setX(punt2.getX() - 2);
        punt2.setY(punt2.getY() - 2);
        punt2.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt3.setX(punt3.getX() * 3);
        punt3.setY(punt3.getY() * 3);
        punt3.imprimirPunt();
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
    
    @Override public String toString() {
        return "Coordenada X: " + getX() + "\nCoordenada Y: " + getY() + "";
    }
    
    public void imprimirPunt() {
        System.out.println("======== PUNT (" + getX() + "," + getY() + ") ========\n" + 
                toString());
    }
}