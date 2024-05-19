/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici07;

/**
 * UF09 Exercici 7: Classe rectangle
 */
public class Rectangle implements iFigura2D {
    
    // Atributs
    private double ample;
    private double alt;
    
    // Constructor
    public Rectangle(double ample, double alt) {
        this.ample = ample;
        this.alt = alt;        
    }
    
    // Getters y setters
    public double getAmple() {
        return ample;
    }
    
    public void setAmple(double ample) {
        this.ample = ample;
    }
    
    public double getAlt() {
        return alt;
    }
    
    public void setAlt(double alt) {
        this.alt = alt;
    }
    
    // Implementantació dels mètodes de la interficie
    public double perimetre() {
        return (ample + alt) * 2;
    }
    
    public double area() {
        return ample * alt;
    }
    
    public void escalar(double escala) {
        if(escala > 0) {
            ample *= escala;
            alt *= escala;
        } else {
            System.out.println("ERROR: L'escala ha de ser major de cero.");
        }
    }
    
    public void imprimir() {
        System.out.println("RECTANGLE --> Ample: " + this.getAmple() + " Alt: " + this.getAlt() + " Perímetre: " + this.perimetre() + " Àrea: " + this.area());
    }   
}
