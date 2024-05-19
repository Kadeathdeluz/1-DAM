package Ampliacio;

import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_Ampliacio {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Aparcament aparcament = new Aparcament();
        int resposta;

        do {
            mostrarMenu();

            resposta = entrada.nextInt();
            resposta = validaResposta(resposta);

            switch (resposta) {
                case 0 ->
                    System.out.println("Adeu!");
                case 1 ->
                    entrar(aparcament, entrada);
                case 2 ->
                    eixir(aparcament, entrada);
                case 3 ->
                    estatPlaça(aparcament, entrada);
                case 4 ->
                    estatAparcament(aparcament);
                default ->
                    System.err.println("ERROR DESCONEGUT");
            }
        } while (resposta != 0);
        
        entrada.close();
    }

    public static void mostrarMenu() {
        System.out.println("========= MENÚ APARCAMENT ========\n"
                + "1.- Entrada de vehicle\n"
                + "2.- Eixida de vehicle\n"
                + "3.- Estat d'una plaça\n"
                + "4.- Estat de l’aparcament\n"
                + "0.- Finalitzar\n"
                + "Introdueix una opció: ");
    }

    private static int validaResposta(int resposta) {
        Scanner entrada = new Scanner(System.in);

        while (resposta > 4 || resposta < 0) {
            System.out.println("ERROR: Tria una resposta correcta");
            mostrarMenu();

            resposta = entrada.nextInt();
        }
        return resposta;
    }

    private static void entrar(Aparcament aparcament, Scanner entrada) {
        System.out.print("Introdueix la matrícula: ");
        entrada.nextLine();
        String matricula = entrada.nextLine();

        aparcament.entrar(matricula);

    }

    private static void eixir(Aparcament aparcament, Scanner entrada) {
        System.out.print("Introdueix el número de la plaça(1-20): ");
        int plaça = entrada.nextInt();

        aparcament.eixir(plaça - 1);
    }

    private static void estatPlaça(Aparcament aparcament, Scanner entrada) {
        System.out.print("Introdueix el número de la plaça a consultar: ");
        int numPlaça = entrada.nextInt();

        aparcament.estatPlaça(numPlaça);
    }

    private static void estatAparcament(Aparcament aparcament) {
        for (Plaça plaça : aparcament.getPlaces()) {
            System.out.println(plaça.toString());
        }
    }
}
