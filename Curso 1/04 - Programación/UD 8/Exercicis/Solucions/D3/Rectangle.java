/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_D3;
import static java.lang.Math.abs;
/**
 * UF08 Exercici D3: Classe Rectangle. Es valida que x1<x2 i que y1<y2.
 */
public class Rectangle {
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        // Comprobem si és un rectangle vàlid
        if ((x1 < x2) && (y1 < y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;

        } else {
            System.err.println("ERROR al instanciar el Rectangle (" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")");
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX1(int x1) {
        if (x1 > this.x2) {
            System.err.println("ERROR el valor de x1 no pot ser major que el valor de x2");
        } else {
            this.x1 = x1;
        }
    }

    public void setY1(int y1) {
        if (y1 > this.y2) {
            System.err.println("ERROR el valor de y1 no pot ser major que el valor de y2");
        } else {
            this.y1 = y1;
        }
    }

    public void setX2(int x2) {
        if (x2 < this.x1) {
            System.err.println("ERROR el valor de x2 no pot ser menor que el valor de x1");
        } else {
            this.x2 = x2;
        }
    }

    public void setY2(int y2) {
        if (y2 < this.y1) {
            System.err.println("ERROR el valor de y2 no pot ser menor que el valor de y1");
        } else {
            this.y2 = y2;
        }
    }

    // Setter X1Y1
    public void setX1Y1(int x1, int y1) {
        this.setX1(x1);
        this.setY1(y1);
    }

    // Setter X2Y2
    public void setX2Y2(int x2, int y2) {
        this.setX2(x2);
        this.setY2(y2);
    }

    // Setter X1Y1 X2Y2 (tots)
    public void setAll(int x1, int y1, int x2, int y2) {
        this.setX1(x1);
        this.setY1(y1);
        this.setX2(x2);
        this.setY2(y2);
    }

    // Obtindre el perímetre
    public int getPerimetre() {;
        return abs(this.x1 - this.x2) * 2 + abs(this.y1 - this.y2) * 2;
    }

    // Obtindre l'àrea
    public int getArea() {
        return abs(this.x1 - this.x2) * abs(this.y1 - this.y2);
    }

    // Mostrar informació rectangle
    public void mostra() {
        System.out.println("Coordenades: (" + this.x1 + "," + this.y1 + ")-(" + this.x2 + "," + this.y2 + ")");
        System.out.println("Perímetre: " + this.getPerimetre());
        System.out.println("Àrea: " + this.getArea());
    }
    
}
