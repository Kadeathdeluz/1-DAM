/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles aeris
 */
public class Aeri extends Vehicle {
    
    // Atribut
    private final int numeroSeients;
    
    // Constructor
    public Aeri (String matricula, String model, int numeroSeients) {
        super(matricula, model);
        
        if(matricula.matches("[a-zA-Z]{4}[0-9]{6}")) {
            this.numeroSeients = numeroSeients;
        } else {
            this.numeroSeients = 0;
            System.out.println("ERROR: Matrícula no vàlida");
        }    
    }
    
    // Getters
    public int getNumeroSeients() {
        return this.numeroSeients;
    }
    
    // Sobreescritura del mètode abstracte      
    @Override
    public void imprimir() {
        System.out.println("Vehícle aeri --> Matrícula: " + this.getMatricula() + " - Model: " + this.getModel() + " - N. seients: " + this.getNumeroSeients());        
    }
    
}
