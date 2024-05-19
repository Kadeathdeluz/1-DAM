/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici08;

/**
 * UF10 Exercici 08: Classe per a excepcions d'avisos a Hisenda i de saldos negatius.
 */
public class AvisarHisendaAndSaldoException extends Exception {
    
    // Atributs
    private String iban;
    private String titular;
    private String tipusOperacio;
    private double quantitat;
    private String mssgSaldo;
    
    // Constructor
    public AvisarHisendaAndSaldoException(String iban, String titular, String tipusOperacio, double quantitat, String mssgSaldo) 
    {
        this.iban = iban;
        this.titular = titular;
        this.tipusOperacio = tipusOperacio;
        this.quantitat = quantitat;
        this.mssgSaldo = mssgSaldo;
    }
    
    @Override
    public String toString()
    {
        String missatge = "Avís: El titular " + this.titular + " del compte " + this.iban + " ha realitzat un/a " + this.tipusOperacio + " de " + this.quantitat + "\n";
        missatge += this.mssgSaldo;
        return "Excepció Avisar Hisenda i Saldo Negatiu: \n" + missatge;
    }  
    
}
