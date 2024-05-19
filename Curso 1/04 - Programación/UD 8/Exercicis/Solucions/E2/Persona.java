/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_E2;
import java.util.regex.Pattern;
/**
 * UF08 Exercici E2: Classe Persona
 */
public class Persona {
    
    private String dni;
    private String nom;
    private String cognoms;
    private int edat;

    public Persona(String dni, String nom, String cognoms, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    // Rertorna si és menor d'edat
    public boolean esMenor() {
        return this.edat < 18;
    }

    // Retorna si està jubilat
    public boolean esJubilat() {
        return this.edat >= 65;
    }

    //Devuelve la diferencia de edat entre este objeto y el recibido
    public int diferenciaEdat(Persona p) {
        return this.edat - p.edat;
    }

    public void mostra() {
        System.out.println("DNI: " + this.dni);
        System.out.println("Nom: " + this.nom);
        System.out.println("Cognoms: " + this.cognoms);
        System.out.println("Edat: " + this.edat);
    }
    
    // Funció que rep un DNI i retorna si és vàlid o no. COMPTE!! no comprova que la lletra siga correcta!
    public static boolean validarDNI(String valor) {
        // Expresió regular que indica 8 dígits i al final alguna de les lletres que se permeten
        // rangs A-H J-N P-T V-Z (recordeu, algunes no se permeten)
        String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
        // Retorna true si se compleix la expresió regular
        return Pattern.matches(dniRegexp, valor);
    }
    
}
