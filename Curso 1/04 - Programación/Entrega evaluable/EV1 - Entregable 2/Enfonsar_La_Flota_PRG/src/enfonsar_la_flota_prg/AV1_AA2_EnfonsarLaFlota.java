package enfonsar_la_flota_prg;

import java.util.Scanner;

/**
 * @author Roldán Sanchis Martínez
 */
public class AV1_AA2_EnfonsarLaFlota {

    //Com les files i les columnes son sempre 10, es declaren com variables de tipus final
    static final int FILES = 10, COLUMNES = 10;
    //Definim els textos per a les dificultats
    static final String FACIL = "===== DIFICULTAT: FACIL =====", MITJANA = "===== DIFICULTAT: MITJANA =====", DIFICIL = "===== DIFICULTAT: DIFÍCIL =====";

    /**
     * PROCEDIMENT: Mètode principal que crida al métode que mostra el menú i a
     * jugar partida.
     *
     * @param args: Arguments del mètode main.
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String text;
        int opcioCorrecta, min = 1, max = 3, llanxes = 0, vaixells = 0, cuirassats = 0, portaavions = 0, max_intents = 0;

        mostrar_menu();
        text = entrada.nextLine();

        /*Com no és una bona pràctica que un mètode faça més del que descriu, 
        la cridada a demana_dades es trasllada al main. També per comoditat al tractar les dades.
         */
        opcioCorrecta = demana_dades_entre_max_i_min(text, min, max);

        switch (opcioCorrecta) {
            case 1 -> {
                llanxes = 5;
                vaixells = 3;
                cuirassats = 1;
                portaavions = 1;
                max_intents = 50;
            }
            case 2 -> {
                llanxes = 2;
                vaixells = 1;
                cuirassats = 1;
                portaavions = 1;
                max_intents = 30;

            }
            case 3 -> {
                llanxes = 1;
                vaixells = 1;
                max_intents = 10;
            }
            default -> {
                System.out.println("Error inesperat, abortant...");
                System.exit(0);
            }
        }

        jugar_partida(FILES, COLUMNES, llanxes, vaixells, cuirassats, portaavions, max_intents);

