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
 * Classe final que representa als ciutadans humans.
 *
 * Hereta de Ciutada i no pot ser heretada (final class).
 *
 * Implementa la interficie Cicle_Vital.
 */
public final class Huma extends Ciutada implements Cicle_Vital {

    /* ATRIBUTS DE CLASSE */
    //Número total d'humans
    private static int totalHumans = 0;
    //Número de l'últim Huma creat
    private static int ultimHuma = 1;
    //Objecte Random utilitzat per a generar números aleatoris.
    private static final Random ALEATORI = new Random();

    /* ATRIBUTS D'INSTANCIA */
    //Vulnerabilitat de l'Huma, és final perque no canvia
    private final Vulnerable VULNERABLE;
    //Vida restant de l'Huma
    private int vida;

    /**
     * Constructor de la classe Huma.
     *
     * Crea un Huma amb nom, vulnerabilitat als vampirs i una quantitat de vida
     * restant aleatoria basada en la Cicle_Vital.VITALITAT_MAXIMA.
     *
     * Incrementa la població d'humans amb cada Huma, així com la variable
     * ultimHuma
     *
     * @param nom Nom de l'Huma a crear.
     */
    public Huma(String nom) {
        //Incrementa la població de ciutadans al cridar a super()
        super(nom + ultimHuma);
        this.VULNERABLE = Vulnerable.VAMPIR;
        this.vida = ALEATORI.nextInt(Cicle_Vital.VITALITAT_MAXIMA) + 1;

        totalHumans++;
        ultimHuma++;
    }

    /**
     * Mètode de classe que retorna la població total d'Huma.
     *
     * @return Retorna el nombre total d'humans.
     */
    public static int getPoblacio() {
        return totalHumans;
    }

    /**
     * Mètode de classe que actualitza la població total d'Huma.
     *
     * @param numero Nou nombre de població.
     */
    public static void setPoblacio(int numero) {
        totalHumans = numero;
    }

    /**
     * Mètode d'instancia que defineix com combat un Huma.
     *
     * Huma perd contra Vampir i guanya contra Llop.
     *
     */
    @Override
    public Ciutada combat(Ciutada oponent) {
        //Si el tipus de l'oponent i la vulnerabilitat del Ciutada són iguals, el Ciutada (this) és el perdedor, en cas contrari, perd l'oponent
        if (oponent.getClass().getSimpleName().toLowerCase().equals(this.VULNERABLE.toString().toLowerCase())) {
            System.out.print(" pero mor i es converteix en ");
            return this;
        } else {
            System.out.print(" guanya i ven la seua pell per a fer abrics.");
            return oponent;
        }
    }

    /**
     * Mètode d'instancia que produeix una reproducció: l'Huma actual es
     * reprodueix i "crea" un nombre aleatori de fills Huma (entre 1 y
     * Cicle_Vital.NATALITAT_MAXIMA) que s'afegeixen a la llista (ArrayList) de
     * població de ciutadans.
     */
    @Override
    public void reproduir(ArrayList<Ciutada> ciutadans) {
        /*El nombre màxim de fills que pot tindre 
        (el mínim entre la NATALITAT_MAXIMA i la capacitat restant del poble: 
        MAX_POBLACIO - Ciutada.poblacio)*/
        int maxFills = Math.min(Cicle_Vital.NATALITAT_MAXIMA, (ElPobleDormit.MAX_POBLACIO - Ciutada.getPoblacio()));
        //Nombre de fills que tindrà (entre 1 i maxFills, aquest inclòs)
        int numFills = ALEATORI.nextInt(maxFills) + 1;

        System.out.print("Enhorabona per "
                + this.getNom() + ", ha tingunt "
                + numFills + (numFills == 1 ? " fill: " : " fills: ")
        );
        
        //Afegix cada nou Huma a la llista (ArrayList) de ciutadans
        for (int i = 1; i <= numFills; i++) {
            Huma nouHuma = new Huma("Huma");
            ciutadans.add(nouHuma);
            System.out.print(nouHuma.getNom());

        }
        System.out.print(".");

    }

    /**
     * Mètode d'instancia que indica el comportament quan un Huma mor.
     * Disminueix la població d'Huma i ja no forma part dels ciutadans (també
     * disminueix la població de Ciutada).
     */
    @Override
    public void morir(ArrayList<Ciutada> ciutadans) {
        //Redueix la població humana
        totalHumans--;
        //Redueix la població total
        Ciutada.setPoblacio(Ciutada.getPoblacio() - 1);
        //L'Huma mort deixa de formar part dels ciutadans
        ciutadans.remove(this);
    }

    /**
     * Mètode d'instancia que redueix la vida d'un Huma d'un en un i el mata si
     * la vida arriba a zero.
     */
    @Override
    public void envellir(ArrayList<Ciutada> ciutadans) {
        //Reducció de vida
        this.vida--;
        //Si la vida és 0 (o inferior) l'Huma mor
        if (this.vida <= 0) {
            this.morir(ciutadans);
            System.out.println(this.getNom() + " ha mort de vell.");
        }
    }

    /**
     * Mètode d'instancia que retorna la vulnerabilitat d'un Huma.
     *
     * @return Retorna la vulnerabilitat (VULNERABLE) d'un Huma.
     */
    public Vulnerable getVulnerable() {
        return this.VULNERABLE;
    }

    /**
     * Mètode d'instancia que sobreescriu el mètode toString de Ciutada.
     *
     * @return Retorna, a mes del nom, la vida restant i la vulnerabilitat de
     * l'Huma.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", vida: " + vida
                + ", vulnerabilitat: " + VULNERABLE;
    }

}
