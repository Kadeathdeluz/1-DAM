package projectebase;

import java.util.ArrayList;
import java.util.Iterator;
import utils.BdadesDelPoble;

public abstract class Ciutada implements Batalla {

    private static int poblacio = 0;

    private static int ultimCiutada = 1;

    // Atributs
    private final String nom;
    private final int id;
    private final Vulnerable vulnerable;
    private int forca;
    private int vida;

    // Constructor    
    public Ciutada(String nom) {
        poblacio++;
        this.id = ultimCiutada;
        this.vulnerable = Vulnerable.Tots;
        this.nom = nom;
        ultimCiutada++;
    }

    // Constructor    
    public Ciutada(String nom, int forca, int vida, Vulnerable vulnerable) {
        poblacio++;
        this.id = ultimCiutada;
        this.nom = nom;
        this.forca = forca;
        this.vida = vida;
        this.vulnerable = vulnerable;
        ultimCiutada++;

    }

    // MÈTODE POLIMÒRFIC ON CADA CLASSE MOSTRA EL SEU TOTAL
    // Mètode que ens indica la població d'aquesta classe (cada subclasse tindrà el seu propi)
    public static int getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(int numero) {
        poblacio += numero;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the ultimCiutada
     */
    public static int getUltimCiutada() {
        return ultimCiutada;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the vulnerable
     */
    public Vulnerable getVulnerable() {
        return vulnerable;
    }

    /**
     * @return the forca
     */
    public int getForca() {
        return forca;
    }

    /**
     * @param forca the forca to set
     */
    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Mètode que retorna el nom, la força, la vida i el vulnerable
     *
     * @return String
     */
    @Override
    public String toString() {
        return "nom: " + getNom()
                + ", força: " + getForca()
                + ", vida: " + getVida()
                + "vulnerable: " + getVulnerable();
    }

    public static void censar(ArrayList<Ciutada> ciutadans) {
        Iterator it = ciutadans.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
        poblacionsTotals();
    }

    public static void poblacionsTotals() {
        System.out.println("Actualment hi ha un cens de: " + Ciutada.getPoblacio() + " ciutadans.");
        System.out.println(Huma.getPoblacio() + " humans, "
                + Llop.getPoblacio() + " llops, "
                + Vampir.getPoblacio() + " vampirs i "
                + Mestis.getPoblacio() + " mestisos");

    }
    
    /* Guarda el ciutadà a la BDD */
    public static void guardar(Ciutada ciutada){
        BdadesDelPoble.guardarDades("ciutadans", ciutada);
    }
    
    /* Elimina el ciutadà de la BDD */
    public static void eliminar(Ciutada ciutada){
        BdadesDelPoble.borrarDades("ciutadans", ciutada);
    }

    public Ciutada combat(Ciutada oponent){
        //La forza i la vida de this (el ciutada)
        int forza1 = this.getForca();
        int vida1 = this.getVida();
        
        //La forza i la vida de l'oponent
        int forza2 = oponent.getForca();
        int vida2 = oponent.getVida();
        
        System.out.print(this.getNom() + " ataca " + oponent.getNom());
        if(oponent.getClass().getSimpleName().equals(this.getVulnerable().toString())){
            this.setVida(vida1-forza2);
            return this;
        }else{
            oponent.setVida(vida2-forza1);
            return oponent;
        }
    }
    
    public abstract void morir(ArrayList<Ciutada> ciutadans);
}