        entrada.close();
    }

    /**
     * PROCEDIMENT: Mètode que mostra el menú d'opcions.
     */
    public static void mostrar_menu() {
        System.out.println("===== BENVINGUTS A AFONAR LA FLOTA =====\n"
                + "Nivells de dificultat:\n"
                + "1. Fàcil: 5 llanxes, 3 vaixells, 1 cuirassat i 1 portaavions (50 trets).\n"
                + "2. Mitjà: 2 llanxes, 1 vaixell, 1 cuirassat i 1 portaavions (30 trets).\n"
                + "3. Difícil: 1 llanxa y 1 vaixell (10 trets).\n"
                + "Quin nivell tries?");
    }

    /**
     * FUNCIÓ: Mètode que demana les dades introduïdes per l'usuari i valida que
     * són correctes. Serveix per a la dificultat i els trets.
     *
     * @param text: Opció introduïda per l'usuari (opció de menú o posició del
     * tauler)
     * @param min: Mínim valor correcte.
     * @param max: Màxim valor correcte.
     * @return : Opció vàlida (entre min i max).
     */
    public static int demana_dades_entre_max_i_min(String text, int min, int max) {
        Scanner entrada = new Scanner(System.in);
        int opcio = 0;
        boolean esCorrecta = false;

        do {
            //En cas de que el text introduït no siga el desitjat
            if (text.length() > 1 || text.length() == 0) {
                //Eixida d'emergència
                if (text.toLowerCase().compareTo("exit") == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Opció incorrecta, tria una vàlida.");
                    text = entrada.nextLine();
                }
            } else if (text.length() == 1) {
                //Depenent de si es tracta de un nombre o un caracter el tracta d'una manera o d'altra
                try {
                    opcio = Integer.parseInt(text);
                } catch (Exception e) {
                    opcio = text.toUpperCase().charAt(0);
                }

                if (min <= opcio && opcio <= max) {
                    esCorrecta = true;
                } else {
                    System.out.println("Opció incorrecta, tria una vàlida.");
                    text = entrada.nextLine();
                }
            }
        } while (!esCorrecta);

        return opcio;
    }

    /**
     * PROCEDIMENT: Mètode que inicia la partida amb els paràmetres triats. Fa
     * les cridades a la resta de mètodes i, finalment, termina la partida.
     *
     * @param files : Files del tauler.
     * @param columnes : Columnes del tauler.
     * @param llanxes : Nombre de llanxes que s'han d'inserir al tauler.
     * @param vaixells : Nombre de vaixells que s'han d'inserir al tauler.
     * @param cuirassats : Nombre de cuirassats que s'han d'inserir al tauler.
     * @param portaavions : Nombre de portaavions que s'han d'inserir al tauler.
     * @param max_intents : Nombre de trets abans de terminar el joc.
     */
    public static void jugar_partida(int files, int columnes, int llanxes, int vaixells,
            int cuirassats, int portaavions, int max_intents) {
        //Tindrem max_intents trets fins terminar la partida
        int tretsRestants = max_intents;
        boolean veureTot = false;
        char[][] tauler = crear_tauler(files, columnes);
        int[] tret;

        inserir_barcos(tauler, llanxes, vaixells, cuirassats, portaavions);

        System.out.println("===== BENVINGUTS A AFONAR LA FLOTA =====");
        //Indica la dificultat selecionada mitjançant l'operador ternari
        System.out.println(max_intents == 50 ? FACIL : max_intents == 30 ? MITJANA : DIFICIL);
        //Mostra un text simulant l'inici de la partida
        mostrarTextDeCarrega();

        //El joc es desenvolupa dins del següent while (mentre queden trets i barcos).
        while (tretsRestants > 0 && queden_barcos(tauler)) {
            mostra_tauler(tauler, veureTot);
            System.out.println("Queden " + tretsRestants + " trets restants.");

            tret = demana_coordenades_tret(tauler);
            //tret[0] és la fila i tret[1] és la columna.
            processa_tret(tauler, tret[0], tret[1]);

            //Després de cada tret, queda un tret menys
            tretsRestants--;
        }
        //Quan terminen els intents es mostra el tauler final
        veureTot = true;
        mostra_tauler(tauler, veureTot);

        if (queden_barcos(tauler)) {
            System.out.println("===== HAS PERDUT =====");
            System.out.println("Llàstima, provaràs altra vegada?");
        } else {
            System.out.println("===== HAS GUANYAT =====");
            System.out.println("Molt bé, has afonat la flota!");
        }

    }

    /**
     * PROCEDIMENT AUXILIAR: Mètode que fa esperar 1 segon el fil actual i així
     * simular que es fa alguna tasca.
     *
     * @param segons : quantitat de segons que espera el fil.
     *
     */
    private static void simularTarea(int segons) {
        try {
            Thread.sleep(segons * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * PROCEDIMENT AUXILIAR: Mètode que mostra un text per a simular l'inici de
     * la partida.
     *
     */
    private static void mostrarTextDeCarrega() {
        System.out.println("Preparant-ho tot...");
        //NOTA: Codi no demanat, eliminar si dona problemes - descripció al mètode.
        simularTarea(2);

        System.out.println("Creant tauler...");
        //NOTA: Codi no demanat, eliminar si dona problemes - descripció al mètode.
        simularTarea(1);

        System.out.println("Inserint barcos...");
        //NOTA: Codi no demanat, eliminar si dona problemes - descripció al mètode.
        simularTarea(3);

        System.out.println("Comencem!");
    }

    /**
     * FUNCIÓ: Mètode que crea un tauler buit amb "-" en totes les posicions.
     *
     * @param files: Nombre de files del tauler.
     * @param columnes: Nombre de columnes del tauler.
     * @return : Tauler (ple de "-") de tamany 'files' X 'columnes'.
     */
    public static char[][] crear_tauler(int files, int columnes) {
        char[][] tauler = new char[files][columnes];

        for (char[] fila : tauler) {
            for (int j = 0; j < fila.length; j++) {
                fila[j] = '-';
            }
        }
        return tauler;
    }

    /**
     * PROCEDIMENT: Mètode que mostra per pantalla el tauler. Mostra les files
     * de manera recursiva cridant a mostra_fila.
     *
     * @param tauler: El tauler actual.
     * @param veureTot: Selecciona quin tauler es mostra: l'actual o el final.
     *
     */
    public static void mostra_tauler(char[][] tauler, boolean veureTot) {
        int a = 'A'; //'A' en ASCII (el número 65)
        
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        
        for (int i = 0; i < tauler.length; i++) {
            //printea la lletra que toca per cada fila
            System.out.print((char) a); 
            mostra_fila(tauler, i, 0, veureTot);
            a++;
            System.out.println("");
        }
    }

    /**
     * PROCEDIMENT RECURSIU: Mètode que mostra per pantalla cadascuna de les
     * files de la matriu de manera recursiva.
     *
     * @param tauler: El tauler actual.
     * @param i: Posició de la fila actual.
     * @param j: Posició de la columna actual.
     * @param mT: Selecciona quin tauler es mostra: l'actual o el final.
     *
     */
    private static void mostra_fila(char[][] tauler, int i, int j, boolean mT) {
        //Si no ha arribat al final de la columna, segueïx fen cridades a mostra_fila avançant 1 casella en la columna
        if (j < tauler[i].length) {
            if (!mT) {
                switch (tauler[i][j]) {
                    case 'X' ->
                        System.out.print(" X");
                    case 'A' ->
                        System.out.print(" A");
                    case '-', 'L', 'B', 'Z', 'P' ->
                        System.out.print(" -");
                }
            } else {
                System.out.print(" " + tauler[i][j]);
            }

            mostra_fila(tauler, i, j + 1, mT);
        }
        //En cas contrari no fa res perquè ha terminat la eixa fila
    }

    /**
     * PROCEDIMENT: Mètode que insereix els barcos en posicions aleatòries. Per
     * cada barco crida al mètode inserir_barco.
     *
     * @param tauler : Tauler actual.
     * @param llanxes : Nombre de llanxes a inserir al tauler.
     * @param vaixells : Nombre de vaixells a inserir al tauler.
     * @param cuirassats : Nombre de cuirassats a inserir al tauler.
     * @param portaavions : Nombre de portaavions a inserir al tauler.
     */
    public static void inserir_barcos(char[][] tauler, int llanxes, int vaixells, int cuirassats, int portaavions) {

        for (int i = 0; i < portaavions; i++) {
            inserir_barco(tauler, 5, 'P');
        }
        for (int i = 0; i < cuirassats; i++) {
            inserir_barco(tauler, 4, 'Z');
        }
        for (int i = 0; i < vaixells; i++) {
            inserir_barco(tauler, 3, 'B');
        }
        for (int i = 0; i < llanxes; i++) {
            inserir_barco(tauler, 5, 'L');
        }
    }

    /**
     * FUNCIÓ: Mètode que insereix un barco en una posició aleatoria en cas de
     * ser possible (es comprova amb es_pot_inserir_barco).
     *
     * @param tauler : Tauler actual.
     * @param tamany : Tamany del barco a inserir.
     * @param lletra : Lletra del barco a inserir. P.e. 'L' per a llanxa.
     * @return : En cas de inserir un barco, retorna true. En cas contrari,
     * false.
     *
     */
    public static boolean inserir_barco(char[][] tauler, int tamany, char lletra) {
        int[] coordenada;
        int f, c, intent = 0;

        //Fa 100 intents com a màxim per barco 
        do {
            coordenada = coordenada_aleatoria(tauler, tamany);
            f = coordenada[0];
            c = coordenada[1];

            if (es_pot_inserir_barco(tauler, tamany, f, c)) {
                for (int i = 0; i < tamany; i++) {
                    tauler[f][c + i] = lletra;
                }
                return true;
            }
            intent++;
        } while (!es_pot_inserir_barco(tauler, tamany, f, c) && intent < 100);
        System.out.println("ERROR: No s'ha pogut inserir el barco.");
        return false;
    }

    /**
     * FUNCIÓ: Mètode que comprova si es pot inserir un barco al tauler.
     *
     * @param tauler : Tauler actual.
     * @param tamany : Tamany del barco a inserir.
     * @param f : Fila de la coordenada origen del barco a inserir.
     * @param c : Columna de la coordenada origen del barco a inserir.
     * @return : Si es pot inserir retorna true, en cas contrari false.
     */
    public static boolean es_pot_inserir_barco(char[][] tauler, int tamany, int f, int c) {
        int espaiDisponible = 0;

        for (int i = 0; i < tamany; i++) {
            if (tauler[f][c + i] == '-') {
                espaiDisponible++;
            }
        }
        return espaiDisponible == tamany;
    }

    /**
     * FUNCIÓ: Mètode que demana les coordenades de tret.
     *
     * @param tauler : Tauler actual.
     * @return : Coordenades del tret (quan siguen vàlides).
     *
     */
    public static int[] demana_coordenades_tret(char[][] tauler) {
        Scanner entrada = new Scanner(System.in);
        int[] tret = new int[2];
        String fila, columna;

        System.out.println("Indica la fila del tret(A-J): ");
        fila = entrada.nextLine();
        //Fa el casting de char a int ('A' = 65), hem de restar el 65 per a obtindre una coordenada (0-9)
        tret[0] = demana_dades_entre_max_i_min(fila, (int) 'A', (int) 'J') - (int) 'A';

        System.out.println("Indica la columna del tret (0-9): ");
        columna = entrada.nextLine();
        tret[1] = demana_dades_entre_max_i_min(columna.toUpperCase(), 0, 9);

        return tret;
    }

    /**
     * PROCEDIMENT: Mètode que processa el tret am les coordenades indicades.
     *
     * @param tauler : Tauler sobre el que es processa el tret
     * @param f : Fila del tret.
     * @param c : Columna del tret.
     *
     */
    public static void processa_tret(char[][] tauler, int f, int c) {
        int tret = tauler[f][c];

        switch (tret) {
            case '-' -> {
                System.out.println("Aigua!");
                tauler[f][c] = 'A';
            }
            case 'L', 'B', 'Z', 'P' -> {
                System.out.println("Tocat!");
                tauler[f][c] = 'X';
            }
            default ->
                System.out.println("Error! ja hi havies fet un tret açí");
        }
        /*Retarda 1 segon l'eixida del mètode i per tant, la visualizació del tauler
        per tal de llegir bé el resultat.*/
        simularTarea(1);

    }

    /**
     * FUNCIÓ: Mètode que rep el tauler i les dimensions de l'objecte i ens
     * retorna una posició aleatòria.
     *
     * @param tauler : Tauler actual.
     * @param mida : Dimensions de l'objecte.
     * @return : Posició aleatoria que és l'inicial de l'objecte.
     *
     */
    public static int[] coordenada_aleatoria(char[][] tauler, int mida) {
        int[] coordenada = new int[2]; //Coordenada que retornà el mètode

        coordenada[0] = (int) (Math.random() * (10));
        coordenada[1] = (int) (Math.random() * (10 - mida + 1));

        return coordenada;
    }

    /**
     * FUNCIÓ: Mètode que comprova si queden barcos al tauler.
     *
     * @param tauler : Tauler a comprovar.
     * @return : En cas de quedar barcos retorna true, en cas contrari false.
     */
    public static boolean queden_barcos(char[][] tauler) {
        for (char[] fila : tauler) {
            for (int i = 0; i < fila.length; i++) {
                //Si encara queda algún tipus de barco retorna true
                if (fila[i] == 'L' || fila[i] == 'B' || fila[i] == 'Z' || fila[i] == 'P') {
                    return true;
                }
            }
        }
        //Si després de recorre el tauler no trova cap barco retorna false
        return false;
    }
}
