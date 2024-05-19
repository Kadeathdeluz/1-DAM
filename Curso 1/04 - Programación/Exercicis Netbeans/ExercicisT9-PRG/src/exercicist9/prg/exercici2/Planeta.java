package exercicist9.prg.exercici2;

import java.util.ArrayList;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Planeta extends Astre {

    private float distanciaSolar, orbitaSolar;
    private boolean teSatelits;
    private ArrayList<Satelite> satelits;

    public Planeta(
            String nom, float massa, float radiEcuatorial,
            float periodeRotacio, float temperaturaMitjana, float distanciaSolar,
            float orbitaSolar, ArrayList<Satelite> satelits
    ) {
        super(nom, massa, radiEcuatorial, periodeRotacio, temperaturaMitjana);
        this.distanciaSolar = distanciaSolar;
        this.orbitaSolar = orbitaSolar;
        this.satelits = satelits;
        this.teSatelits = !satelits.isEmpty();
    }

    public float getDistanciaSolar() {
        return distanciaSolar;
    }

    public void setDistanciaSolar(float distanciaSolar) {
        this.distanciaSolar = distanciaSolar;
    }

    public float getOrbitaSolar() {
        return orbitaSolar;
    }

    public void setOrbitaSolar(float orbitaSolar) {
        this.orbitaSolar = orbitaSolar;
    }

    public boolean isTeSatelits() {
        return teSatelits;
    }

    public void setTeSatelits(boolean teSatelits) {
        this.teSatelits = teSatelits;
    }

    public ArrayList<Satelite> getSatelits() {
        return satelits;
    }

    public void setSatelits(ArrayList<Satelite> satelits) {
        this.satelits = satelits;
    }

    @Override
    public String toString() {
        return "Nom: " + this.getNom()
                + "\nMasa: " + this.getMassa() + " Kg."
                + "\nRadi: " + this.getRadiEcuatorial() + " Km."
                + "\nRotació: : " + this.getPeriodeRotacio()+ " dies."
                + "\nTemperatura: " + this.getTemperaturaMitjana()+ " ºC."
                + "\nDistancia al Sol: " + this.getDistanciaSolar()+ " Km."
                + "\nÓrbita solar: " + this.getOrbitaSolar() + " Km."
                + "\nSatelits: " + this.getSatelits();
    }

}
