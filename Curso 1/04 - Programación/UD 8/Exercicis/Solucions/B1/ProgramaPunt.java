/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_B1;

/**
 * UF08 Exercici B1: Programa amb una classe anomenada Punt que representarà un punt de dues dimensions
 * en un pla.
 */
public class ProgramaPunt {
    
        public static void main(String[] args) {

        // Instanciem els tres objectes Punt (ara estem obligats a posar paràmetres al fer new Punt)
        Punt p1 = new Punt(5, 0);
        Punt p2 = new Punt(10, 10);
        Punt p3 = new Punt(-3, 7);

        //Mostrem les coordenades dels tres punts   
        System.out.println("Coordenades del punt p1 (" + p1.x + "," + p1.y + ")");
        System.out.println("Coordenades del punt p2 (" + p2.x + "," + p2.y + ")");
        System.out.println("Coordenades del punt p3 (" + p3.x + "," + p3.y + ")");
        System.out.println();

        //Modifiquem les coordenades dels tres punts
        p1.x += 3;
        p1.y = 6;

        p2.x /= 2;
        p2.y *= 2;

        p3.x -= 5;
        p3.y %= 2;

        //Mostrem les coordenades dels tres punts                
        System.out.println("Noves coordenades del punt p1 (" + p1.x + "," + p1.y + ")");
        System.out.println("Noves coordenades del punt p2 (" + p2.x + "," + p2.y + ")");
        System.out.println("Noves coordenades del punt p3 (" + p3.x + "," + p3.y + ")");
        System.out.println();
    }
    
}
