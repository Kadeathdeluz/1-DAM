/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_C1;

/**
 * UF08 Exercici C1: Programa amb una classe anomenada Punt que representarà un punt de dues dimensions
 * en un pla.
 */
public class ProgramaPunt {
    
    public static void main(String[] args) {
    
        //Instanciamos los tres objetos Punto
        Punt p1 = new Punt(5, 0);
        Punt p2 = new Punt(10, 10);
        Punt p3 = new Punt(-3, 7);

        //Mostrem les coordenades dels tres punts     
        System.out.println("Coordenades del punt p1 (" + p1.getX() + "," + p1.getY() + ")");
        System.out.println("Coordenades del punt p2 (" + p2.getX() + "," + p2.getY() + ")");
        System.out.println("Coordenades del punt p3 (" + p3.getX() + "," + p3.getY() + ")");
        System.out.println();

        //Modifiquem les coordenades dels tres punts
        p1.setX(p1.getX() + 3);
        p1.setY(6);

        p2.setX(p2.getX() / 2);
        p2.setY(p2.getY() * 2);

        p3.setX(p3.getX() - 5);
        p3.setY(p3.getY() % 2);

        //Mostrem les coordenades dels tres punts               
        System.out.println("Noves coordenades del punt p1 (" + p1.getX() + "," + p1.getY() + ")");
        System.out.println("Noves coordenades del punt p2 (" + p2.getX() + "," + p2.getY() + ")");
        System.out.println("Noves coordenades del punt p3 (" + p3.getX() + "," + p3.getY() + ")");
        System.out.println();
    }
}
