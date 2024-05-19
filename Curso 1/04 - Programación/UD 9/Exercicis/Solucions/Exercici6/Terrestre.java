/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles terrestres.
 */
public class Terrestre extends Vehicle {
    
    // Atribut
    private final int numeroRodes;
    
    // Constructor
    public Terrestre (String matricula, String model, int numeroRodes) {                
        super(matricula, model);
        
        if(matricula.matches("[0-9]{4}[a-zA-Z]{3}")) {
           this.numeroRodes = numeroRodes;  
        } else {
            this.numeroRodes = 0;
            System.out.println("ERROR: Matrícula no vàlida");
        }     
    }
    
    // Getters
    public int getNumeroRodes() {
        return this.numeroRodes;
    }  
    
    // Sobreescritura del mètode abstracte
    @Override
    public void imprimir() {
        System.out.println("Vehícle terrestre --> Matrícula: " + this.getMatricula() + " - Model: " + this.getModel() + " - N. rodes: " + this.getNumeroRodes());
    }   
    
}
