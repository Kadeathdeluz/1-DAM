/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_B3;

/**
 * UF08 Exercici B3: Classe Rectangle. Es valida que x1<x2 i que y1<y2.
 */
public class Rectangle {
    
        int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        // Comprovem si és un rectangle vàlid
        if ((x1 < x2) && (y1 < y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            
        } else {
            System.err.println("ERROR al instanciar el Rectangle (" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")");
        }
    }
    
}
