/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici04;

/**
 * UF09 Exercici 04: Subclasse Compte Estalvi
 */
public class CompteEstalvi extends CompteBancari  {
    
    // Atributs
    final double saldoMinim = 3000;

    // Constructor
    public CompteEstalvi(String iban, double saldo) {
        super(iban, saldo);
    }

    // Calcula interessos i els ingressa en el compte
    public void calcularInteressos() {
        double interes;
        if (this.getSaldo() < saldoMinim) {
            interes = this.getSaldo() * ((interesAnualBasic / 2.0) / 100.0);
        } else {
            interes = this.getSaldo() * ((interesAnualBasic * 2.0) / 100.0);
        }
        this.ingressar(interes);
    }

    public void mostrar() {
        System.out.println("Compte Estalvi IBAN: " + this.getIban() + " Saldo: " + this.getSaldo());
    }    
    
}
