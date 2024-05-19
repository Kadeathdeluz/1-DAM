/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_E1;

/**
 * UF08 Exercici E1: Programa amb una classe anomenada Punt que representarà un punt de dues dimensions
 * en un pla.
 */
public class ProgramaPunt {
    
    public static void main(String[] args) {

        // Instanciem els tres objectes Punt
        Punt p1 = new Punt(5, 0);
        Punt p2 = new Punt(10, 10);
        Punt p3 = new Punt(-3, 7);

        // Mostrem les coordenades dels tres punts      
        p1.mostra();
        p2.mostra();
        p3.mostra();
        System.out.println();

        // Modifiquem les coordenades dels tres punts
        p1.setX(p1.getX() + 3);
        p1.setY(6);
        p2.setX(p2.getX() / 2);
        p2.setY(p2.getY() * 2);
        p3.setX(p3.getX() - 5);
        p3.setY(p3.getY() % 2);

        // Mostrem les coordenades dels tres punts           
        p1.mostra();
        p2.mostra();
        p3.mostra();
        System.out.println();
        
        // Mostrem distància entre punts
        System.out.println("La distància entre P1 i P2 és " + p1.distancia(p2));
        System.out.println("La distància entre P2 i P3 és " + p2.distancia(p3));
        System.out.println("La distància entre P3 i P1 és " + p3.distancia(p1));
        System.out.println();
        
        // Desplacem p1 y p2. Els mostrem
        p1.desplaçaXY(-1, -1);
        System.out.print("P1 tras desplaçar-lo -1,-1: ");
        p1.mostra();
        p2.desplaçaXY(10, 10);
        System.out.print("P2 tras desplaçar-lo 10,10: ");
        p2.mostra();
        System.out.println();
        
        // Creem 20 punts aleatoris i els mostrem
        Punt punts[] = new Punt[20];
        for (int i = 0; i < 20; i++) {
            punts[i] = Punt.creaPuntAleatori();
            System.out.print("Punt aleatori " + i + ": ");
            punts[i].mostra();
        }

    }    
    
}
