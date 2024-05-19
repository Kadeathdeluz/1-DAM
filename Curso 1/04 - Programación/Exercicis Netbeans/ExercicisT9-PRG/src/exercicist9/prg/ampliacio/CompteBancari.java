package exercicist9.prg.ampliacio;

import java.util.ArrayList;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class CompteBancari {

    public static final int MIN_SALDO = -50, AVIS_HISENDA = 3000, MAX_MOVIMENTS = 100;

    private final String iban;
    private final String titular;
    private float saldo;
    private ArrayList<Moviment> moviments;

    public CompteBancari(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0.0f;
        moviments = new ArrayList<>();
    }

    public boolean comprovaIban() {
        return this.iban.matches("^[A-Z]{2}\\d{22}");
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Moviment> getMoviments() {
        return moviments;
    }

    public void setMoviments(ArrayList<Moviment> moviments) {
        this.moviments = moviments;
    }

    public boolean afigMoviment(Moviment moviment) {
        float saldoResultant = moviment.getSaldoResultant();

        if (moviment.getQuantitat() > 3000) {
            System.out.println("AVÍS: Notificar a hisenda.");
        }

        if (saldoResultant < 0 && saldoResultant >= -50) {
            System.out.println("AVÍS: saldo negatiu.");
        }
        if ((saldoResultant >= -50) && (moviments.size() <= MAX_MOVIMENTS)) {
            this.moviments.add(moviment);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return " --------- Compte bancari --------- "
                + "\nIBAN: " + iban
                + "\nTitular: " + titular
                + "\nSaldo: " + saldo
                + "\n ---------------------------------- ";
    }
}
