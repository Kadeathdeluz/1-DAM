package exercicisA;

/**
 * @author Roldán Sanchis Martínez
 */
public class Exercici_A1 {

    public static void main(String[] args) {
        Punt punt1, punt2, punt3;
        int i = 1;
        
        System.out.println("PUNT " + i++);
        punt1 = new Punt();
        punt1.x = 5;
        punt1.y = 5;
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++);
        punt2 = new Punt();
        punt2.x = 10;
        punt2.y = 10;
        punt2.imprimirPunt();
        
        System.out.println("PUNT " + i++);
        punt3 = new Punt();
        punt3.x = -3;
        punt3.y = 7;
        punt3.imprimirPunt();
        
        i = 1; 
        
        System.out.println("PUNT " + i);
        punt1.x = 1;
        punt1.y = 1;
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++);
        punt1.x+= 1;
        punt1.y += 1;
        punt1.imprimirPunt();
        
        System.out.println("PUNT " + i++);
        punt2.x -= 2;
        punt2.y -= 2;
        punt2.imprimirPunt();
        
        System.out.println("PUNT " + i++);
        punt3.x *= 3;
        punt3.y *= 3;
        punt3.imprimirPunt();
        
        
    }
}

class Punt {
    int x, y;
    
    @Override public String toString() {
        return "Coordenada X: " + x + "\nCoordenada Y: " + y + "";
    }
    
    public void imprimirPunt() {
        System.out.println("======== PUNT (" + x + "," + y + ") ========\n" + 
                toString());
    }
}














