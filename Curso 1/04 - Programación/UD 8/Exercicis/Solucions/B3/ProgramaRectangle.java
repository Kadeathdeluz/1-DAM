/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_B3;

/**
 * UF08 Exercici B3: Programa amb una classe anomenada Rectangle que representarà un rectangle mitjançant
 * dues coordenades (x1,y1) i (x2,y2) en un pla.
 */
public class ProgramaRectangle {

   public static void main(String[] args) {

        Rectangle rec1 = new Rectangle(0, 0, 5, 5);
        Rectangle rec2 = new Rectangle(7, 9, 2, 3);

        System.out.println("Coordenades del rectangle 1 (" + rec1.x1 + "," + rec1.y1 + ") i (" + rec1.x2 + "," + rec1.y2 + ")");
        System.out.println("Coordenades del rectangle 2 (" + rec2.x1 + "," + rec2.y1 + ") i (" + rec2.x2 + "," + rec2.y2 + ")");
        System.out.println("El perímetre del rectangle 1 és: " + perimetre(rec1));
        System.out.println("El perímetre del rectangle 2 és: " + perimetre(rec2));
        System.out.println("L'àrea del rectangle 1 és: " + area(rec1));
        System.out.println("L'àrea del rectangle 2 és: " + area(rec2));
        System.out.println("");

    }

    public static double perimetre(Rectangle rect) {
        int costat1 = Math.abs(rect.x1 - rect.x2);
        int costat2 = Math.abs(rect.y1 - rect.y2);

        return (costat1 + costat2) * 2;
    }

    public static double area(Rectangle rect) {
        int costat1 = Math.abs(rect.x1 - rect.x2);
        int costat2 = Math.abs(rect.y1 - rect.y2);

        return costat1 * costat2;
    }
    
}
