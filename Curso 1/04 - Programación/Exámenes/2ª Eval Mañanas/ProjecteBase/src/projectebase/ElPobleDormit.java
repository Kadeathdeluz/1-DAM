package projectebase;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import utils.BdadesDelPoble;
import java.sql.*;

/**
 * @author Roldán Sanchis Martínez
 */
public class ElPobleDormit {

    private static final Random ALEATORI = new Random();
    private static final int POBLACIO_MINIMA = 10;
    private static final int POBLACIO_MAXIMA = 20;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static ArrayList<Ciutada> ciutadans = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Connection conexio = BdadesDelPoble.getConnexio();
            generarPoblacioAleatoria();

            System.out.println("Població inicial: ");
            Ciutada.censar(ciutadans);

            boolean continuar = true;
            do {
                if (continuar) {
                    continuar = mostrarMenu(continuar);
                }
                continuar = verificarPoblacio();
            } while (continuar);
            SCANNER.close();
            //Tanque la conexió
            conexio.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean mostrarMenu(boolean continuar) {
        System.out.println("\nMenú:");
        System.out.println("1. Mostrar el cens actual");
        System.out.println("2. Passar un any");
        System.out.println("3. Eixir del programa");
        System.out.print("Selecciona una opció: ");

        int opcio = SCANNER.nextInt();

        switch (opcio) {
            case 1:
                System.out.println("\nCens actual:");
                Ciutada.censar(ciutadans);
                break;
            case 2:
                System.out.println("\nPassant un any...");
                try {
                    passarAny();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
                Ciutada.poblacionsTotals();
                break;
            case 3:
                System.out.println("\nEixint del programa...");
                return false;
            default:
                System.out.println("Opció no válida. Per favor, selecciona una opció válida.");
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
        switch (ALEATORI.nextInt(3)) {
            case 0:
                return new Vampir();
            case 1:
                return new Llop();
            default:
                return new Huma();
        }
    }

    private static void passarAny() {
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
        } catch (Exception ex) {
            throw new IllegalStateException("Error al passar l'any: " + ex.getMessage());
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

    private static void realitzarAccio(Ciutada ciutada1, Ciutada ciutada2) {
        if (ciutada1 == null || ciutada2 == null) {
            throw new IllegalArgumentException("Els oponents no poden ser null.");
        }
        if (ciutada1.getClass().isInstance(ciutada2)) {
            procrear(ciutada1);
        } else {
            combatre(ciutada1, ciutada2);
        }
    }

    private static void combatre(Ciutada oponent1, Ciutada oponent2) {
        Ciutada perdedor = oponent1.combat(oponent2);
        perdedor.morir(ciutadans);
        if (perdedor instanceof Huma) {
            Vampir convertit = new Vampir();
            ciutadans.add(convertit);
            System.out.println(convertit.getNom() + ".");
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
        int total = Ciutada.getPoblacio();
        int llops = Llop.getPoblacio();
        int humans = Huma.getPoblacio();
        int vampirs = Vampir.getPoblacio();
        int mestisos = Mestis.getPoblacio();
        
        if (total == llops || total == humans || total == vampirs || total == mestisos) {
            System.out.println("Sols queda un tipus de essers en el poble");
            return false;
        }
        return true;
    }
}
