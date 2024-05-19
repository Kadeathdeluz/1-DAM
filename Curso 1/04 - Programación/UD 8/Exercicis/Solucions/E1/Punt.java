/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_E1;
import static java.lang.Math.sqrt;
import java.util.Random;
/**
 * UF08 Exercici E1: Classe Punt
 */
public class Punt {
    
    
    private int x;
    private int y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Mostra las coordenades
    public void mostra() {
        System.out.println("(" + this.x + "," + this.y + ")");
    }

    // Setter de les coordenades
    public void setXY(int a, int b) {
        this.x = a;
        this.y = b;
    }

    // Desplaça les coordenades
    public void desplaçaXY(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Calcula la distància euclídea entre dos punts (aplica pitagoras hipotenusa2 = c2 + c2)
    public double distancia(Punt p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
    
    // Crea un punt aleatori 
    public static Punt creaPuntAleatori() {
        Random r = new Random();
        Punt p = new Punt(-100 + r.nextInt(200), -100 + r.nextInt(200));
        return p;
    }
    
}
