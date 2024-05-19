package execucio;

import superclasses.Huma;
import classes_finals.Llop;
import classes_finals.Vampir;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import superclasses.Ciutada;

/**
 *
 * @author Roldán Sanchis Martínez
 *
 * Classe que desenvolupa tot el process. Representa l'ecosistema on viuen els
 * ciutadans.
 *
 * És la classe que executa el main i que implementa la lògica.
 */
public final class ElPobleDormit {

    //Llista (ArrayList) amb els ciutadans de l'ecosistema
    private static final ArrayList<Ciutada> ciutadans = new ArrayList<>();
    //Població mínima i màxima de l'ecosistema 
    public static final int MIN_POBLACIO = 3, MAX_POBLACIO = 20;
    //Objecte Random utilitzat per a generar números aleatoris.
    private static final Random ALEATORI = new Random();
    //Escàner per a recuperar les dades de la consola
    private static final Scanner entrada = new Scanner(System.in);

    //Tamany variable de la llista a recòrrer (és global per a accedir desde on toque dins de la classe ElPobleDormit i actualitzar-ho)
    private static int tamany;
    //Índex actual del Ciutada (és global per a accedir desde on toque dins de la classe ElPobleDormit i actualitzar-ho)
    private static int indexActual;

    /**
     * Mètode principal on s'executa el programa
     *
     * @param args Arguments del main.
     */
    public static void main(String[] args) {
        //Variable booleana que determina si el programa continua
        boolean continuar = true;

        //Comença generant una població aleatoria
        generarPoblacioAleatoria();

        //Informa al jugador dels ciutadans
        System.out.println("Població inicial: ");
        Ciutada.censar(ciutadans);

        //Avans de preguntar l'usuari, si tenim una població del mateix tipus, termina el programa
        verificarPoblacio();

        //Mentre l'usuaria no vullga eixir (continuar = true) i la població no siga tota del mateix tipus (verificarPoblacio() = false)
        do {
            //Mostra el menú d'opcions (i actualitza la variable continuar)
            continuar = mostrarMenu(continuar);

            //Després de cada iteració verifica la població
        } while (continuar && !verificarPoblacio());

        System.out.println("Fins aviat!");
    }

    /**
     * Mètode de classe que mostra el menú d'opcions i executa l'acció
     * corresponent segons l'opció triada.
     *
     * @return Retorna si l'usuari vol continuar o no:
     * <ul>
     * <li> true -> El programa continua. </li>
     * <li> false -> El programa termina. </li>
     * </ul>
     */
    private static boolean mostrarMenu(boolean continuar) {

        //Text del menú
        System.out.print("Menú:"
                + "\n1.Mostrar el cens actual."
                + "\n2.Passar un any."
                + "\n3.Eixir del programa."
                + "\nSelecciona una opció: ");

        //Tracta totes les excepcions que arriven a mostrarMenu()
        try {
            //Opció del menú seleccionada per l'usuari
            int opcio = entrada.nextInt();

            //Depenent de l'opció elegida realitza una acció
            switch (opcio) {
                case 1 -> {
                    System.out.println("Cens actual: ");
                    //Mostrar el cens actual
                    Ciutada.censar(ciutadans);
                }
                case 2 -> {
                    //Passar un any
                    passarAny();
                }
                case 3 -> {
                    //Eixir del programa
                    continuar = false;
                }
                default -> {
                    System.out.println("Opció incorrecta, tria una opció correcta.");
                }
            }

        } catch (InputMismatchException ime) {
            //Al introduir un valor no esperat el programa terminarà
            System.out.println("Opció incorrecta.");
            continuar = false;

        } catch (Exception e) {
            //Tractament de les excepcions esperades: mostra un text amb l'excepció
            System.out.println("Excepció -> " + e.toString());
        }

        return continuar;
    }

    /**
     * Mètode de classe que genera una població aleatoria de ciutadans i els
     * afig al llistat (ArrayList) de ciutadans.
     */
    private static void generarPoblacioAleatoria() {
        //Quantitat aleatoria de ciutadans (entre MIN_POBLACIO i MAX_POBLACIO, aquest inclòs)
        int numCiutadans = (ALEATORI.nextInt(MIN_POBLACIO - 1, MAX_POBLACIO) + 1);

        //Genera la quantitat aleatoria de ciutadans i els afegeix al llistat (ArrayList) de ciutadans
        for (int i = numCiutadans; i > 0; i--) {
            //Crea un nou Ciutada de manera aleatoria
            Ciutada nouCiutada = obtenirCiutadaAleatori();
            //Afig el Ciutada a ciutadans
            ciutadans.add(nouCiutada);
        }
    }

