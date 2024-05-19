package exercicisB;

import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_B2 {

    public static void main(String[] args) {
        Persona persona1, persona2;
        String dni, nom, cognoms;
        int edat;

        try (Scanner entrada = new Scanner(System.in)) {

            System.out.println("Tria un DNI per a la persona 1: ");
            dni = entrada.nextLine();
            System.out.println("Tria un nom per a la persona 1: ");
            nom = entrada.nextLine();
            System.out.println("Tria uns cognoms per a la persona 1: ");
            cognoms = entrada.nextLine();
            System.out.println("Tria una edat per a la persona 1: ");
            edat = entrada.nextInt();
            persona1 = new Persona(dni, nom, cognoms, edat);
            System.out.println(persona1.nom + " " + persona1.cognoms + " amb DNI " + persona1.dni + (persona1.edat >= 18 ? " és " : " no és ") + " major d'edat.");

            //Limpia el buffer
            entrada.nextLine();

            System.out.println("Tria un DNI per a la persona 2: ");
            dni = entrada.nextLine();
            System.out.println("Tria un nom per a la persona 2: ");
            nom = entrada.nextLine();
            System.out.println("Tria uns cognoms per a la persona 2: ");
            cognoms = entrada.nextLine();
            System.out.println("Tria una edat per a la persona 2: ");
            edat = entrada.nextInt();
            persona2 = new Persona(dni, nom, cognoms, edat);
            System.out.println(persona2.nom + " " + persona2.cognoms + " amb DNI " + persona2.dni + (persona2.edat >= 18 ? " és " : " no és ") + " major d'edat.");

        } catch (Exception e) {
            System.out.println("Prova una altra vegada amb dades correctes");
        }
    }
}

class Persona {

    String dni, nom, cognoms;
    int edat;

    public Persona(String dni, String nom, String cognoms, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
    }

}
