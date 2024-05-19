package interficies;

import java.util.ArrayList;
import superclasses.Ciutada;

/**
 *
 * @author Roldán Sanchis Martínez
 *
 * Interficie que especifica la funcionalitat necessaria dels èssers vius (Llop
 * i Huma).
 */
public interface Cicle_Vital {

    //Nombre enter que representa la natalitat màxima
    public static final int NATALITAT_MAXIMA = 1;
    //Nombre enter que representa la vitalitat màxima
    public static final int VITALITAT_MAXIMA = 2;

    /**
     * Mètode abstracte que genera un nou ésser i el suma a la població
     *
     * @param ciutadans Llista (ArrayList) amb la població de ciutadans.
     */
    public abstract void reproduir(ArrayList<Ciutada> ciutadans);

    /**
     * Mètode abstracte que resta un any de vida a l'idividu i en cas de no
     * quedar anys de vida, li causa la mort natural.
     *
     * @param ciutadans Llista (ArrayList) amb la població de ciutadans.
     */
    public abstract void envellir(ArrayList<Ciutada> ciutadans);

}
