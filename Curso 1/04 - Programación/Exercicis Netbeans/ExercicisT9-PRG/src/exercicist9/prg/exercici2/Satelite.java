package exercicist9.prg.exercici2;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Satelite extends Astre {

    private float distanciaAmbPlaneta, orbitaPlanetaria;
    private String planetaPerteneix;

    public Satelite(String nom, float massa, float radiEcuatorial, float periodeRotacio, float temperaturaMitjana, float distanciaAmbPlaneta, float orbitaPlanetaria, String planetaPerteneix) {
        super(nom, massa, radiEcuatorial, periodeRotacio, temperaturaMitjana);
        this.distanciaAmbPlaneta = distanciaAmbPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaPerteneix = planetaPerteneix;
    }

}
