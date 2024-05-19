/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_C2;

/**
 * UF08 Exercici C2: programa amb una classe anomenada Persona que representarà les dades principals d'una
 * persona: dni, nom, cognoms i edat.
 */
public class ProgramaPersona {
    
        public static void main(String[] args) {

        Persona persona1 = new Persona("18999548P", "Josep", "Serrà Ferrandis", 25);
        Persona persona2 = new Persona("20222444L", "Laia", "Barallat Sanxis", 17);

        String cadena1 = persona1.getNom() + " " + persona1.getCognoms() + " amb DNI " + persona1.getDni();
        String cadena2 = persona2.getNom() + " " + persona2.getCognoms() + " amb DNI " + persona2.getDni();

        if (persona1.getEdat() >= 18) {
            cadena1 += " és major de edat";
        } else {
            cadena1 += " no és major de edat";
        }

        if (persona2.getEdat() >= 18) {
            cadena2 += " és major de edat";
        } else {
            cadena2 += " no és major de edat";
        }

        System.out.println(cadena1);
        System.out.println(cadena2);
        System.out.println("");

        persona1.setNom("Joan");
        persona1.setEdat(11);
        persona2.setNom("Carme");
        persona2.setEdat(33);

        cadena1 = persona1.getNom() + " " + persona1.getCognoms() + " amb DNI " + persona1.getDni();
        cadena2 = persona2.getNom() + " " + persona2.getCognoms() + " amb DNI " + persona2.getDni();

        if (persona1.getEdat() >= 18) {
            cadena1 += " és major de edat";
        } else {
            cadena1 += " no és major de edat";
        }

        if (persona2.getEdat() >= 18) {
            cadena2 += " és major de edat";
        } else {
            cadena2 += " no és major de edat";
        }

        System.out.println(cadena1);
        System.out.println(cadena2);
    }
    
}
