package superclasses;

import classes_finals.Llop;
import classes_finals.Vampir;
import interficies.Batalla;
import java.util.ArrayList;

/**
 *
 * @author Roldán Sanchis Martínez
 *
 * Superclasse abstracta (no es pot instanciar) que representa als ciutadans i
 * el seu comportament.
 *
 * Implementa l'interficie Batalla.
 */
public abstract class Ciutada implements Batalla {

    //Nombre enter que representa la població total (Ciutada) - atribut de classe
    private static int poblacio = 0;

    //Cadena de text que representa el nom del Ciutada - atribut d'instancia
    private String nom;

    /**
     * Constructor de la classe Ciutada. Rep el nom del ciutada e incrementa la
     * població amb cada individu.
     *
     * @param nom Nom del Ciutada a crear.
     */
    public Ciutada(String nom) {
        this.nom = nom;
        poblacio++;
    }

    /**
     * Mètode de classe que retorna el nombre total de ciutadans.
     *
     * @return Retorna el nombre total de ciutadans.
     */
    public static int getPoblacio() {
        return poblacio;
    }

    /**
     * Mètode de classe que actualitza el nombre total de ciutadans.
     *
     * @param numero Nou nombre total de ciutadans.
     */
    public static void setPoblacio(int numero) {
        poblacio = numero;
    }

    /**
     * Mètode d'instancia que retorna el nom del Ciutada.
     *
     * @return Retorna el nom del Ciutada.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Mètode d'instancia que actualitza el nom del Ciutada.
     *
     * @param nom Nou nom del Ciutada.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Mètode d'instancia que sobrescriu el mètode toString() de la classe
     * Object.
     *
     * @return Retorna una representació en cadena del Ciutada amb l'estructura:
     * "Nom del ciutada: " més el nom del Ciutada.
     */
    @Override
    public String toString() {
        return "Nom del ciutada: " + this.nom;
    }

    /**
     * Mètode de classe que imprimeix els ciutadans i les poblacions totals.
     *
     * @param ciutadans Lista (ArrayList) de ciutadans a imprimir.
     */
    public static void censar(ArrayList<Ciutada> ciutadans) {
        //Imprimeix cada Ciutada en una nova linea per a millorar la visualització
        for (Ciutada ciutada : ciutadans) {
            System.out.println(ciutada);
        }

        //Imprimeix el cens de totes les poblacions
        poblacionsTotals();
    }

    /**
     * Mètode de classe que imprimeix per pantalla el cens de cada una de les poblacions:
     * <ul>
     * <li>Població total de Ciutada</li>
     * <li>Població total d' Huma</li>
     * <li>Població total de Llop</li>
     * <li>Població total de Vampir</li>
     * </ul>
     */
    public static void poblacionsTotals() {
        //Que m'agrada a mi un operador ternari... (?:)
        System.out.println("Actualment hi ha un cens de: "
                + Ciutada.getPoblacio() + (Ciutada.getPoblacio() == 1 ? " ciutadà" : " ciutadans")
                + ".\n"
                + Huma.getPoblacio() + " " + (Huma.getPoblacio() == 1 ? "humà" : "humans")
                + ", " + Llop.getPoblacio() + " " + (Llop.getPoblacio() == 1 ? "llop" : "llops")
                + " i " + Vampir.getPoblacio() + " " + (Vampir.getPoblacio() == 1 ? "vampir" : "vampirs")
                + "."
        );
    }

    /**
     * Mètode abstracte (no implementat a la clase) que indica el comportament
     * quan un ciutadà mor.
     *
     * @param ciutadans Llista (ArrayList) de ciutadans
     */
    public abstract void morir(ArrayList<Ciutada> ciutadans);
}
