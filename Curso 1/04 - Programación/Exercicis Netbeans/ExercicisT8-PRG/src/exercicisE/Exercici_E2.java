package exercicisE;

import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_E2 {

    public static void main(String[] args) {
        Persona persona1, persona2;
        String dni, nom, cognoms;
        int edat;

        try (Scanner entrada = new Scanner(System.in)) {

            System.out.println("Prova a validar un DNI: ");
            dni = entrada.nextLine();
            System.out.println("El DNI '" + dni + "' és " + (Persona.validarDni(dni)? "vàlid." : "invàlid.") );
            
            System.out.println("Tria un DNI per a la persona 1: ");
            dni = entrada.nextLine();
            System.out.println("Tria un nom per a la persona 1: ");
            nom = entrada.nextLine();
            System.out.println("Tria uns cognoms per a la persona 1: ");
            cognoms = entrada.nextLine();
            System.out.println("Tria una edat per a la persona 1: ");
            edat = entrada.nextInt();
            persona1 = new Persona(dni, nom, cognoms, edat);
            persona1.imprimirPersona();

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
            persona2.imprimirPersona();

            System.out.println("Algú dels dos és jubilat?");
            if (persona1.esJubilat()) {
                System.out.println(persona1.getNom() + " " + persona1.getCognoms() + " és jubilat.");
            }

            if (persona2.esJubilat()) {
                System.out.println(persona2.getNom() + " " + persona2.getCognoms() + " és jubilat.");
            }

            System.out.println("La diferencia d'edat entre " + persona1.getNom()
                    + " y "
                    + persona2.getNom()
                    + " és de " + Math.abs(persona1.diferenciaEdat(persona2)) + " anys.");

        } catch (Exception e) {
            System.out.println("Prova una altra vegada amb dades correctes");
        }
    }
}

class Persona {

    private final String DNI;
    private static final int MAJORIA_EDAT = 18;
    private String nom, cognoms;
    private int edat;

    public static boolean validarDni(String dni) {
        String regex = "\\d{8}+[A-Za-z]{1}";
        return dni.matches(regex);
    }

    Persona(String dni, String nom, String cognoms, int edat) {
        if (validarDni(dni)) {
            this.DNI = dni;
            this.nom = nom;
            this.cognoms = cognoms;
            this.edat = edat;
        }
        else {
            this.DNI = "00000000X";
            System.err.println("DNI '"+ dni + "' no vàlid.");
            System.exit(0);
        }
    }

    public String getDni() {
        return DNI;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public boolean esMajorEdat() {
        return this.edat >= MAJORIA_EDAT;
    }

    public boolean esJubilat() {
        return this.edat >= 65;
    }

    public int diferenciaEdat(Persona p) {
        return this.edat - p.edat;
    }

    public void imprimirPersona() {
        System.out.println(this.nom + " " + this.cognoms + " amb DNI " + this.DNI + (this.edat >= MAJORIA_EDAT ? " és " : " no és ") + " major d'edat.");
    }

}
