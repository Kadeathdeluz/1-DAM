package exercicisB;

/**
 * @author Roldán Sanchis Martínez
 */
public class Exercici_B1 {
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
        punt1.x = 1;
        punt1.y = 1;
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt1.x += 1;
        punt1.y += 1;
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt2.x -= 2;
        punt2.y -= 2;
        punt2.imprimirPunt();
        
        System.out.println("PUNT " + i++ + " modificat.");
        punt3.x *= 3;
        punt3.y *= 3;
        punt3.imprimirPunt();
    }
}

class Punt {
    int x, y;
    
    Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override public String toString() {
        return "Coordenada X: " + x + "\nCoordenada Y: " + y + "";
    }
    
    public void imprimirPunt() {
        System.out.println("======== PUNT (" + x + "," + y + ") ========\n" + 
                toString());
    }
}
