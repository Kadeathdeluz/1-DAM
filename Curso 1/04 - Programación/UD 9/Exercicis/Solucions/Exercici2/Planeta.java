/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceedcv.ggarrido.ProgramaAstres;
import java.util.ArrayList;
/**
 * UF09 Exercici 02: Classe Planeta extensió de la classe Astre
 */
class Planeta extends Astre {
    
    // Atributs
    private double distSol;
    private double orbSol;
    private boolean teSat;

    // Constructor
    Planeta(String nom, double radi, double rotEix, double massa, double tempMitjana, double gravetat, double distSol, double orbSol, boolean teSat) {
        super(nom, radi, rotEix, massa, tempMitjana, gravetat);
        this.distSol = distSol;
        this.orbSol = orbSol;
        this.teSat = teSat;
    }

    // Constructor sense satèlits (pot afegir-se després amb "afegirSatel_lit")
    Planeta(String nom, double radi, double rotEix, double massa, double tempMitjana, double gravetat, double distSol, double orbSol) {
        super(nom, radi, rotEix, massa, tempMitjana, gravetat);
        this.distSol = distSol;
        this.orbSol = orbSol;
        this.teSat = false;
    }

    // Mostrem informació del planeta
    public void mostra() {
        System.out.println("*** PLANETA " + this.getNom() + " ***");
        System.out.println("Radi               : " + this.getRadi());
        System.out.println("Rotació eix       : " + this.getRotEix());
        System.out.println("Massa:             : " + this.getMassa());
        System.out.println("Temperatura mitjana: " + this.getTempMitjana());
        System.out.println("Gravetat           : " + this.getGravetat());
        System.out.println("Distància al sol   : " + this.getDistSol());
        System.out.println("Òrbita al sol      : " + this.getOrbSol());
        System.out.println("Té satèl·lits    : " + this.getTeSat());
    }

    // GETTERS Y SETTERS
    ;
    
    public double getDistSol() {
        return distSol;
    }

    public void setDistSol(double distSol) {
        this.distSol = distSol;
    }

    public double getOrbSol() {
        return orbSol;
    }

    public void setOrbSol(double orbSol) {
        this.orbSol = orbSol;
    }

    public boolean getTeSat() {
        return teSat;
    }

    public void setTeSat(boolean teSat) {
        this.teSat = teSat;
    }   
}
