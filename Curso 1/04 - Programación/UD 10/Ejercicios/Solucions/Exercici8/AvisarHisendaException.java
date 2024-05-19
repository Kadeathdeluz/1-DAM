/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici08;

/**
 * UF10 Exercici 08: Classe per a excepcions d'avisos a Hisenda
 */
public class AvisarHisendaException extends Exception {
    
    // Atributs
    private String iban;
    private String titular;
    private String tipusOperacio;
    private double quantitat;
    
    // Constructor
    public AvisarHisendaException(String iban, String titular, String tipusOperacio, double quantitat) {
        this.iban = iban;
        this.titular = titular;
        this.tipusOperacio = tipusOperacio;
        this.quantitat = quantitat;
    }
    
    @Override
    public String toString() {
        String missatge = "Avís: El titular " + this.titular + " del compte " + this.iban + " ha realitzat un/a " + this.tipusOperacio + " de " + this.quantitat;
        return "Excepció Avisar Hisenda: " + missatge;
    }  
    
}
