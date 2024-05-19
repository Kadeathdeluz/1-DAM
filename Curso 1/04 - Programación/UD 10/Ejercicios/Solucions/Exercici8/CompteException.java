/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici08;

/**
 * UF10 Exercici 08: Classe per a excepcions en el compte bancari
 */
public class CompteException extends Exception {
    
    // Atributs
    private String missatge;
    
    // Constructor
    public CompteException(String missatge) {
        this.missatge = missatge;
    }
    
    // Getter
    @Override
    public String toString() {
        return "Excepció Compte: " + this.missatge;
    }  
}
