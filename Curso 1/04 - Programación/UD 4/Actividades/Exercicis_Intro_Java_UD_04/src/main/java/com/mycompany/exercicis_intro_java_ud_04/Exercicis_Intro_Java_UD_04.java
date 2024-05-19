package com.mycompany.exercicis_intro_java_ud_04;

import java.util.Scanner;

/**
 *
 * @author RoldÃ¡n Sanchis MartÃ­nez
 */
public class Exercicis_Intro_Java_UD_04 {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-21)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();
    }

    public static void exercici1() {
        System.out.println("Bon dia");
    }

    private static void exercici2() {
        int costat = 5;
        int area = costat * costat;
        System.out.println("L'area es: " + area);
    }

    private static void exercici3() {
        Scanner input = new Scanner(System.in);
        int costat = input.nextInt();
        int area = costat * costat;
        System.out.println("L'area es: " + area);
    }

    private static void exercici4() {
        int suma, resta, producte;
        double divisio;

        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();

        suma = num1 + num2;
        resta = num1 - num2;
        producte = num1 * num2;
        divisio = (double) num1 / (double) num2;

        System.out.println("Suma: " + suma + "\nResta: " + resta + "\nProducte: " + producte + "\nDivisiÃ³: " + (String.format("%.2f", divisio)));
    }

    private static void exercici5() {
        Scanner input = new Scanner(System.in);
        double radi, longitud, area, volum;

        radi = input.nextDouble();
        longitud = radi * 2;
        area = radi * radi * Math.PI;
        volum = 4 / 3 * area * radi;

        System.out.println("Radi: " + radi + "\nLongitud: " + longitud + "\nÃrea: " + area + "\nVolum: " + volum);

    }

    private static void exercici6() {
        Scanner input = new Scanner(System.in);
        double preu, preu_real, descompte;
        preu = input.nextDouble();
        preu_real = input.nextDouble();

        descompte = (1 - preu_real / preu) * 100;

        System.out.println("El descompte aplicat es del: " + (String.format("%.2f", descompte)) + "%.");

    }

    private static void exercici7() {
        Scanner input = new Scanner(System.in);
        int metres, milles = input.nextInt();
        metres = milles * 1852;

        System.out.println(milles + " milles marines son " + metres + " metres.");
    }

    private static void exercici8() {
        Scanner input = new Scanner(System.in);
        int edat = input.nextInt();
        if (edat >= 18) {
            System.out.println("Eres major d'edat.");
        }
    }

    private static void exercici9() {
        Scanner input = new Scanner(System.in);
        int edat = input.nextInt();
        if (edat >= 18) {
            System.out.println("Eres major d'edat.");
        } else {
            System.out.println("Eres menor d'edat.");
        }
    }

    private static void exercici10() {
        int suma, resta, producte;
        double divisio;

        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();

        if (num1 == 0 || num2 == 0) {
            System.out.println("No pots dividir un 0 ni entre 0.");
        } else {
            suma = num1 + num2;
            resta = num1 - num2;
            producte = num1 * num2;
            divisio = (double) num1 / (double) num2;

            System.out.println("Suma: " + suma + "\nResta: " + resta + "\nProducte: " + producte + "\nDivisiÃ³: " + (String.format("%.2f", divisio)));
        }

    }

    private static void exercici11() {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();

        if (num1 > num2) {
            System.out.println(num1 + " és major.");
        } else {
            System.out.println(num2 + " és major.");
        }
    }

    private static void exercici12() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String result;
        
        if (num < 0) {
            result = "negatiu";
        } else {
            result = "positiu";
        }
        System.out.println("El número és: " + result + ".");
    }

    private static void exercici13() {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();

        if (num1 > num2) {
            System.out.println(num2 + ", " + num1);
        } else {
            System.out.println(num1 + ", " + num2);
        }
    }

    private static void exercici14() {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();

        if (num1 > num2) {
            System.out.println(num1 + " és major.");
        } else if (num2 > num1) {
            System.out.println(num2 + " és major.");
        } else {
            System.out.println("Són iguals");
        }

    }

    private static void exercici15() {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt(), num3 = input.nextInt();

        if (num1 > num2) {
            if (num1 > num3) {
                System.out.println(num1 + " és major.");
            } else {
                System.out.println(num3 + " és major.");
            }
        } else {
            if (num2 > num3) {
                System.out.println(num2 + " és major.");
            } else {
                System.out.println(num3 + " és major.");
            }
        }
    }

    private static void exercici16() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        String result = switch (num) {
            case 0, 1, 2 ->
                "Molt Deficient";
            case 3, 4 ->
                "Insuficient";
            case 5 ->
                "Bé";
            case 6, 7, 8 ->
                "Notable";
            case 9, 10 ->
                "Excel·lent";
            default ->
                "Nota no possible";
        };
        System.out.println(result);
    }

    private static void exercici17() {
        Scanner input = new Scanner(System.in);
        int hores = input.nextInt(), minuts = input.nextInt(), segons = input.nextInt();
        if (segons + 1 > 59) {
            segons = 0;
            minuts++;
        } else {
            segons++;
        }
        if (minuts + 1 > 59) {
            minuts = 0;
            hores++;

        }
        if (hores > 23) {
            hores = 0;
        }

        System.out.println("Són les " + hores + ":" + minuts + ":" + segons);
    }

    private static void exercici18() {
        Scanner input = new Scanner(System.in);
        int hores = input.nextInt(), tarifa = input.nextInt();
        double salariBrut, salariNet, taxes;

        if (hores <= 35) //tarifa normal
        {
            salariBrut = hores * tarifa;
        } else {
            salariBrut = ((hores - 35) * tarifa * 1.5) + (35 * tarifa);
        }

        if (salariBrut <= 500) {
            taxes = 0;
        } else if (salariBrut <= 900) {
            taxes = (salariBrut - 500) * 0.25;
        } else {
            taxes = 400 * 0.25 + (salariBrut - 900) * 0.45;
        }

        salariNet = salariBrut - taxes;

        System.out.println("Hores: " + hores + "\nSalari (brut): " + salariBrut + "\nTaxes: " + taxes + "\nSalari (net): " + salariNet);

    }

    private static void exercici19() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix l'at (cm) y l'ample (cm): ");
        int alt = input.nextInt(), ample = input.nextInt();
        double preu = alt * ample;

        System.out.println("Vols escut brodat? (S/N): ");
        String resposta = input.next();

        if (resposta.equalsIgnoreCase("s")) {
            preu += 2.5;
        }

        preu += 3.25;
        System.out.println("Preu bandera de " + (alt * ample) + "cm2: " + preu + "\ndespeses d'enviament: 3.25€\n");
    }

    private static void exercici20() {
        Scanner input = new Scanner(System.in);

        System.out.println("Tria un sabor (poma, maduixa, xocolata): ");
        String sabor = input.next();
        double preu = 0;

        switch (sabor.toLowerCase()) {
            case "poma" -> {
                preu += 18;
            }
            case "maduixa" -> {
                preu += 16;
            }
            case "xocolata" -> {
                System.out.println("Xocolata negra o blanca?");
                String xocolata = input.next();
                if (xocolata.equalsIgnoreCase("negra")) {
                    preu += 14;
                } else if (xocolata.equalsIgnoreCase("blanca")) {
                    preu += 15;
                }
            }
            default -> {
                System.out.println("Not in range!");
            }
        }
        System.out.println("Vols nata? (S/N)");
        String resposta = input.next();
        if (resposta.equalsIgnoreCase("s")) {
            preu += 2.5;
        }

        System.out.println("Vols el teu nom escrit? (S/N)");
        resposta = input.next();
        if (resposta.equalsIgnoreCase("s")) {
            preu += 2.75;
        }

        System.out.println("Preu final: " + preu + "€");
        input.close();
    }

    private static void exercici21() {
        Scanner input = new Scanner(System.in);
        String jugador1, jugador2;

        System.out.println("Torn del jugador 1: \nIntrodueix pedra, paper o tisora: ");
        jugador1 = input.next();

        System.out.println("Torn del jugador 2: \nIntrodueix pedra, paper o tisora: ");
        jugador2 = input.next();

        String resultat = "";

        switch (jugador1) {
            case "pedra" -> {
                resultat = switch (jugador2) {
                    case "pedra" ->
                        "empat";
                    case "paper" ->
                        "jugador2";
                    case "tisora" ->
                        "jugador1";
                    default ->
                        "F";
                };

            }

            case "paper" -> {
                resultat = switch (jugador2) {
                    case "pedra" ->
                        "jugador1";
                    case "paper" ->
                        "empat";
                    case "tisora" ->
                        "jugador2";
                    default ->
                        "F";
                };
            }
            
            case "tisora" -> {
                resultat = switch (jugador2) {
                    case "pedra" ->
                        "jugador2";
                    case "paper" ->
                        "jugador1";
                    case "tisora" ->
                        "empat";
                    default ->
                        "F";
                };
            }
        }
        if(resultat.equalsIgnoreCase("empat")) System.out.println("Empat");
        else System.out.println("Guanyador el " + resultat);
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
            default ->
                System.out.println("Exercici fora de rang!");
        }
    }

}
