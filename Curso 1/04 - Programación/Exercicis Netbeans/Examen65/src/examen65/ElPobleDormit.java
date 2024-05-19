package examen65;

import ciutadansepd.Ciutada;
import ciutadansepd.Huma;
import ciutadansepd.Llop;
import ciutadansepd.Vampir;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.sql.Connection;
import utils.BdadesDelPoble;
import utils.ExcepcionsDelPoble;
import utils.FitxersDelPoble;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ElPobleDormit {

    private static final Random ALEATORI = new Random();
    private static final int POBLACIO_MINIMA = 10;
    private static final int POBLACIO_MAXIMA = 20;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static ArrayList<Ciutada> ciutadans = new ArrayList<>();

    private static int any = 0;

    private static Connection conexio;

    public static void main(String[] args) {
        generarPoblacioAleatoria();

        try {
            //TODO Connexio BD
            conexio = BdadesDelPoble.getConexion();

            while (mostrarMenu() && verificarPoblacio());
        } catch (ExcepcionsDelPoble e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println("S'ha produit una excepció i el programa acaba");
            ex.printStackTrace();
        }
        SCANNER.close();

    }

    private static boolean mostrarMenu() throws IOException, ExcepcionsDelPoble {

        boolean continuar = true;
        System.out.println("\nMenú:");
        System.out.println("1. Mostrar el cens actual");
        System.out.println("2. Passar un any");
        System.out.println("3. Guardar Partida");
        System.out.println("4. Carregar Partida");
        System.out.println("5. Eixir del programa");
        System.out.print("Selecciona una opció: ");

        int opcio = SCANNER.nextInt();

        switch (opcio) {
            case 1:

                System.out.println("\nCens actual:");
                Ciutada.censar(ciutadans, any);
                break;
            case 2:

                System.out.println("\nPassant un any...");
                try {
                    passarAny();
                    any++;
                    String s = Ciutada.poblacionsTotals(any);
                    //TODO Guardar en Fitxer - DONE
                    String linia = "L'any " + any 
                            + "hi ha un cens de: " + Ciutada.getPoblacio() + " ciutadans."
                            + "\n" + Huma.getPoblacio() + " humans, " 
                            + Llop.getPoblacio() + " llops i "
                            + Vampir.getPoblacio() + (VanHelsing.getPoblacio() == 1 ? " i Van Helsing" : "") + "\n";
                    FitxersDelPoble.escriureFitxer(linia);
                } catch (ExcepcionsDelPoble e) {
                    throw e;
                } catch (Exception ex) {
                    return false;
                }
                break;
            case 3:

            //TODO Guardar Partida
                BdadesDelPoble.guardarDades(ciutadans);
            case 4:

                //TODO Carregar Partida
                ciutadans = BdadesDelPoble.carregarDades(ciutadans);
                break;
            case 5:
                System.out.println("\nEixint del programa...");
                return false;
            default:
                System.out.println("\nOpció no válida. Per favor, selecciona una opció válida.");
        }
        return continuar;
    }

    private static void generarPoblacioAleatoria() {
        int tamanyPoblacio = ALEATORI.nextInt(POBLACIO_MAXIMA - POBLACIO_MINIMA + 1) + POBLACIO_MINIMA;
        for (int i = 0; i < tamanyPoblacio; i++) {
            ciutadans.add(obtenirCiutadaAleatori());
        }
    }

    private static Ciutada obtenirCiutadaAleatori() {
        return switch (ALEATORI.nextInt(3)) {
            case 0 ->
                new Vampir();
            case 1 ->
                new Llop();
            default ->
                new Huma();
        };
    }

    private static void passarAny() throws ExcepcionsDelPoble {
        try {
            if (ciutadans.isEmpty()) {
                throw new IllegalStateException("No hi ha ciutadans disponibles.");
            } else {
                for (int j = 0; j < ciutadans.size(); j++) {
                    Ciutada oponent1 = ciutadans.get(j);
                    Ciutada oponent2 = obtindreOponentAleatori(j);
                    realitzarAccio(oponent1, oponent2);
                    actualizarEdad(oponent1);
                }
            }
        } catch (ExcepcionsDelPoble e) {
            throw e;
        } catch (Exception ex) {
            throw new IllegalStateException("Error al passar l'any: " + ex.getStackTrace());
        }
    }

    private static Ciutada obtindreOponentAleatori(int actual) {
        int oponentAleatori;
        if (ciutadans.size() < 2) {
            throw new IllegalStateException("No hi ha cap oponent disponible.");
        }
        do {
            oponentAleatori = ALEATORI.nextInt(ciutadans.size());
        } while (oponentAleatori == actual);
        return ciutadans.get(oponentAleatori);
    }

    private static void realitzarAccio(Ciutada ciutada1, Ciutada ciutada2) throws ExcepcionsDelPoble {
        if (ciutada1 == null || ciutada2 == null) {
            throw new IllegalArgumentException("Els oponents no poden ser null.");
        }
        if (ciutada1.getClass().isInstance(ciutada2)) {
            procrear(ciutada1);
        } else {
            combatre(ciutada1, ciutada2);
        }
    }

    private static void combatre(Ciutada oponent1, Ciutada oponent2) throws ExcepcionsDelPoble {

        //TODO convertir en Van Helsing
        Ciutada perdedor = oponent1.combat(oponent2);
        perdedor.morir(ciutadans);
        System.out.println("POBLACIO CIU: " + Ciutada.getPoblacio());
        if (perdedor instanceof Huma) {
            if (Huma.getPoblacio() == 0) {
                System.out.println("(IF)POBLACIO CIU: " + Ciutada.getPoblacio());
                perdedor = new VanHelsing();
                ciutadans.add(perdedor);
                throw new ExcepcionsDelPoble("Oops! El vampir intenta convertir l'ultim humà, però este es convertirà en Van Helsing");
            } else {
                System.out.println("(ELSE)POBLACIO CIU: " + Huma.getPoblacio());
                perdedor = new Vampir();
                ciutadans.add(perdedor);
                System.out.println(perdedor.getNom() + ".");
            }

        }
    }

    private static void procrear(Ciutada amant1) {
        if (Ciutada.getPoblacio() < POBLACIO_MAXIMA) {
            switch (amant1.getClass().getSimpleName()) {
                case "Huma":
                    ((Huma) amant1).reproduir(ciutadans);
                    break;
                case "Llop":
                    ((Llop) amant1).reproduir(ciutadans);
                    break;
            }
        } else {
            System.out.println(amant1.getNom() + " no s'ha pogut reproduïr.");
        }
    }

    private static void actualizarEdad(Ciutada ciutada) {
        if (ciutadans.indexOf(ciutada) != -1) {
            if (ciutada instanceof Huma) {
                ((Huma) ciutada).envellir(ciutadans);
            } else if (ciutada instanceof Llop) {
                ((Llop) ciutada).envellir(ciutadans);
            }
        }
    }

    private static boolean verificarPoblacio() {

        //TODO comprovar Van Helsing
        int vanHelsings = VanHelsing.getPoblacio();
        int total = Ciutada.getPoblacio();
        int llops = Llop.getPoblacio();
        int humans = Huma.getPoblacio();
        int vampirs = Vampir.getPoblacio();
        if (total == llops || total == humans || total == vampirs || total == vanHelsings) {
            System.out.println("Sols queda un tipus d'esser al poble");
            return false;
        }

        return true;
    }
}
