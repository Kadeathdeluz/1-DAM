/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;

/**
 * UF09 Exercici 6: Subclasse per a vehicles aquàtics tipus vaixell
 */
public class Vaixell extends Aquatic {
    
    // Atribut
    private boolean teMotor;
    
    // Constructor
    public Vaixell (String matricula, String model, double eslora, boolean teMotor) {
        super(matricula, model, eslora);
        this.teMotor = teMotor;
    }
    
    // Getters y setters
    public boolean getTeMotor() {
        return this.teMotor;
    }
    
    public void setTeMotor(boolean teMotor){
        this.teMotor = teMotor;
    }    
    
    // Sobrescritura del mètode imprimir
    @Override
    public void imprimir() {
        super.imprimir();
        
        if(this.teMotor) {
            System.out.println("Vaixell amb motor");
        } else {
            System.out.println("Vaixell sense motor");
        }        
    }    
}
