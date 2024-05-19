/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_D2;

/**
 * UF08 Exercici D2: programa amb una classe anomenada Persona que representarà les dades principals d'una
 * persona: dni, nom, cognoms i edat.
 */
public class ProgramaPersona {
    
        public static void main(String[] args) {

        // Instanciem persones
        Persona persona1 = new Persona("18999548P", "Josep", "Serrà Ferrandis", 25);
        Persona persona2 = new Persona("20222444L", "Laia", "Barallat Sanxís", 17);

        // Mostrem p1 y p2
        persona1.mostra();
        persona2.mostra();
        System.out.println("");

        // Realitzem alguns canvis
        persona1.setNom("Joan");
        persona1.setEdat(11);
        persona2.setNom("Carme");
        persona2.setEdat(33);

        // Mostrem p1 y p2
        persona1.mostra();
        persona2.mostra();
        System.out.println("");

        // Mostrem diferència d'edat
        System.out.println("La diferència d'edat és " + persona1.diferenciaEdat(persona2));
    }
    
}
