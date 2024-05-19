/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles aquàtics
 */
public class Aquatic extends Vehicle {
    
    // Atribut
    private final double eslora;
       
    // Constructor
    public Aquatic (String matricula, String model, double eslora) {
        super(matricula, model);
        
        if(matricula.matches("[a-zA-Z]{3,10}")) {
            this.eslora = eslora;
        } else {
            this.eslora = 0;
            System.out.println("ERROR: Matrícula no vàlida");
        }        
    }
    
    // Getters
    public double getEslora() {
        return eslora;
    }
    
    // Sobreescritura del mètode abstracte 
    @Override
    public void imprimir() {
        System.out.println("Vehícle aquàtic --> Matrícula: " + this.getMatricula() + " - Model: " + this.getModel() + " - Eslora: " + this.getEslora());        
    }    
    
    
}
