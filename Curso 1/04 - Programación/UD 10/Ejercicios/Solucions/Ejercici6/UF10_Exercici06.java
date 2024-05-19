/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici06;

/**
 * UF10 Exercici 06: Programa que crea instàncies de la classe Gat per a provar els errors.
 */
public class UF10_Exercici06 {
    
    public static void main(String[] args) {
        
        try {            
            // Creem diversos objectes de tipus Gat
            Gat g1 = new Gat("Cati", 5);
            Gat g2 = new Gat("Miau",3);
            Gat g3 = new Gat("Milú", 2);
            
            // Modifiquem les dades dels objectes
            g1.imprimir();
            g1.setNom("Gatito");
            g1.setEdat(10);
            g1.imprimir();
            
            
            // Anirem llevant comentaris a cada línia per provar
            // g2.imprimir();
            // g2.setNom("Do");
            // g2.imprimir();
            
            // g3.imprimir();
            // g3.setEdat(-5);
            // g3.imprimir();
            
        } catch(Exception e) {
            System.out.println(e);            
        }
        
        System.out.println("Fi del programa");            
        
    }    
    
}
