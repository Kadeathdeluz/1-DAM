/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6:  Subclasse per a vehicles terrestres tipus cotxe
 */
public class Cotxe extends Terrestre {
    
    // Atribut
    private boolean teAC;
    
    // Constructor
    public Cotxe (String matricula, String model, int numeroRodes, boolean teAC) {
        super(matricula, model, numeroRodes);
        this.teAC = teAC;
    }
    
    // Getters y setters
    public boolean getTeAC() {
        return this.teAC;
    }
    
    public void setTeAC(boolean teAC) {
        this.teAC = teAC;
    }
    
    // Sobrescritura del mètode imprimir
    @Override
    public void imprimir() {
        super.imprimir();
        
        if(this.teAC) {
            System.out.println("Cotxe amb aire condicionat");
        } else {
            System.out.println("Cotxe sense aire condicionat");
        }       
    }     
    
}
