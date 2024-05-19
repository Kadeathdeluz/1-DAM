/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles aeris tipus helicòpter
 */
public class Helicopter extends Aeri {
    
    // Atribut
    private int numeroHelixs;
    
    // Constructor
    public Helicopter (String matricula, String model, int numeroSeients, int numeroHelixs) {
        super(matricula, model, numeroSeients);
        this.numeroHelixs = numeroHelixs;
    }
    
    // Getters y setters
    public int getNumeroHelixs() {
        return this.numeroHelixs;
    }
    
    public void setNumeroHelixs(int numeroHelixs) {
        this.numeroHelixs = numeroHelixs;
    }
    
    // Sobrescritura del mètode imprimir
    @Override
    public void imprimir() {
        super.imprimir();
        
        System.out.println("Helicòpter té " + this.getNumeroHelixs() + " hèlixs");
    }
}
