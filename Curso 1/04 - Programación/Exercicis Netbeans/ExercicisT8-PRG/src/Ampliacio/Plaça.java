package Ampliacio;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Plaça {

    final int numPlaça;
    private Estat estat;
    private String matricula;
    
    public Plaça(int numPlaça) {
        this.numPlaça = numPlaça;
        this.estat = Estat.LLIURE;
        this.matricula = "";
    }
    
    public Plaça(int numPlaça, String matricula) {
        this.numPlaça = numPlaça;
        this.estat = Estat.LLIURE;
        this.matricula = matricula;
    }
    
    public Plaça(int numPlaça, Estat estat, String matricula) {
        this.numPlaça = numPlaça;
        this.estat = estat;
        this.matricula = matricula;
    }

    public Estat getEstat() {
        return estat;
    }

    public void setEstat(Estat estat) {
        this.estat = estat;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    @Override
    public String toString() {
        return "La plaça d'aparcament número " + numPlaça 
                + " es troba " + getEstat() 
                + (getEstat() == Estat.LLIURE ? ("") : (" pel vehicle " + getMatricula()) );
    }
}
