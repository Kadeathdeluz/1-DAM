/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici06;

/**
 * UF01 Exercici 06: Classe Gat, utilitza excepcions per a validar.
 * Valida que el nom tinga al menys 3 caràcters i que l'edat no siga negativa.
 */
public class Gat {
    
    // Atributs
    private String nom;
    private int edat;
    
    // Constructor
    public Gat(String nom, int edat) throws Exception { // Ha de poder llançar excepcions per que crida a mètodes que llancen.
        this.setNom(nom);
        this.setEdat(edat);       
    }
    
    // Getters y setters
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) throws Exception {
        if (nom.length() < 3) {
            throw new Exception("ERROR: El nom ha de tindre al menys 3 caràcters.");
        } 
        
        this.nom = nom;        
    }
    
    public int getEdat() {
        return this.edat;
    }
   
    public void setEdat(int edat) throws Exception {
        if (edat < 0) {
            throw new Exception("ERROR: L'edat no pot ser negativa.");
        } 
        
        this.edat = edat;        
    }
    
    // Método imprimir
    public void imprimir()
    {
        System.out.println("Al gat li diuen " + this.getNom() + " i té " + this.getEdat() + " anys d'edat.");
    }
        
    
}
