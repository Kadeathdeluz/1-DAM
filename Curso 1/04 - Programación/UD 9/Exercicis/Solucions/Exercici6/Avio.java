/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles aeris tipus avió
 */
public class Avio extends Aeri {
    
    // Atribut
    private double tempsMaxVol;
    
    // Constructor
    public Avio (String matricula, String model, int numeroSeients, double tempsMaxVol) {
        super(matricula, model, numeroSeients);
        this.tempsMaxVol = tempsMaxVol;
    }
    
    // Getters y setters
    public double getTempsMaxVol() {
        return this.tempsMaxVol;
    }
    
    public void setTempsMaxVol(double tempsMaxVol) {
        this.tempsMaxVol = tempsMaxVol;
    }
    
    // Sobrescritura del mètode imprimir
    @Override
    public void imprimir() {
        super.imprimir();
        
        System.out.println("Avió té un temps màxim de vol de: " + this.getTempsMaxVol());
    }    
}
