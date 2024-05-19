/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici04;

/**
 * UF09 Exercici 04: Subclasse Compte Corrent
 */
public class CompteCorrent extends CompteBancari {
    
    // Constructor
    public CompteCorrent(String num, double saldo) {
        super(num, saldo);
    }

    // Calcula interessos i els ingressa en el compte
    public void calcularInteressos() {
        double interes = this.getSaldo() * (interesAnualBasic / 100);
        this.ingressar(interes);
    }

    public void mostrar() {
        System.out.println("Compte Corrent IBAN: " + this.getIban() + " Saldo: " + this.getSaldo());
    }
    
}
