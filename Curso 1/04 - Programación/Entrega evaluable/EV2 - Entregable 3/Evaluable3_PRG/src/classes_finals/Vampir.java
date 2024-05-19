package classes_finals;

import enumerats.Vulnerable;
import java.util.ArrayList;
import superclasses.Ciutada;

/**
 *
 * @author Roldán Sanchis Martínez
 *
 * Classe final que representa als ciutadans vampirs.
 *
 * Hereta de Ciutada i no pot ser heretada (final class).
 */
public final class Vampir extends Ciutada {

    /* ATRIBUTS DE CLASSE */
    //Número total de vampirs
    private static int totalVampirs = 0;
    //Número de l'últim Vampir creat
    private static int ultimVampir = 1;

    /* ATRIBUTS D'INSTANCIA */
    //Vulnerabilitat del Vampir, és final perque no canvia
    private final Vulnerable VULNERABLE;

    /**
     * Constructor de la classe Vampir.
     *
     * Crea un Vampir amb nom i vulnerabilitat als llops.
     *
     * Incrementa la població de vampirs amb cada Vampir, així com la variable
     * ultimVampir.
     *
     * @param nom Nom del Vampir a crear.
     */
    public Vampir(String nom) {
        //Incrementa la població de ciutadans al cridar a super()
        super(nom + ultimVampir);
        this.VULNERABLE = Vulnerable.LLOP;

        totalVampirs++;
        ultimVampir++;
    }

    /**
     * Mètode de classe que retorna la població total de Vampir.
     *
     * @return Retorna el nombre total de vampirs.
     */
    public static int getPoblacio() {
        return totalVampirs;
    }

    /**
     * Mètode de classe que actualitza la població total de Vampir.
     *
     * @param numero Nou nombre de població.
     */
    public static void setPoblacio(int numero) {
        totalVampirs = numero;
    }

    /**
     * Mètode d'instancia que defineix com combat un Vampir.
     *
     * Vampir perd contra Llop i guanya contra Huma.
     *
     */
    @Override
    public Ciutada combat(Ciutada oponent) {
        //Si el tipus de l'oponent i la vulnerabilitat del Ciutada són iguals, el Ciutada (this) és el perdedor, en cas contrari, perd l'oponent
        if(oponent.getClass().getSimpleName().toLowerCase().equals(this.VULNERABLE.toString().toLowerCase())) {
            System.out.print(" pero mor a la llum del Sol.");
            return this;
        }
        else {
            System.out.print(" guanya convertint-lo en el seu vampir personal: ");
            return oponent;
        }
    }

    /**
     * Mètode d'instancia que indica el comportament quan un Vampir mor.
     * Disminueix la població de Vampir i ja no forma part dels ciutadans (també
     * disminueix la població de Ciutada).
     */
    @Override
    public void morir(ArrayList<Ciutada> ciutadans) {
        //Redueix la població vampira
        totalVampirs--;
        //Redueix la població total
        Ciutada.setPoblacio(Ciutada.getPoblacio() - 1);
        //El Vampir mort deixa de formar part dels ciutadans
        ciutadans.remove(this);
    }

    /**
     * Mètode d'instancia que retorna la vulnerabilitat d'un Vampir.
     *
     * @return Retorna la vulnerabilitat (VULNERABLE) d'un Vampir.
     */
    public Vulnerable getVulnerable() {
        return this.VULNERABLE;
    }

    /**
     * Mètode d'instancia que sobreescriu el mètode toString de Ciutada.
     *
     * @return Retorna, a mes del nom, la vulnerabilitat del Vampir.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", vulnerabilitat: " + VULNERABLE;
    }

}
