/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles aquàtics tipus submarí
 */
public class Submari extends Aquatic {
    
    // Atributs
    private double profunditatMax;
    
    // Constructor
    public Submari(String matricula, String model, double eslora, double profunditatMax) {
        super(matricula, model, eslora);       
        this.profunditatMax = profunditatMax;       
    }
    
    // Getters y setters
    public double getProfunditatMax() {
        return profunditatMax;
    }
    
    public void setProfunditatMax(double profunditatMax) {
        this.profunditatMax = profunditatMax;
    }    
    
    // Sobrescritura del mètode imprimir
    @Override
    public void imprimir() {
        super.imprimir();
        
        System.out.println("Submarí té una profunditat màxima de: " + this.getProfunditatMax());
    }    
}
