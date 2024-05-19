package exercicist6.vectors;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Rold�n Sanchis Mart��nez
 */
public class ExercicisT6_Vectors {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-20)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();
    }

    private static void exercici1() {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Introdueix un nombre que será l'element [" + i + "]: ");
            array[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(array));
        input.close();
    }

    private static void exercici2() {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Introdueix un nombreque será l'element [" + i + "]: ");
            array[i] = input.nextInt();
        }
        int result = 0;
        for (int element : array) {
            result += element;
        }
        System.out.println("Suma dels nombres: " + result);
        input.close();
    }

    private static void exercici3() {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        int min, max;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Introdueix un nombreque será l'element [" + i + "]: ");
            array[i] = input.nextInt();
        }

        min = max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("MIN: " + min + "\nMAX: " + max);
        input.close();

    }

    private static void exercici4() {
        Scanner input = new Scanner(System.in);
        int[] array = new int[20];
        int positives = 0, negatives = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Introdueix un nombreque será l'element [" + i + "]: ");
            array[i] = input.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                positives += array[i];
            } else {
                negatives += array[i];
            }
        }
        System.out.println("Sumatori(pos): " + positives + "\nSumatori (neg): " + negatives);
        input.close();
    }

    private static void exercici5() {
        Scanner input = new Scanner(System.in);
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Introdueix un nombreque será l'element [" + i + "]: ");
            array[i] = input.nextInt();
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        System.out.println("Mitjana: " + (sum / array.length));
        input.close();
    }

    private static void exercici6() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix el tamany N del array: ");
        int n = input.nextInt();

        System.out.println("Introdueix el nombre M: ");
        int m = input.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = m;
        }

        System.out.println(Arrays.toString(array));
        input.close();
    }

    private static void exercici7() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix un nombre (P): ");
        int p = input.nextInt();

        System.out.println("Introdueix un nombre (q): ");
        int q = input.nextInt();
        int[] array;
        if (p > q) {
            int aux = p;
            p = q;
            q = aux;
        }
        array = new int[q - p + 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = p++;
        }

        System.out.println(Arrays.toString(array));
        input.close();
    }

    private static void exercici8() {
        Scanner input = new Scanner(System.in);
        double r;
        int count = 0;
        double[] array = new double[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        System.out.println("Escriu un valor real R (0,0-1,0): ");
        r = input.nextDouble();

        for (double element : array) {
            if (element >= r) {
                count++;
            }
        }

        System.out.println(count + " valors son iguals o superiors a R.");

        input.close();
    }

    private static void exercici9() {
        Scanner input = new Scanner(System.in);
        int n;
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
        }

        System.out.println("Escriu un valor enter N (1-10): ");
        n = input.nextInt();
        System.out.println("N apareix a les posicions: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\ndel array: ");
        System.out.println(Arrays.toString(array));

        input.close();
    }

    private static void exercici10() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escriu la quantitat d'altures N: ");
        int n = input.nextInt();
        float total = 0, min, max, average;
        int smaller = 0, taller = 0;

        float[] array = new float[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + "- Introdueix una altura (en metres): ");
            array[i] = input.nextFloat();
            total += array[i];
        }
        average = total / array.length;

        min = max = array[0];
        for (float element : array) {
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
            if (element > average) {
                taller++;
            }
            if (element < average) {
                smaller++;
            }
        }

        System.out.println("Mitjana -> " + String.format("%.2f", average)
                + ", màx. -> " + max
                + ", mín. -> " + min
                + "\nPer damunt de la mitjana: " + taller
                + "\nPer davall de la mitjana: " + smaller);

        input.close();
    }

    private static void exercici11() {
        int[] array = new int[10], arrayCopy = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            arrayCopy[j] = array[i];
        }

        System.out.println("Array 1: " + Arrays.toString(array)
                + "\nArray 2: " + Arrays.toString(arrayCopy));

    }

    private static void exercici12() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
        }

        Scanner input = new Scanner(System.in);
        String response;
        int v, p;
        boolean close = false;
        do {
            System.out.println("a. Mostrar valors.\nb. Introduir valor.\nc. Eixir.");
            response = input.next();

            switch (response.toLowerCase()) {
                case "a" -> {
                    System.out.println(Arrays.toString(array));
                }
                case "b" -> {
                    System.out.println("Introdueix un valor(V) i una posició(P): ");
                    v = input.nextInt();
                    p = input.nextInt();
                    array[p] = v;
                }
                case "c" -> {
                    close = true;
                }
                default -> {
                    System.out.println("Opció errónea, selecciona una correcta.");
                    continue;
                }
            }

        } while (!close);
    }

    private static void exercici13() {
        Scanner input = new Scanner(System.in);

        System.out.println("Tamany de l'array (N): ");
        int n = input.nextInt();

        System.out.println("Valor inicial (V): ");
        int v = input.nextInt();

        System.out.println("Increments (I): ");
        int i = input.nextInt();

        int[] array = new int[n];

        for (int j = 0; j < array.length; j++) {
            array[j] = v;
            v += i;
        }

        System.out.println(Arrays.toString(array));
    }

    private static void exercici14() {
        int[] array;
        int arrayLength = 0, currentPosition = 0;

        for (int i = 1; i <= 10; i++) {
            arrayLength += i;
        }

        array = new int[arrayLength];

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                array[currentPosition] = i;
                currentPosition++;
            }
        }
        System.out.println("Array: " + Arrays.toString(array));

    }

    private static void exercici15() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix N (tamany de l'array): ");
        int n = input.nextInt();
        System.out.println("Introdueix M (nombre a repetir): ");
        int m = input.nextInt();

        int[] array = new int[n];
        Arrays.fill(array, m);
        input.close();
        System.out.println(Arrays.toString(array));
    }

    private static void exercici16() {
        int[] array;
        int arrayLength = 0, currentPosition = 0;

        for (int i = 1; i <= 10; i++) {
            arrayLength += i;
        }

        array = new int[arrayLength];

        for (int i = 1; i <= 10; i++) {
            Arrays.fill(array, currentPosition, currentPosition + i, i);
            array[currentPosition] = i;
            currentPosition += i;
        }
        System.out.println("Array: " + Arrays.toString(array));
    }

    private static void exercici17() {
        Scanner input = new Scanner(System.in);
        int[] array1 = new int[10], array2 = new int[10];

        for (int i = 0; i < array1.length; i++) {
            System.out.println("Introdueix un valor per a la posició  [" + i + "] del primer array");
            array1[i] = input.nextInt();
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println("Introdueix un valor per a la posició  [" + i + "] del segon array");
            array2[i] = input.nextInt();
        }

        input.close();
        System.out.println("Son iguals: " + Arrays.equals(array1, array2));

    }

    private static void exercici18() {
        int[] array = new int[30];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void exercici19() {
        Scanner input = new Scanner(System.in);
        int [] players = new int [8];

        for (int i = 0; i < players.length; i++) {
            System.out.println("Introdueix una puntuació del jugador " + (i+1) + "(1000-2800): ");
            players[i] = input.nextInt();
        }
        Arrays.sort(players);
        int [] reversedSortedScores = new int[players.length];
        
        for(int i = 0, j = players.length-1; i < players.length; i++, j--) {
            reversedSortedScores[j] = players[i];
        }
        System.out.println(Arrays.toString(reversedSortedScores));
        
        input.close();
    }

    private static void exercici20() {
        Scanner input = new Scanner(System.in);
        int [] array = new int [1000];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*100);
        }
        System.out.println("Escriu un valor N per a buscar: ");
        int n = input.nextInt();
        int count = 0;
        
        for(int element: array) {
            if(element == n)
                count++;
        }
        if(count > 0) 
            System.out.println("N está a l'array " + count + " vegades.");
        else
            System.out.println("N no está a l'array.");
        
        input.close();
    }

    private static void printAux(int i) {
        System.out.println("Exercici " + i + ": ");
    }

    private static void chooseExercici(int num) {
        switch (num) {
            case 1 -> {
                exercici1();
            }
            case 2 ->
                exercici2();
            case 3 ->
                exercici3();
            case 4 ->
                exercici4();
            case 5 ->
                exercici5();
            case 6 ->
                exercici6();
            case 7 ->
                exercici7();
            case 8 ->
                exercici8();
            case 9 ->
                exercici9();
            case 10 ->
                exercici10();
            case 11 ->
                exercici11();
            case 12 ->
                exercici12();
            case 13 ->
                exercici13();
            case 14 ->
                exercici14();
            case 15 ->
                exercici15();
            case 16 ->
                exercici16();
            case 17 ->
                exercici17();
            case 18 ->
                exercici18();
            case 19 ->
                exercici19();
            case 20 ->
                exercici20();

            default ->
                System.out.println("Exercici fora de rang!");
        }
    }

}
