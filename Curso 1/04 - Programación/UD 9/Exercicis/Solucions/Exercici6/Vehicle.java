/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Superclasse Veihcle no instanciable.
 */
public abstract class Vehicle {
    
    // Atributs    
    private final String matricula;
    private final String model;
    
    // Constructor    
    public Vehicle (String matricula, String model) {
        this.matricula = matricula;
        this.model = model;
    }
    
    // Getters    
    public String getMatricula() {
        return matricula;
    }

    public String getModel() {
        return model;
    }
    
    // Mètode abstracte per imprimir. Ha d'implementarse en totes les subclasses.    
    public abstract void imprimir();    
    
}
