/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciB1;
import java.io.*;
import java.util.*;
/**
 * UF11 Exercici B1: Programa que mostra per pantalla els valors màxims i mínims de l'arxiu ‘numeros.txt’
 */
public class UF11_ExerciciB1 {
    
        public static void main(String[] args) {
            
        // Declarem i inicialitzem les variables
        int maxim = Integer.MIN_VALUE;
        int minim = Integer.MAX_VALUE;
        int numero = 0;

        try {
            // Intentem obrir l'arxiu
            File f = new File("Documentos/numeros.txt");
            Scanner lector = new Scanner(f);

            // Mentres queden elements anirem llgint els enters 
            while (lector.hasNext()) {
                numero = lector.nextInt();

                // Comprobem si el número llegit es major que màxim
                if (numero > maxim) {
                    // Asignem el número al màxim
                    maxim = numero;
                }

                // Comprobem si el número llegit es menor que mínim
                if (numero < minim) {
                    // Asignem el número al mínim
                    minim = numero;
                }
            }

            // Tanquem el Scanner
            lector.close();

            // Mostrem per pantalla el valor màxim i mínim
            System.out.println("El valor màxim és " + maxim);
            System.out.println("El valor mínim és " + minim);

        } catch (FileNotFoundException e) {
            System.out.println("Error: L'arxiu no existeix");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
