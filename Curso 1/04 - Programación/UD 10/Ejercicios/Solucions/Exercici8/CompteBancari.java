/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici08;
import static java.lang.Math.abs;
import java.util.ArrayList;
/**
 * UF10 Exercici 8: Classe per a definir el compte bancari de DawBankS.
 */
public class CompteBancari {
    
    // Atributs constants de classe (static final)
    private static final double SALDO_MINIM = -50.0;
    private static final double AVISAR_HISENDA = 3000.0;
    
    // Atributs constants (final)
    private final String iban;
    private final String titular;

    // Atributs variables
    private double saldo;
    private ArrayList moviments;

    // Compte vàlid
    private boolean valid;

    // Constructor
    public CompteBancari(String iban, String titular) throws CompteException {

        // Guardem iban i titular
        this.iban = iban;
        this.titular = titular;

        // Inicilitzem saldo i moviments
        this.saldo = 0.0;
        this.moviments = new ArrayList();

        // Comprovem IBAN i registrem si és un compte vàlid o no
        if (!iban.matches("^[A-Z]{2}\\d{22}")) {
            this.valid = false;
            throw new CompteException("El format de l'IBAN no és correcte.");
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
    public boolean ingressar(double quantitat) throws CompteException, AvisarHisendaException, Exception {
        if (quantitat <= 0) {
            throw new CompteException("La quantitat a ingressar ha de ser major que 0.");
        }
        return operar(quantitat);
    }

    // Intenta retirar una quantitat. Retorna true si pot fer-ho, false si no
    public boolean retirar(double quantitat) throws CompteException, AvisarHisendaException, Exception {
        if (quantitat <= 0) {
            throw new CompteException("La quantitat a retirar ha de ser major que 0");
        }
        return operar(-quantitat);
    }

    // Intenta operar sobre el compte (ingressos +vo y retiradas -vo)
    // Retorna true si pot fer-ho, false si no
    private boolean operar(double quantitat) throws CompteException, AvisarHisendaException, AvisarHisendaAndSaldoException, Exception {
        boolean verificat;
        // No està permés arribar a un saldo inferior a SALDO_MINIM
        // Ni registrar més de MAX_MOVIMENTS moviments
        if (saldo + quantitat < SALDO_MINIM){
            throw new CompteException("L'operació no es pot realitzar perquè tindríem un saldo inferior a SALDO_MINIM");
        }
        
        // Realitzem l'operació: actualitzem saldo i moviments
        saldo += quantitat;
        moviments.add(quantitat);     

        // Avisos
        // Llanzarà una excepció avisant que el saldo és negatiu i que la quantitat a ingressar/retirar és major que AVISAR_HISENDA després de fer l'operació 
        if((saldo < 0.0) && (Math.abs(quantitat) > AVISAR_HISENDA)){
            throw new AvisarHisendaAndSaldoException(this.getIban(), this.getTitular(), tipusOperacio(quantitat), Math.abs(quantitat), "Aviso: Saldo en compte negatiu."); 
        } else {
            // Llanzarà una excepció avisant que el saldo és negatiu després de fer l'operació            
            if (saldo < 0.0){ 
                throw new Exception("Avis: Saldo en compte negatiu.");
            } else {
                // Llanzarà una excepció avisant que la quantitat a ingressar/retirar és major que AVISAR_HISENDA
                if (Math.abs(quantitat) > AVISAR_HISENDA) { 
                    throw new AvisarHisendaException(this.getIban(), this.getTitular(), tipusOperacio(quantitat), Math.abs(quantitat));
                }
            }
        }
        // L'operació és posible
         return true;
    }       

    // Indica el tipus d'operació que s'està realitzant
    private String tipusOperacio(double quantitat) {
        String tipusOperacio = "";
            
        if(quantitat>0) {
            tipusOperacio = "INGRES";
        } else {
            if(quantitat<0) {
                tipusOperacio = "RETIRADA";
            }
        }
        return tipusOperacio;
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
        System.out.println("Moviments: " + moviments.size());
        for (int i = 0; i < moviments.size(); i++) {
            System.out.println("#" + (i + 1) + ": " + moviments.get(i));
        }
    }
    
}
