/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici02;
import java.util.ArrayList;
/**
 * UF09 Exercici 02: Classe Planeta extensió de la classe Astre
 */
class Planeta extends Astre {
    
    // Atributs
    private double distSol;
    private double orbSol;
    private boolean teSat;
    private ArrayList<Satel_lit> satel_lits;

    // Constructor
    Planeta(String nom, double radi, double rotEix, double massa, double tempMitjana, double gravetat, double distSol, double orbSol, boolean teSat, ArrayList<Satel_lit> satel_lits) {
        super(nom, radi, rotEix, massa, tempMitjana, gravetat);
        this.distSol = distSol;
        this.orbSol = orbSol;
        this.teSat = teSat;
        this.satel_lits = satel_lits;
    }

    // Constructor sense satèlits (pot afegir-se després amb "afegirSatel_lit")
    Planeta(String nom, double radi, double rotEix, double massa, double tempMitjana, double gravetat, double distSol, double orbSol) {
        super(nom, radi, rotEix, massa, tempMitjana, gravetat);
        this.distSol = distSol;
        this.orbSol = orbSol;
        this.teSat = false;
        this.satel_lits = new ArrayList();
    }

    // Afegim un satèlit
    public void afegirSatel_lit(Satel_lit s) {
        satel_lits.add(s);
        this.teSat = true;
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
        if (teSat) {
            for (int i = 0; i < getSatel_lits().size(); i++) {
                System.out.println("  - Satèl·lit " + i + ": " + this.getSatel_lits().get(i).getNom());
            }
        }
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

    public ArrayList<Satel_lit> getSatel_lits() {
        return satel_lits;
    }

    public void setSatel_lits(ArrayList<Satel_lit> satel_lits) {
        this.satel_lits = satel_lits;
    }

    
}
