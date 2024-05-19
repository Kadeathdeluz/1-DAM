package exercicist9.prg.ampliacio;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Moviment {

    private final TipusMoviment tipus;
    private final float saldoAnt, quantitat, saldoResultant;

    public Moviment(float saldoAnt, float quantitat, TipusMoviment tipus) {
            this.tipus = tipus;
            this.saldoAnt = saldoAnt;
            this.quantitat = quantitat;
            //En cas que siga un ingres la quantitat es suma al saldo, en cas contrari es resta (és una retirada)
            this.saldoResultant = (tipus == TipusMoviment.INGRES)
                    ? (saldoAnt + quantitat) : (saldoAnt - quantitat);
    }

    public TipusMoviment getTipus() {
        return tipus;
    }

    public float getSaldoAnt() {
        return saldoAnt;
    }

    public float getQuantitat() {
        return quantitat;
    }

    public float getSaldoResultant() {
        return saldoResultant;
    }

    @Override
    public String toString() {
        return " ------- Moviment ------- "
                + "\nTipus: " + this.getTipus()
                + "\nSaldo Anterior: " + this.getSaldoAnt()
                + "\nQuantitat: " + this.getQuantitat()
                + "\nSaldo Actual: " + this.getSaldoResultant() 
                + "\n------------------------";
    }

}
