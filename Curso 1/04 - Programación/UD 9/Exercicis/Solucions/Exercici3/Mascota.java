/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;

/**
 * UF09 Exercici 03: Classe Abstracta Mascota
 */
abstract class Mascota {
    
    // Atributs
    private String nom;
    private int edat;
    private String estat;
    private String dataNac;

    // Constructor
    public Mascota(String nom, int edat, String estat, String dataNac) {
        this.nom = nom;
        this.edat = edat;
        this.estat = estat;
        this.dataNac = dataNac;
    }

    // MÈTODES ABSTRACTES

    abstract void mostra();

    abstract void parla();

    // ALTRES MÈTODES
    
    public void aniversari() {
        this.edat = this.edat + 1;
    }

    public void morir() {
        this.estat = "Mort";
    }

    // GETTERS Y SETTERS
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public String getDataNac() {
        return dataNac;
    }

    public void setDataNac(String dataNac) {
        this.dataNac = dataNac;
    }
    
}
