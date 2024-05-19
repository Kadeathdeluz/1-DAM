package exercicist6.matrius;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martí­nez
 */
public class ExercicisT6_Matrius {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-5)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();

    }

    private static void exercici1() {
        int[][] matrix = new int[5][5];
        int currentNum = 1;

        for (int[] vector : matrix) {
            for (int j = 0; j < vector.length; j++) {
                vector[j] = currentNum;
                currentNum++;
            }
        }
        for (int[] vector : matrix) {
            System.out.println("MATRIX: " + Arrays.toString(vector));
        }
    }

    private static void exercici2() {
        int[][] matrix = new int[10][10];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }

        int count = 1;
        for (int[] vector : matrix) {
            System.out.println("Taula del " + count + ": " + Arrays.toString(vector));
            count++;
        }

    }

    private static void exercici3() {
        Scanner input = new Scanner(System.in);
        int n, m, equalsToZero = 0, greaterThanZero = 0, lowerThanZero = 0;
        int[][] matrix;

        System.out.println("Introdueix N: ");
        n = input.nextInt();

        System.out.println("Introdueix M: ");
        m = input.nextInt();

        matrix = new int[n][m];

        for (int[] vector : matrix) {
            for (int j = 0; j < vector.length; j++) {
                System.out.println("Introdueix un nombre: ");
                vector[j] = input.nextInt();
            }
        }

        for (int[] vector : matrix) {
            for (int element : vector) {
                if (element == 0) {
                    equalsToZero++;
                } else if (element < 0) {
                    lowerThanZero++;
                } else {
                    greaterThanZero++;
                }
            }
        }
        /*System.out.println("MATRIX: ");
        for(int [] vector : matrix) {
            System.out.println("VECTOR: " + Arrays.toString(vector));
        }*/
        System.out.println("Majors que 0: " + greaterThanZero
                + "\nMenors que 0: " + lowerThanZero
                + "\nIguals a 0: " + equalsToZero);

        input.close();
    }

    private static void exercici4() {
        Scanner input = new Scanner(System.in);

        float[][] grades = new float[4][5];

        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                System.out.println("Introdueix la nota " + (j + 1) + " per a l'estudiant " + (i + 1) + ": ");
                grades[i][j] = input.nextFloat();
            }
        }
        float min, max, total, currentGrade;

        for (int i = 0; i < grades.length; i++) {
            min = max = total = grades[i][0];
            for (int j = 1; j < grades[i].length; j++) {
                currentGrade = grades[i][j];
                total += currentGrade;

                if (currentGrade < min) {
                    min = currentGrade;
                } else if (currentGrade > max) {
                    max = currentGrade;
                }
            }
            System.out.println("Les notes de l'estudiant " + (i + 1) + " són: ");
            System.out.println("MIN: " + min);
            System.out.println("MAX: " + max);
            System.out.println("MITJANA: " + total / grades[0].length);
        }

        input.close();
    }

    private static void exercici5() {
        Scanner input = new Scanner(System.in);
        float[][] workers;
        float salary, total;

        System.out.println("Introdueix la quantitat de persones: ");
        int n = input.nextInt(), sex, men = 0, women = 0, currentPosition;

        workers = new float[2][n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introdueix el sexe de la persona: ");
            sex = input.nextInt();

            System.out.println("Introdueix el sou de la persona: ");
            salary = input.nextFloat();
            
            if (sex == 0) {
                currentPosition = men;
                men++;
            }
            else {
                currentPosition = women;
                women++;
            }
            
            workers[sex][currentPosition] = salary;
        }
        
        total = 0;
        for(int i = 0; i <= men; i++) {
            total += workers[0][i];
        }
        System.out.println("Sou mitjà homes: " + String.format("%.2f",total/(men)));
        
        total = 0;
        for(int i = 0; i <= women; i++) {
            total += workers[1][i];
        }
        System.out.println("Sou mitjà dones: " + String.format("%.2f",total/(women)) );
        
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
