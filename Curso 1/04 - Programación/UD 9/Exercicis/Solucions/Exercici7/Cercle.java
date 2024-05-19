/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici07;

/**
 * UF09 Exercici 7: Classe cercle
 */
public class Cercle implements iFigura2D {
    
    // Atributs
    private double radio;
        
    // Constructor
    public Cercle (double radio) {
        this.radio = radio;               
    }
    
    // Getters y setters
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
            
    // Implementantació dels mètodes de la interficie
    public double perimetre()  {
        return 2 * Math.PI * radio;
    }
    
    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }
    
    public void escalar(double escala) {
        if(escala > 0) {
            radio *= escala;
        } else {
            System.out.println("ERROR: L'escala ha de ser major de cero.");
        }
    }
    
    public void imprimir()     {
        System.out.println("CERCLE -----> Radio: " + this.getRadio() + " Perímetre: " + this.perimetre() + " Àrea: " + this.area());
    }
}
