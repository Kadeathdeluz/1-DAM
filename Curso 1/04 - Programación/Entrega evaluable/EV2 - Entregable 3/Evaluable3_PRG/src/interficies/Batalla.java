package interficies;

import superclasses.Ciutada;

/**
 *
 * @author Roldán Sanchis Martínez
 *
 * Interficie que representa la Batalla i conté el mètode que definix el combat.
 */
public interface Batalla {

    /**
     * Mètode abstracte que defineix el combat entre ciutadans.
     *
     * @param oponent Ciutada oponent del Ciutada que combat.
     * @return Retorna el Ciutada perdedor del combat.
     */
    public Ciutada combat(Ciutada oponent);

}
