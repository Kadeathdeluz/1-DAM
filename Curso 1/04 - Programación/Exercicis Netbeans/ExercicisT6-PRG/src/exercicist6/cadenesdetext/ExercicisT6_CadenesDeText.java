package exercicist6.cadenesdetext;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Rold√°n Sanchis Mart√≠nez
 */
public class ExercicisT6_CadenesDeText {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-5)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();

        printAux(num);
        chooseExercici(num);

        input.close();
    }

    private static void exercici1() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escriu una cadena de text: ");
        String text = input.nextLine();

        for (int i = 0; i < text.length(); i++) {
            System.out.println(text.charAt(i));
        }

        input.close();
    }

    private static void exercici2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escriu una cadena de text: ");
        String text1 = input.nextLine();

        System.out.println("Escriu una cadena de text: ");
        String text2 = input.nextLine();

        if (text1.compareTo(text2) == 0) {
            System.out.println("S√≥n completament iguals.");
        } else if (text1.compareToIgnoreCase(text2) == 0) {
            System.out.println("S√≥n iguals sense diferenciar entre maj√∫scules i min√∫scules.");
        } else {
            System.out.println("No s√≥n iguals.");
        }

        input.close();
    }

    private static void exercici3() {
        String result = "";

        Scanner input = new Scanner(System.in);
        System.out.println("Escriu un nom: ");
        String name = input.nextLine();

        System.out.println("Escriu el primer cognom: ");
        String surname1 = input.nextLine();

        System.out.println("Escriu el segon cognom: ");
        String surname2 = input.nextLine();

        for (int i = 0; i < 3; i++) {
            result += name.charAt(i);
        }
        for (int i = 0; i < 3; i++) {
            result += surname1.charAt(i);
        }
        for (int i = 0; i < 3; i++) {
            result += surname2.charAt(i);
        }

        System.out.println(result.toUpperCase());
        input.close();
    }

    private static void exercici4() {
        Scanner input = new Scanner(System.in);

        HashMap<Character, Integer> vowels = new HashMap<Character, Integer>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);

        String phrase = input.nextLine().toLowerCase();

        for (int i = 0; i < phrase.length(); i++) {
            char currentChar = phrase.charAt(i);
            if (vowels.containsKey(currentChar)) {
                int currentValue = vowels.get(currentChar);
                int nextValue = currentValue + 1;
                vowels.replace(currentChar, currentValue, nextValue);
            }
        }
        for (char character : vowels.keySet()) {
            System.out.println("N˙m de " + (character + "").toUpperCase() + "s: " + vowels.get(character));
        }
        input.close();
    }

    private static void exercici5() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix una frase per saber si es un palÌndrom o no: ");
        String phrase = input.nextLine().toLowerCase().replaceAll(" ", "");
        
        String firstHalf = phrase.substring(0, phrase.length() / 2);
        String secondHalf;

        if (phrase.length() % 2 == 0) {
            secondHalf = phrase.substring(phrase.length() / 2);

        } else {
            secondHalf = phrase.substring(phrase.length() / 2 + 1);
        }

        String reversedHalf = "";

        for (int i = secondHalf.length() - 1; i >= 0; i--) {
            reversedHalf += secondHalf.charAt(i);
        }
        if (firstHalf.equals(reversedHalf)) {
            System.out.println("…s un palÌndrom.");
        } else {
            System.out.println("No Ès un palÌndrom.");
        }
        input.close();
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