    /**
     * Mètode de classe que genera i retorna un Ciutada d'un tipus aleatori
     * (Huma, Llop o Vampir).
     *
     * @return Retorna el Ciutada generat de manera aleatoria.
     */
    private static Ciutada obtenirCiutadaAleatori() {
        //Genera un nombre aleatori entre 1 i 3 (les tres posibles opcions: 1-Humà, 2-Llop i 3-Vampir).
        int aleatori = (ALEATORI.nextInt(0, 3) + 1);
        //El Ciutada generat de manera aleatoria
        Ciutada ciutadaAleatori;

        //Depenent del nombre aleatori obtingut generarà un tipus de Ciutada o altre.
        switch (aleatori) {
            case 1 -> {
                //Genera un Huma
                ciutadaAleatori = new Huma("Huma");
            }
            case 2 -> {
                //Genera un Llop
                ciutadaAleatori = new Llop("Llop");
            }
            default -> {
                //Genera un Vampir
                ciutadaAleatori = new Vampir("Vampir");
            }
        }

        return ciutadaAleatori;
    }

    /**
     * Mètode de classe que simula el pas d'un any al poble.
     *
     * Cada ciutada realitza una acció.
     *
     * També s'actualitza la vida (edat) dels ciutadans que puguen envellir.
     */
    private static void passarAny() throws Exception {
        System.out.println("\nPassant un any...");

        try {
            //Instancia el tamany per a que només els ciutadans actuals realitzen acció (els fills tindran que esperar a l'any següent)
            ElPobleDormit.tamany = ciutadans.size();

            //Llança expeció si no hi ha ciutadans
            if (ElPobleDormit.tamany == 0) {
                //Si no hi ha ciutadans, llança l'excepció de tipus IllegalStateException
                throw new IllegalStateException("No hi ha ciutadans disponibles.");
            }
            //Recorre la llista de ciutadans
            for (ElPobleDormit.indexActual = 0; ElPobleDormit.indexActual < ElPobleDormit.tamany; ElPobleDormit.indexActual++) {
                //Ciutada actual
                Ciutada ciutadaActual = ciutadans.get(ElPobleDormit.indexActual);
                //Oponent aleatori del Ciutada actual (pot ser null)
                Ciutada oponent = obtindreOponentAleatori(ElPobleDormit.indexActual);

                //El Ciutada realitza una acció (necessita un altre Ciutada)
                realitzarAccio(ciutadaActual, oponent);
                System.out.println("");

                //Actualitza l'edat del ciutadaActual si pot envellir
                actualitzarEdat(ciutadaActual);
            }
        } catch (Exception e) {
            //Excepció de tipus Exception amb el missatge de l'excepció capturada
            throw new Exception("Error al passar l'any: " + e.getMessage());
        }
    }

    /**
     * Mètode de classe que retorna un oponent aleatori diferent del Ciutada amb
     * index actual dins de la llista de ciutadans.
     *
     * @return Oponent del Ciutada a la posició actual.
     */
    private static Ciutada obtindreOponentAleatori(int actual) throws IllegalStateException {
        //Variable de seguretat per a asegurar que el bucle termina
        int intent = 1;
        //Índex aleatori per a obtindre l'oponent aleatori
        int indexAleatori;
        //L'oponent aleatori
        Ciutada oponentAleatori;

        //Llança expeció si no queden oponents (només hi ha un Ciutada)
        if (ciutadans.size() == 1) {
            throw new IllegalStateException("No hi ha cap oponent disponible.");
        } else {

            /* Genera un nombre aleatori desde 0 fins al tamany de la llista de ciutadans 
            (l'últim Ciutada inclòs) que no siga igual al del Ciutada actual */
            do {
                indexAleatori = ALEATORI.nextInt(0, ciutadans.size());
                intent++;
            } while (indexAleatori == actual && intent < 100);

            //Obté l'oponent a la posició aleatoria de la llista de ciutadans
            oponentAleatori = ciutadans.get(indexAleatori);

            //Si no queden oponents disponibles, retornarà null
        }
        return indexAleatori == actual ? null : oponentAleatori;
    }

    /**
     * Mètode de classe que realitza una acció entre el ciutada1 i el ciutada2.
     *
     * En cas de ser de diferent espècie combatran, en cas contrari procrearan.
     */
    private static void realitzarAccio(Ciutada ciutada1, Ciutada ciutada2) throws IllegalArgumentException {
        //Llança expeció si un dels ciutadans és null
        if (ciutada1 == null || ciutada2 == null) {
            throw new IllegalArgumentException("Els oponents no poden ser null.");
        }
        if (ciutada1.getClass() != ciutada2.getClass()) {
            combatre(ciutada1, ciutada2);
        } else {
            procrear(ciutada1);
        }
    }

