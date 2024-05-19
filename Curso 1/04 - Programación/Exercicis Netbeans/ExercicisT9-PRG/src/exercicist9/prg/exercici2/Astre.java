package exercicist9.prg.exercici2;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public abstract class Astre {

    private String nom;
    private float massa, radiEcuatorial, periodeRotacio, temperaturaMitjana;

    public Astre(
            String nom, float massa, float radiEcuatorial, float periodeRotacio, float temperaturaMitjana
    ) {
        this.nom = nom;
        this.massa = massa;
        this.radiEcuatorial = radiEcuatorial;
        this.periodeRotacio = periodeRotacio;
        this.temperaturaMitjana = temperaturaMitjana;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getMassa() {
        return massa;
    }

    public void setMassa(float massa) {
        this.massa = massa;
    }

    public float getRadiEcuatorial() {
        return radiEcuatorial;
    }

    public void setRadiEcuatorial(float radiEcuatorial) {
        this.radiEcuatorial = radiEcuatorial;
    }

    public float getPeriodeRotacio() {
        return periodeRotacio;
    }

    public void setPeriodeRotacio(float periodeRotacio) {
        this.periodeRotacio = periodeRotacio;
    }

    public float getTemperaturaMitjana() {
        return temperaturaMitjana;
    }

    public void setTemperaturaMitjana(float temperaturaMitjana) {
        this.temperaturaMitjana = temperaturaMitjana;
    }

    public String toString() {
        return "\nNom: " + getNom()
                + ",\nMassa: " + getMassa()
                + ",\nRadi: " + getRadiEcuatorial()
                + ",\nRotació: " + getPeriodeRotacio()
                + ",\nTemperatura mitjana: " + getTemperaturaMitjana() + "ºC";
    }

}
