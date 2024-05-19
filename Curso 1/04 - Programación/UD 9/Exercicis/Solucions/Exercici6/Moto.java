/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles terrestres tipus moto
 */
public class Moto extends Terrestre {
    
     // Atribut
    private String color;
    
    // Constructor
    public Moto (String matricula, String model, int numeroRodes, String color) {
        super(matricula, model, numeroRodes);
        this.color = color;
    }
    
    // Getters y setters
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    // Sobrescritura del mètode imprimir
    @Override
    public void imprimir() {
        super.imprimir();
        
        System.out.println("Moto de color " + this.getColor());               
    }    
    
}
