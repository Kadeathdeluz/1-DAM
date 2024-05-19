/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_E3;

/**
 * UF08 Exercici E3: Programa amb una classe anomenada Rectangle que representarà un rectangle mitjançant
 * dues coordenades (x1,y1) i (x2,y2) en un pla.
 */
public class ProgramaRectangle {
    
        public static void main(String[] args) {

        // Instanciem i mostrem rectangles
        Rectangle rec1 = new Rectangle(0, 0, 5, 5);
        Rectangle rec2 = new Rectangle(7, 9, 2, 3);
        rec1.mostra();
        rec2.mostra();

        // Canviem valors i mostrem
        rec1.setX1(10);
        rec1.setX2(3);
        rec2.setY1(12);
        rec2.setY2(5);
        rec1.mostra();
        rec2.mostra();

        // Canviem valores i mostrem
        rec1.setX1Y1(2, 4);
        rec1.setX2Y2(10, 20);
        rec2.setAll(3, 4, 5, 6);
        rec1.mostra();
        rec2.mostra();
        
        rec2.setAll(300, 400, 500, 600);

        System.out.println("Rectangle aleatori");
        Rectangle rec3 = Rectangle.generarRectangle();
        rec3.mostra();
    }
    
}
