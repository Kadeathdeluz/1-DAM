/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici02;

/**
 * UF09 Exercici 02: Classe Astre
 */
abstract class Astre {
    
    // Atributs
    private String nom;
    private double radi;
    private double rotEix;
    private double massa;
    private double tempMitjana;
    private double gravetat;

    // Constructor
    public Astre(String nom, double radi, double rotEix, double massa, double tempMitjana, double gravetat) {
        this.nom = nom;
        this.radi = radi;
        this.rotEix = rotEix;
        this.massa = massa;
        this.tempMitjana = tempMitjana;
        this.gravetat = gravetat;
    }

    // Mètode abstracte. Ha d'implementar-se en totes les classes filles.
    abstract public void mostra();

    // GETTERS Y SETTERS
    ;
    
    public double getRadi() {
        return radi;
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }

    public double getRotEix() {
        return rotEix;
    }

    public void setRotEix(double rotEix) {
        this.rotEix = rotEix;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getTempMitjana() {
        return tempMitjana;
    }

    public void setTempMitjana(double tempMitjana) {
        this.tempMitjana = tempMitjana;
    }

    public double getGravetat() {
        return gravetat;
    }

    public void setGravetat(double gravetat) {
        this.gravetat = gravetat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
