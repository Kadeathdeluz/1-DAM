/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici08;
import static java.lang.Math.abs;
/**
 * UF09 Exercici 8: Classe per a definir el compte bancari de DawBankS.
 */
public class CompteBancari {
    
    // Atributs constants de classe (static final)
    private static final int MAX_MOVIMENTS = 100;
    private static final double SALDO_MINIM = -50.0;
    private static final double AVISAR_HISENDA = 3000.0;
    
    // Atributs constants (final)
    private final String iban;
    private final String titular;

    // Atributs variables
    private double saldo;
    private double[] moviments;
    private int nMoviments; // Número de moviments

    // Compte vàlid
    private boolean valid;

    // Constructor
    public CompteBancari(String iban, String titular) {

        // Guardem iban i titular
        this.iban = iban;
        this.titular = titular;

        // Inicilitzem saldo i moviments
        this.saldo = 0.0;
        this.moviments = new double[MAX_MOVIMENTS];
        this.nMoviments = 0;

        // Comprovem IBAN i registrem si és un compte vàlid o no
        if (!iban.matches("^[A-Z]{2}\\d{22}")) {
            System.err.println("ERROR: el format del IBAN no és correcte");
            this.valid = false;
        } else {
            this.valid = true;
        }
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean getValid() {
        return valid;
    }

    // Intenta ingressar una quantitat. Retorna true si pot fer-ho, false si no
    public boolean ingressar(double quantitat) {
        boolean verificat;
        if (quantitat <= 0) {
            verificat=false;
        } else {
            verificat=operar(quantitat);
        }
        return verificat;
    }

    // Intenta retirar una quantitat. Retorna true si pot fer-ho, false si no
    public boolean retirar(double quantitat) {
        boolean verificat;
        if (quantitat <= 0) {
            verificat=false;
        } else {
            verificat=operar(-quantitat);
        }
        return verificat;
    }

    // Intenta operar sobre el compte (ingressos +vo y retiradas -vo)
    // Retorna true si pot fer-ho, false si no
    private boolean operar(double quantitat) {
        boolean verificat;
        // No està permés arribar a un saldo inferior a SALDO_MINIM
        // Ni registrar més de MAX_MOVIMENTS moviments
        if ((saldo + quantitat < SALDO_MINIM) || (nMoviments >= MAX_MOVIMENTS)) {
            verificat=false;
       // L'operación es pot fer
        } else {
            verificat=true;
           // Realitzem l'operació: actualitzem saldo i moviments
            saldo += quantitat;
            moviments[nMoviments] = quantitat;
            nMoviments++;

            // Avisos
            if (saldo < 0.0) {
                System.err.println("AVIS: Saldo negatiu");
            }
            if (abs(quantitat) > AVISAR_HISENDA) {
                System.err.println("AVISO: Notificar a hisenda");
            }  
        }
 
        return verificat;
    }

    // Imprimir informació del compte
    public void imprimir() {
        imprimirDades();
        imprimirMoviments();
    }

    // Imprimir datos de la cuenta
    public void imprimirDades() {
        System.out.println("IBAN: " + getIban() + " - Titular: " + getTitular() + " - Saldo: " + getSaldo());
    }

    // Imprimir moviments realitzats
    public void imprimirMoviments() {
        System.out.println("Moviments: " + nMoviments);
        for (int i = 0; i < nMoviments; i++) {
            System.out.println("#" + (i + 1) + ": " + moviments[i]);
        }
    }
    
}
