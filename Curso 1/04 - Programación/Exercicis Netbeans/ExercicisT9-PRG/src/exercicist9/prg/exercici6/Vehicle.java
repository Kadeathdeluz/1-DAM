package exercicist9.prg.exercici6;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public abstract class Vehicle {
    protected final String matricula;
    protected final String model;
    
    public Vehicle(String matricula, String model) {
        this.matricula = matricula;
        this.model = model;
    }
    
    public String getMatricula() {
        return this.matricula;
    }
    
    public String getModel() {
        return this.model;
    }
    
    @Override
    public String toString() {
        return "Tipus: " + this.getClass() + "matricula: " + this.matricula + "model: " + this.model;
    }
    
    //public abstract boolean comprovarMatricula();
    
}
