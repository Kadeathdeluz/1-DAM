/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_B2;

/**
 * UF08 Exercici B2: programa amb una classe anomenada Persona que representarà les dades principals d'una
 * persona: dni, nom, cognoms i edat.
 */
public class ProgramaPersona {
    
        public static void main(String[] args) {

        Persona persona1 = new Persona("18999548P", "Josep", "Serrà Ferrandis", 25);
        Persona persona2 = new Persona("20222444L", "Laia", "Barallat Sanxis", 17);

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
