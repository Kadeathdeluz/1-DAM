package exercicist9.prg.exercici6;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Terrestre extends Vehicle {
    public static final String PATRO_MATRICULA = "\\d{4}[A-Z]{3}";
    private final int numRodes;

    public Terrestre(String matricula, String model, int numRodes) {
        super(matricula, model);
        this.numRodes = numRodes;
    }
    
    public int getRodes() {
        return this.numRodes;
    }
    
    @Override
    public String toString() {
        return super.toString() + "rodes: " + this.numRodes;
    }
}