    /**
     * Mètode de classe que simula una batalla entre dos ciutadans.
     *
     * El perdedor morirà o, en cas de ser Huma es convertirà en Vampir.
     */
    private static void combatre(Ciutada ciutada1, Ciutada ciutada2) {
        //Per tal de saber qui mor, utilitze l'index
        int indexCiutada1 = ciutadans.indexOf(ciutada1);

        System.out.print(ciutada1.getNom() + " ataca " + ciutada2.getNom());
        //Perdedor del combat
        Ciutada perdedor = ciutada1.combat(ciutada2);
        //En cas de morir el Ciutada actual o un oponent amb un ídex menor, actualitzem el tamany a recòrrer i l'índex que recòrre la llista al mètode passarAny()
        if (ciutadans.indexOf(perdedor) < ElPobleDormit.tamany) {
            ElPobleDormit.tamany--;
            if (ciutadans.indexOf(perdedor) <= indexCiutada1) {
                ElPobleDormit.indexActual--;
            }
        }
        //El perdedor mor
        perdedor.morir(ciutadans);

        //En cas que el perdedor siga Huma l'oponent serà un Vampir
        if (perdedor.getClass() == Huma.class) {
            //Es crea un nou Vampir
            Vampir nouVampir = new Vampir("Vampir");
            System.out.print(nouVampir.getNom() + ".");

            //El nou Vampir s'afegix a la llista
            ciutadans.add(nouVampir);
        }

    }

    /**
     * Mètode de classe que simula la reproducció d'un Ciutada (Huma o Llop),
     * tenint en compe el límit de població màxima.
     */
    private static void procrear(Ciutada amant1) {
        //El tipus del ciutada actual (Huma, Llop o Vampir) en minúscules per a fer un switch.
        String tipusAmant1 = amant1.getClass().getSimpleName().toLowerCase();

        //Els vampirs no es reprodueixen
        if (tipusAmant1.equals("vampir")) {
            //Missatge que indica que un vampir no es pot reproduir
            System.out.print("Els vampirs no es reprodueixen: " + amant1.getNom() + ".");

        } else {
            if (Ciutada.getPoblacio() < MAX_POBLACIO) {
                switch (tipusAmant1) {
                    case "huma" -> {
                        //L'Huma es reprodueix com un Huma
                        ((Huma) amant1).reproduir(ciutadans);
                    }
                    //El Llop es reprodueix com un Llop
                    case "llop" -> {
                        ((Llop) amant1).reproduir(ciutadans);
                    }
                }
            } else {
                System.out.print(amant1.getNom() + " no s'ha pogut reproduir.");
            }
        }

    }

    /**
     * Mètode de classe que actualitza l'edat del Ciutada en cas de poder
     * envellir.
     */
    private static void actualitzarEdat(Ciutada ciutada) {
        //Asegura que el Ciutada està entre els ciutadans (no ha mort avans d'envellir) i que no es un Vampir (no envellisen)
        if (ciutadans.contains(ciutada) && ciutada.getClass() != Vampir.class) {
            //Envellis com un Huma
            if (ciutada.getClass() == Huma.class) {
                ((Huma) ciutada).envellir(ciutadans);

                //Envellis com un Llop
            } else {
                ((Llop) ciutada).envellir(ciutadans);
            }
            //En cas de morir el Ciutada de vell, també actualitzem el tamany i líndex global
            if (!ciutadans.contains(ciutada)) {
                ElPobleDormit.tamany--;
                ElPobleDormit.indexActual--;

            }
        }
    }

    /**
     * Mètode de classe que verifica si només queda un tipus de Ciutada.
     *
     * @return Retorna si la població és tota igual o no:
     *
     * <ul>
     * <li>true -> Només hi ha un tipus. Tota la poblaciió és del mateix tipus.
     * </li>
     * <li>false -> Hi ha més d'un tipus. La poblaciió no és tota del mateix
     * tipus. </li>
     * </ul>
     */
    private static boolean verificarPoblacio() {
        //Llança expeció si no hi ha ciutadans
        if (!ciutadans.isEmpty()) {
            //Utilitza el primer Ciutada com base i compara amb la resta
            Ciutada primerCiutada = ciutadans.get(0);

            //Recòrre la llista (ArrayList) de ciutadans
            for (int i = 0; i < ciutadans.size(); i++) {
                Ciutada actual = ciutadans.get(i);
                //Si algun Ciutada no és de la mateixa clase, no seràn tots de la mateixa clase
                if (primerCiutada.getClass() != actual.getClass()) {
                    return false;
                }
            }

            //En cas de comparar tots els ciutadans i no trobar un que siga d'altre tipus, són tots iguals
            System.out.println("Sols queda un tipus d'èsser viu al poble.");
        } else {
            //El cas més extrany (els dos últims ciutadans lliuten, queda un i mor de vell)
            System.out.println("No queden ciutadans.");
        }
        return true;
    }
}
