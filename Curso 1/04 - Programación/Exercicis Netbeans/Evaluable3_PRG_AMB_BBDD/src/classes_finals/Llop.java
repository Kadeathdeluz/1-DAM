package classes_finals;

import enumerats.Vulnerable;
import execucio.ElPobleDormit;
import interficies.Cicle_Vital;
import java.util.ArrayList;
import java.util.Random;
import superclasses.Ciutada;

/**
 *
 * @author Roldán Sanchis Martínez
 *
 * Classe final que representa als ciutadans llops.
 *
 * Hereta de Ciutada i no pot ser heretada (final class).
 *
 * Implementa la interficie Cicle_Vital.
 */
public final class Llop extends Ciutada implements Cicle_Vital {

    /* ATRIBUTS DE CLASSE */
    //Número total de llops
    private static int totalLlops = 0;
    //Número de l'últim Llop creat
    private static int ultimLlop = 1;
    //Objecte Random utilitzat per a generar números aleatoris.
    private static final Random ALEATORI = new Random();

    /* ATRIBUTS D'INSTANCIA */
    //Vulnerabilitat del Llop, és final perque no canvia
    private final Vulnerable VULNERABLE;
    //Vida restant del Llop
    private int vida;

    /**
     * Constructor de la classe Llop.
     *
     * Crea un Llop amb nom, vulnerabilitat als humans i una quantitat de vida
     * restant aleatoria basada en el doble de la Cicle_Vital.VITALITAT_MAXIMA.
     *
     * Incrementa la població de llops amb cada Llop, així com la variable
     * ultimLlop
     *
     * @param nom Nom del Llop a crear.
     */
    public Llop(String nom) {
        //Incrementa la població de ciutadans al cridar a super()
        super(nom + ultimLlop);
        this.VULNERABLE = Vulnerable.HUMA;
        this.vida = ALEATORI.nextInt(Cicle_Vital.VITALITAT_MAXIMA * 2) + 1;

        totalLlops++;
        ultimLlop++;
    }

    /**
     * Mètode de classe que retorna la població total de Llop.
     *
     * @return Retorna el nombre total de llops.
     */
    public static int getPoblacio() {
        return totalLlops;
    }

    /**
     * Mètode de classe que actualitza la població total de Llop.
     *
     * @param numero Nou nombre de població.
     */
    public static void setPoblacio(int numero) {
        totalLlops = numero;
    }

    /**
     * Mètode d'instancia que defineix com combat un Llop.
     *
     * Llop perd contra Huma i guanya contra Vampir.
     *
     */
    @Override
    public Ciutada combat(Ciutada oponent) {
        //Si el tipus de l'oponent i la vulnerabilitat del Ciutada són iguals, el Ciutada (this) és el perdedor, en cas contrari, perd l'oponent
        if(oponent.getClass().getSimpleName().toLowerCase().equals(this.VULNERABLE.toString().toLowerCase())) {
            System.out.print(" pero mor amb una bala de plata.");
            return this;
        }
        else {
            System.out.print(" guanya i es fa un collar amb els seus ullals.");
            return oponent;
        }
    }
    

    /**
     * Mètode d'instancia que produeix una reproducció: el Llop actual es
     * reprodueix i "crea" un nombre aleatori de fills Llop (entre 1 y el doble
     * de Cicle_Vital.NATALITAT_MAXIMA) que s'afegeixen a la llista (ArrayList)
     * de població de ciutadans.
     */
    @Override
    public void reproduir(ArrayList<Ciutada> ciutadans) {
        /*El nombre màxim de cadells que pot tindre 
        (el mínim entre la (NATALITAT_MAXIMA * 2) i la capacitat restant del poble: 
        MAX_POBLACIO - Ciutada.poblacio)*/
        int maxCadells = Math.min(Cicle_Vital.NATALITAT_MAXIMA * 2, (ElPobleDormit.MAX_POBLACIO - Ciutada.getPoblacio()));
        //Nombre de cadells que tindrà (entre 1 i maxCadells, aquest inclòs)
        int numFills = ALEATORI.nextInt(maxCadells) + 1;

        System.out.print("Enhorabona per "
                + this.getNom() + ", ha tingunt "
                + numFills + (numFills == 1 ? " cadell: " : " cadells: ")
        );
        
        //Afegix cada nou Llop a la llista (ArrayList) de ciutadans
        for (int i = 1; i <= numFills; i++) {
            Llop nouLlop = new Llop("Llop");
            ciutadans.add(nouLlop);
            System.out.print(nouLlop.getNom() + (i == numFills  ? "." : ", " ) );
        }
    }

    /**
     * Mètode d'instancia que indica el comportament quan un Llop mor.
     * Disminueix la població de Llop i ja no forma part dels ciutadans (també
     * disminueix la població de Ciutada).
     */
    @Override
    public void morir(ArrayList<Ciutada> ciutadans) {
        //Redueix la població de llops
        totalLlops--;
        //Redueix la població total
        Ciutada.setPoblacio(Ciutada.getPoblacio() - 1);
        //El Llop mort deixa de formar part dels ciutadans);
        ciutadans.remove(this);       
    }

    /**
     * Mètode d'instancia que redueix la vida d'un Llop de dos en dos i el mata
     * si la vida arriba a zero.
     */
    @Override
    public void envellir(ArrayList<Ciutada> ciutadans) {
        //Reducció de la vida
        this.vida -= 2;
        //Si la vida és 0 (o inferior) el Llop mor
        if (this.vida <= 0) {
            this.morir(ciutadans);
            System.out.println(this.getNom() + " ha mort de vell.");
        }
    }

    /**
     * Mètode d'instancia que retorna la vulnerabilitat d'un Llop.
     *
     * @return Retorna la vulnerabilitat (VULNERABLE) d'un Llop.
     */
    public Vulnerable getVulnerable() {
        return this.VULNERABLE;
    }

    /**
     * Mètode d'instancia que sobreescriu el mètode toString de Ciutada.
     *
     * @return Retorna, a mes del nom, la vida restant i la vulnerabilitat del
     * Llop.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", vida: " + vida
                + ", vulnerabilitat: " + VULNERABLE;
    }

}
