/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici04;

/**
 * UF09 Exercici 04: Superclasse Abstracta Compte Bancari
 */
abstract public class CompteBancari {
    
    // Atirbuts
    private final String iban;
    private double saldo;
    public static final double interesAnualBasic = 2.5;

    // Constructor
    public CompteBancari(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    // Mètode abstracte per calcular interéssos
    public abstract void calcularInteressos();

    // Mètode abstracte per mostrar dades del compte
    public abstract void mostrar();

    // GETTERS
    
    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    // Afegir cantitat (mètode privat utilitzat per a ingressar i retirar)
    private void afegir(double cantitat) {
        this.saldo += cantitat;
    }

    // Ingressar cantitat
    public void ingressar(double cantitat) {
        afegir(cantitat);
    }

    // Retirar cantitat
    public void retirar(double cantitat) {
        afegir(-cantitat);
    }

    // Traspassem 'cantitat' de este compte a cc
    public void traspass(double cantitat, CompteBancari cc) {
        cc.ingressar(cantitat);
        this.retirar(cantitat);
    }
    
    
}
