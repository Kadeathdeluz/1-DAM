/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_A2;
import java.util.Scanner;

/**
 * UF08 Exercici A2: programa amb una classe anomenada Persona que representarà les dades principals d'una
 * persona: dni, nom, cognoms i edat.
 */
public class ProgramaPersona {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Persona persona1 = new Persona();
        Persona persona2 = new Persona();

        System.out.println("Introdueix les dades de la primera persona");
        System.out.print("DNI: ");
        persona1.dni = entrada.nextLine();
        System.out.print("Nom: ");
        persona1.nom = entrada.nextLine();
        System.out.print("Cognoms: ");
        persona1.cognoms = entrada.nextLine();
        System.out.print("Edat: ");
        persona1.edat = entrada.nextInt();

        entrada.nextLine();

        System.out.println("Introdueix les dades de la segona persona");
        System.out.print("DNI: ");
        persona2.dni = entrada.nextLine();
        System.out.print("Nom: ");
        persona2.nom = entrada.nextLine();
        System.out.print("Cognoms: ");
        persona2.cognoms = entrada.nextLine();
        System.out.print("Edat: ");
        persona2.edat = entrada.nextInt();

        String cadena1 = persona1.nom + " " + persona1.cognoms + " amb DNI " + persona1.dni;
        String cadena2 = persona2.nom + " " + persona2.cognoms + " amb DNI " + persona2.dni;

        if (persona1.edat >= 18) {
            cadena1 += " és major d'edat";
        } else {
            cadena1 += " no és major d'edat";
        }

        if (persona2.edat >= 18) {
            cadena2 += " és major d'edat";
        } else {
            cadena2 += " no és major d'edat";
        }

        System.out.println(cadena1);
        System.out.println(cadena2);

    }    
}
