package calculadora;

import java.util.Scanner;

/**
 * @author: Roldán Sanchis Martínez
 *
 */
public class Calculadora_Avanzada {

    public static void main(String[] args) {
        /*L'operació elegida */
        int operation = 0;

        /*La resposta de si volem repetir l'operació*/
        String response = "n";
        
        /*Defineix el primer valor per tal de poder actualitzar-ho després, també el resultat
        en Java es poden declarar dues o més variables del mateix tipus posant només una vegada el tipus */
        double a, b = 0, result = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Selecciona l'operació a realitzar:");
            System.out.println("Suma (1), Resta(2), Producte(3), Divisió(4), Factorial(5), Eixir(6):");

            /* Entrada teclat*/
            try {
                operation = input.nextInt();

                /* Eixir sense realitzar operació alguna*/
                if (operation == 6) {
                    break;
                }

                /*Si l'usuari vol tornar a fer l'operació, no cal introduir el valor a, perque es mantindrà el resultat anterior*/
                if (response.equalsIgnoreCase("s")) {
                    a = result;
                } else {
                    System.out.println("Introdueix un valor:");
                    a = input.nextDouble();
                }

                /*El factorial només necesita 1 valor per a calcular-se */
                switch (operation) {
                    /* Suma, resta, mult., div.*/
                    case 1, 2, 3, 4 -> {
                        System.out.println("Introdueix un valor:");
                        b = input.nextDouble();
                    }
                }
                result = calculation(operation, a, b);

                System.out.println("El resultat TEMP: " + result);
                
                System.out.println("Vols repetir l'operació? S/N");
                response = input.next();
                
            } catch (Exception e) {
                System.out.println("Per favor, itrodueix un valor correcte");
            }   
            //El bucle termina quan l'usuari diu que vol eixir (6) o que no vol repetir (resposta != "s"), només se repeteix si s'escriu "s"
        } while ((operation != 6) && (response.equalsIgnoreCase("s") ) );

        System.out.println(
                "El resultat és: " + result);
    }

    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        /*Encara que no es real, tractarem les divisions per 0 con si el resultat fora 0 per simplicitat*/
        if (b == 0) {
            return 0;
        }
        return a / b;
    }

    private static double factorial(int a) {
        double total = 1;
        for (int i = a; i > 0; i--) {
            total *= i;
        }
        return total;
    }

    private static double calculation(int operation, double a, double b) {
        return switch (operation) {
            case 1 ->
                addition(a, b);
            case 2 ->
                subtraction(a, b);
            case 3 ->
                multiply(a, b);
            case 4 ->
                division(a, b);
            case 5 ->
                factorial((int) (a));
            default ->
                404.404; //Codi de error
        };
    }

}
