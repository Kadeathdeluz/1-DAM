package exercicist6.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martí­nez
 */
public class ExercicisT6_ArrayList {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-5)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();
    }

    private static void exercici1() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> orderList = new ArrayList<String>();
        String order;
        int option;
        boolean exit = false;

        do {
            System.out.println("Elegeix una opció: "
                    + "\n1. Escriure comanda o producte."
                    + "\n2. Mostrar llista."
                    + "\n3. Eixir.");
            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Escriu una comanda o producte: ");
                    order = input.next();
                    order += input.nextLine();
                    orderList.add(order);
                }
                case 2 -> {
                    System.out.println(orderList.toString());
                }
                case 3 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Opció incorrecta, tria altra.");
                }
            }

        } while (!exit);

        input.close();
    }

    private static void exercici2() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> numbers = new ArrayList<String>();
        int option;
        String name, number;
        boolean exit = false;

        do {
            System.out.println("Elegeix una opció: "
                    + "\n1. Afegir contacte."
                    + "\n2. Mostrar llista."
                    + "\n3. Eixir.");
            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Afegeix un nom: ");
                    name = input.next();
                    names.add(name);

                    System.out.println("Afegeix un telèfon: ");
                    number = input.next();
                    numbers.add(number);
                }
                case 2 -> {
                    for (int i = 0; i < names.size(); i++) {
                        System.out.println("Nom: " + names.get(i) + ", telèfon: " + numbers.get(i));
                    }
                }
                case 3 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Opció incorrecta, tria altra.");
                }
            }
        } while (!exit);

        input.close();

    }

    private static void exercici3() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> intNumbs = new ArrayList<>();
        int evenTotal, num, count, option;
        boolean exit = false;
        
        do {
            evenTotal = 0;
            count = 0;
            
            System.out.println("Elegeix una opció: "
                    + "\n1. Afegir nombre."
                    + "\n2. Mostrar mitjana de les posicions parelles."
                    + "\n3. Eixir.");
            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Afegeix un nombre enter: ");
                    num = input.nextInt();
                    intNumbs.add(num);
                }
                case 2 -> {
                    System.out.println("Llista: " + intNumbs.toString());
                    
                    for (int i = 0; i < intNumbs.size(); i+=2) {
                        evenTotal += intNumbs.get(i);
                        count++;
                    }
                    System.out.println("Mitjana de les posicions parelles: " + ((float) evenTotal/count) );
                    
                }
                case 3 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Opció incorrecta, tria altra.");
                }
            }
        
        }while(!exit);
        
        
        input.close();
    }

    private static void exercici4() {

    }

    private static void exercici5() {

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
            case 5 ->
                exercici5();
            default ->
                System.out.println("Exercici fora de rang!");
        }
    }
}
