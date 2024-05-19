package exercicist5.prg;

import java.util.Scanner;

public class ExercicisT5PRG {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-22)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();
    }

    private static void exercici1() {
        for (int i = 0; i <= 200; i++) {
            System.out.println("i val: " + i);

        }
    }

    private static void exercici2() {
        for (int i = 0; i <= 200; i += 2) {
            System.out.println("i val: " + i);
        }
    }

    private static void exercici3() {
        for (int i = 0; i <= 200; i++) {
            if (i % 2 == 0) {
                System.out.println("i val: " + i);
            }
        }
    }

    private static void exercici4() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        for (int i = 0; i <= num; i++) {
            System.out.println("i val: " + i);
        }
        input.close();
    }

    private static void exercici5() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int factorial = 1;

        for (int i = num; i > 1; i--) {
            factorial *= i;
        }
        System.out.println("Factorial de " + num + " es " + factorial);
        input.close();
    }

    private static void exercici6() {
        Scanner input = new Scanner(System.in);
        boolean negative = false;
        
        for (int i = 1; i <= 10; i++) {
            if (input.nextInt() < 0) {
                negative = true;
            }
        }
        if (negative) {
            System.out.println("Has trobat algun negatiu");
        } else {
            System.out.println("No has trobat cap negatiu");
        }

        input.close();
    }

    private static void exercici7() {
        Scanner input = new Scanner(System.in);
        int negative = 0;

        for (int i = 1; i <= 10; i++) {
            if (input.nextInt() < 0) {
                negative++;
            }
        }
        System.out.println("Positius: " + (10 - negative) + ", negatius: " + negative);

        input.close();
    }

    private static void exercici8() {
        Scanner input = new Scanner(System.in);
        int negatives = 0, positives = 0;
        int currentNum = input.nextInt();

        while (currentNum != 0) {
            if (currentNum < 0) {
                negatives++;
            } else {
                positives++;
            }
            currentNum = input.nextInt();
        }
        if (negatives != 0) {
            System.out.println("Has trobat algun negatiu.");
        }
        System.out.println("Positius: " + positives + ", negatius: " + negatives);

        input.close();
    }

    private static void exercici9() {
        int addition = 0, multiply = 1;
        for (int i = 1; i <= 10; i++) {
            addition += i;
            multiply *= i;
            System.out.println(i + ": suma-> " + addition + " producte-> " + multiply);
        }
        System.out.println("RESULTAT: suma-> " + addition + " producte-> " + multiply);
    }

    private static void exercici10() {
        Scanner input = new Scanner(System.in);
        boolean ten = false;
        int currentNumber = input.nextInt();

        while (currentNumber != -1) {
            if (currentNumber == 10) {
                ten = true;
            }
            currentNumber = input.nextInt();
        }
        if (ten) {
            System.out.println("Has trobat algun deu");
        } else {
            System.out.println("No has trobat cap deu");
        }
    }

    private static void exercici11() {
        int even = 0, odd = 0;
        for (int i = 100; i <= 200; i++) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        System.out.println("Parells-> " + even + ", imparells-> " + odd);
    }

    private static void exercici12() {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        boolean negativePow = false;
        int res = 1;
        if (b < 0) {
            b = 0 - b;
            negativePow = true;
        }

        for (int i = b; i > 0; i--) {
            res *= a;
        }
        if (negativePow) {
            System.out.println(a + " elevat a " + b + " és igual a 1/" + res);
        } else {
            System.out.println(a + " elevat a " + b + " és igual a " + res);
        }
    }

    private static void exercici13() {
        Scanner input = new Scanner(System.in);
        boolean found = false;
        int min = 1;
        int max = 100;
        int num = (int) (Math.random() * max + min);;

        while (!found) {
            System.out.println("És el " + num + "? (>/</=)");
            String response = input.next();

            switch (response) {
                case "=" -> {
                    System.out.println("El nombre que pensabes és el " + num);
                    found = true;
                }
                case "<" -> {
                    max = num;
                }
                case ">" -> {
                    min = num;
                }
                default -> {
                }
            }
            num = (int) (Math.random() * (max - min) + min);

        }

    }

    private static void exercici14() {
        int bill_500, bill_200, bill_100, bill_50, bill_20, bill_10, bill_5;
        bill_500 = bill_200 = bill_100 = bill_50 = bill_20 = bill_10 = bill_5 = 0;
        Scanner input = new Scanner(System.in);
        int quantity = input.nextInt();
        
        while (quantity % 5 != 0) {
            System.out.println("Per favor, introdueix una quantitat múltiple de 5: ");
            quantity = input.nextInt();
        }
        
        while (quantity > 0) {
            
            if (quantity >= 500) {
                bill_500++;
                quantity -= 500;
            } else if (quantity >= 200) {
                bill_200++;
                quantity -= 200;
            } else if (quantity >= 100) {
                bill_100++;
                quantity -= 100;
            } else if (quantity >= 50) {
                bill_50++;
                quantity -= 50;
            } else if (quantity >= 20) {
                bill_20++;
                quantity -= 20;
            } else if (quantity >= 10) {
                bill_10++;
                quantity -= 10;
            } else if (quantity >= 5) {
                bill_5++;
                quantity -= 5;
            }
            
        }
        System.out.println("Bitllets de 500: " + bill_500
                + "\nBitllets de 200: " + bill_200
                + "\nBitllets de 100: " + bill_100
                + "\nBitllets de 50: " + bill_50
                + "\nBitllets de 20: " + bill_20
                + "\nBitllets de 10: " + bill_10
                + "\nBitllets de 5: " + bill_5);
    }

    private static void exercici15() {
        Scanner input = new Scanner(System.in);
        int max = input.nextInt(), count = 0;

        for (int i = 1; i <= max; i++) {
            if (i % 3 == 0) {
                count++;
            }
        }
        System.out.println("Cantidad de múltiplos de 3 hasta " + max + ": " + count);
    }

    private static void exercici16() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        if ((num % 2 == 0 && num > 2) || (num % 3 == 0 && num > 3) || (num % 5 == 0 && num > 5)) {
            System.out.println("No es primo");
        } else {
            System.out.println("Es primo");
        }

    }

    private static void exercici17() {
        Scanner input = new Scanner(System.in);
        int current, count = 0, fails = 0, last;

        System.out.println("Número inicial: ");
        current = input.nextInt();

        while (current != 0) {
            count++;
            last = current;
            System.out.println("Dime un número: ");
            current = input.nextInt();

            if (current <= last && current != 0) {
                fails++;
                System.out.println("Fallo, es menor (o igual)");
            }

        }
        System.out.println("Números introducidos: " + count + "\nNúmero de fallos: " + fails);

    }

    private static void exercici18() {
        int suma = 0;
        for (int i = 1; i <= 5; i++) {
            suma += i * i;
        }
        System.out.println("Suma: " + suma);
    }

    private static void exercici19() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dime un número: ");
        int num = input.nextInt();

        if (num < 0) {
            System.out.println("*");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }

    private static void exercici20() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dime un número: (0-20)");
        int num = input.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    private static void exercici21() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dime un número: ");
        int num1 = input.nextInt();
        System.out.println("Dime otro número mayor que el anterior: ");
        int num2 = input.nextInt();
        int even = 0;
        
        for (int i = num1; i <= num2; i++) {
            System.out.print(i + " ");
            if(i % 2 == 0) even++;
        }
        System.out.println("\nLa cantidad de pares son: " + even);
    }

    private static void exercici22() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dime un número para realizar su pirámide: ");
        int height = input.nextInt();
        int spaceLimit = height;
        
        for(int i = 1; i <= height; i++) {
            
            for(int j = 1; j < spaceLimit; j++){
                System.out.print(" ");
            }
            
            for(int k = 1; k <= (i*2)-1; k++) {
                System.out.print("*");
            }
            
            spaceLimit--;
            System.out.println("");
        }
    }
    
    private static void exercici23() {
        
    }
    
    private static void exercici24() {
        
    }
    private static void exercici25() {
        
    }
    private static void exercici26() {
        
    }
    private static void exercici27() {
        
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
            case 21 ->
                exercici21();
            case 22 ->
                exercici22();
            case 23 ->
                exercici23();
            case 24 ->
                exercici24();
            case 25 ->
                exercici25();
            case 26 ->
                exercici26();
            case 27 ->
                exercici27();
            default ->
                System.out.println("Exercici fora de rang!");
        }
    }

}
