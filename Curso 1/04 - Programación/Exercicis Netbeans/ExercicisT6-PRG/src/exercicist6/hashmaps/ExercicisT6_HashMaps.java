package exercicist6.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martí­nez
 */
public class ExercicisT6_HashMaps {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-4)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();
        System.exit(0);
    }

    private static void exercici1() {
        HashMap<String, String> scores = new HashMap<String, String>();
        Scanner input = new Scanner(System.in);
        String player, score;
        boolean exit = false;
        int option;

        do {
            System.out.println("Selecciona una opció: "
                    + "\n1. Afegir jugador i puntuació."
                    + "\n2. Mostrar puntuació d'un jugador."
                    + "\n3. Eixir.");
            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.print("Introdueix jugador: ");
                    player = input.next();

                    System.out.print("Introdueix puntuació: ");
                    score = input.next();

                    if (scores.get(player) == null) {
                        scores.put(player, score);
                    } else {
                        scores.replace(player, score);
                    }
                }
                case 2 -> {
                    System.out.println("Introdueix jugador: ");
                    player = input.next();

                    score = scores.get(player);
                    if (score != null) {
                        System.out.println("Puntuació del jugador (" + player + "): " + score);
                    } else {
                        System.out.println("Jugador no trobat o sense puntuació.");
                    }
                }
                case 3 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("ERROR, try again.");
                    continue;
                }
            }

            //Clean buffer
            input.nextLine();
        } while (!exit);

        input.close();
    }

    private static void exercici2() {
        Scanner input = new Scanner(System.in);

        HashMap<String, String> words = new HashMap<String, String>();
        String english, spanish;
        boolean exit = false;
        int option;

        do {
            System.out.println("Selecciona una opció: "
                    + "\n1. Afegir paraula i traducció."
                    + "\n2. Mostrar traducció d'una paraula."
                    + "\n3. Eixir.");
            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.print("Introdueix una paraula en anglés: ");
                    english = input.next();

                    System.out.print("Introdueix la seua traducció: ");
                    spanish = input.next();

                    if (words.get(english) == null) {
                        words.put(english, spanish);
                    } else {
                        System.out.println("Ja existeix, vols reemplaçar els valors?(S/N): ");
                        if (input.next().equalsIgnoreCase("s")) {
                            words.replace(english, spanish);
                        }
                        words.replace(english, spanish);
                    }
                }
                case 2 -> {
                    System.out.println("Introdueix una paraula per a mostrar la traducció: ");
                    english = input.next();

                    spanish = words.get(english);
                    if (spanish != null) {
                        System.out.println("Anglés: " + english + "/ espanyol: " + spanish);
                    } else {
                        System.out.println("Paraula no registrada o sense traducció.");
                    }
                }
                case 3 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Opció no válida, try again.");
                    continue;
                }
            }

            //Clean buffer
            input.nextLine();
        } while (!exit);

        input.close();

    }

    private static void exercici3() {
        Scanner input = new Scanner(System.in);

        boolean exit = false;
        String name;
        float price, total;
        int quantity, option;
        HashMap<String, ArrayList<Float>> stock = new HashMap<String, ArrayList<Float>>();
        ArrayList<Float> priceAndQuantity;

        do {
            System.out.println("Tria una opció:"
                    + "\n1. Afegir nou producte."
                    + "\n2. Mostrar producte."
                    + "\n3. Mostrar inventari."
                    + "\n4. Eixir");

            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.print("Introdueix un nom per al producte: ");
                    name = input.next();

                    System.out.print("Introdueix un preu per al producte: ");
                    price = input.nextFloat();

                    System.out.print("Introdueix una quantitat per al producte: ");
                    quantity = input.nextInt();

                    priceAndQuantity = new ArrayList<Float>();
                    priceAndQuantity.add(0, price);
                    priceAndQuantity.add(1, (float) quantity);

                    if (stock.get(name) == null) {
                        stock.put(name, priceAndQuantity);
                    } else {
                        System.out.print("Ja existeix, vols reemplaçar els valors?(S/N): ");
                        if (input.next().equalsIgnoreCase("s")) {
                            stock.replace(name, priceAndQuantity);
                            System.out.println("Canvi registrat!");
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Introdueix un producte per a mostrar: ");
                    name = input.next();

                    priceAndQuantity = stock.get(name);
                    if (priceAndQuantity != null) {
                        price = priceAndQuantity.get(0);
                        quantity = Math.round(priceAndQuantity.get(1));
                        total = price * quantity;

                        System.out.println("Preu: " + price
                                + "\nQuantitat: " + quantity
                                + "\nTotal: " + total);
                    } else {
                        System.out.println("Producte no registrat.");
                    }
                }
                case 3 -> {
                    if (!stock.keySet().isEmpty()) {
                        System.out.println("|---------- INVENTARI ----------|");
                        System.out.println("|----------   INICI   ----------|");
                        for (String key : stock.keySet()) {
                            priceAndQuantity = stock.get(key);
                            price = priceAndQuantity.get(0);
                            quantity = Math.round(priceAndQuantity.get(1));
                            total = price * quantity;

                            System.out.println("Producte: " + key
                                    + "\nQuantitat: " + quantity
                                    + "\nTotal: " + total);
                            System.out.println("");
                        }
                        
                        System.out.println("|----------   FINAL   ----------|");                        
                    }
                    else
                        System.out.println("Inventari buit");
                }
                case 4 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Opció no válida, try again.");
                    continue;
                }
            }
        } while (!exit);

        input.close();
    }

    /** Solució del exercicis resolts */
    private static void exercici4() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> preus = new HashMap<>();
        HashMap<String, Double> despeses = new HashMap<>();

        while (true) {
            System.out.println("1. Afegir Despesa");
            System.out.println("2. Mostrar Despeses");
            System.out.println("3. Sortir");

            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("Introdueix la categoria de la despesa:");
                    String categoria = scanner.next();
                    System.out.println("Introdueix el preu unitari:");
                    double preuUnitari = scanner.nextDouble();
                    preus.put(categoria, preuUnitari);
                    System.out.println("Introdueix la quantitat gastada:");
                    double quantitat = scanner.nextDouble();
                    if (despeses.containsKey(categoria)) {
                        despeses.put(categoria, despeses.get(categoria) + quantitat);
                    } else {
                        despeses.put(categoria, quantitat);
                    }
                    break;
                case 2:
                    System.out.println("Despeses:");
                    for (String categoriaDespesa : despeses.keySet()) {
                        double quantitatDespesa = despeses.get(categoriaDespesa);
                        double preuUnitariDespesa = preus.get(categoriaDespesa);
                        double total = quantitatDespesa * preuUnitariDespesa;
                        System.out.println(categoriaDespesa + ": " + "Quantitat: " + quantitatDespesa +
                                ", Preu Unitari: " + preuUnitariDespesa + ", Total: " + total);
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opció no vàlida");
            }
        }
    }

    private static void printAux(int i) {
        System.out.println("Exercici " + i + ": ");
    }

    private static void chooseExercici(int num) {
        switch (num) {
            case 1 ->
                exercici1();
            case 2 ->
                exercici2();
            case 3 ->
                exercici3();
            case 4 ->
                exercici4();
            default ->
                System.out.println("Exercici fora de rang!");
        }
    }
}
