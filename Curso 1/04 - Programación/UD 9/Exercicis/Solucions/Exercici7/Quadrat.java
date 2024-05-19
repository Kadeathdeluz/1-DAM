/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici07;

/**
 * UF09 Exercici 7: Classe quadrat
 */
public class Quadrat implements iFigura2D {
    
    // Atributs
    private double costat;
    
    // Constructor
    public Quadrat(double costat) {
        this.costat = costat;
    }
    
    // Getters y setters    
    public double getCostat() {
        return costat;
    }

    public void setCostat(double costat) {
        this.costat = costat;
    }
    
    // Implementantació dels mètodes de la interficie
    public double perimetre() {
        return costat * 4;
    }
    
    public double area() {
        return Math.pow(costat, 2);
    }
    
    public void escalar(double escala) {
        if(escala > 0) {
            costat *= escala;
        } else {
            System.out.println("ERROR: L'escala ha de ser major de cero.");
        }
    }
    
    public void imprimir() {
        System.out.println("QUADRAT ----> Costat: " + this.getCostat() + " Perímetre: " + this.perimetre() + " Àrea: " + this.area());
    }
}
