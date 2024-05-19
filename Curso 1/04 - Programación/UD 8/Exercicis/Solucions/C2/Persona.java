/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_C2;

/**
 * UF08 Exercici C2: Classe Persona
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

    
}
