package exercicisA;

import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_A2 {

    public static void main(String[] args) {
        Persona persona1, persona2;
        
        try (Scanner entrada = new Scanner(System.in)) {
            
            persona1 = new Persona();
            System.out.println("Tria un DNI per a la persona 1: ");
            persona1.dni = entrada.nextLine();
            System.out.println("Tria un nom per a la persona 1: ");
            persona1.nom = entrada.nextLine();
            System.out.println("Tria uns cognoms per a la persona 1: ");
            persona1.cognoms = entrada.nextLine();
            System.out.println("Tria una edat per a la persona 1: ");
            persona1.edat = entrada.nextInt();
            System.out.println(persona1.nom + " " + persona1.cognoms + " amb DNI " + persona1.dni + (persona1.edat >= 18 ? " és " : " no és ") + " major d'edat.");

            //Limpia el buffer
            entrada.nextLine();

            persona2 = new Persona();
            System.out.println("Tria un DNI per a la persona 2: ");
            persona2.dni = entrada.nextLine();
            System.out.println("Tria un nom per a la persona 2: ");
            persona2.nom = entrada.nextLine();
            System.out.println("Tria uns cognoms per a la persona 2: ");
            persona2.cognoms = entrada.nextLine();
            System.out.println("Tria una edat per a la persona 2: ");
            persona2.edat = entrada.nextInt();
            System.out.println(persona2.nom + " " + persona2.cognoms + " amb DNI " + persona2.dni + (persona2.edat >= 18 ? " és " : " no és ") + " major d'edat.");

        } catch (Exception e) {
            System.out.println("Prova una altra vegada amb dades correctes");
        }
    }
}

class Persona {
    String dni, nom, cognoms;
    int edat;

}
