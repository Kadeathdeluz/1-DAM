/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceedcv.ggarrido.ProgramaAstres;
/**
 * UF09 Exercici 02: Classe Satel·lit extesió de la classe Astre
 */
class Satel_lit extends Astre {
    
    // Atributs
    private double distPlaneta;
    private double orbPlaneta;
    private Planeta planeta;

    // Constructor
    Satel_lit(String nom, double radi, double rotEix, double massa, double tempMitjana, double gravetat, double distPlaneta, double orbPlaneta, Planeta planeta) {
        super(nom, radi, rotEix, massa, tempMitjana, gravetat);
        this.distPlaneta = distPlaneta;
        this.orbPlaneta = orbPlaneta;
        this.planeta = planeta;
    }

    // Mostrem sols part de la seua informació
    public void mostra() {
        System.out.println("*** SATÈL·LIT " + getNom() + " ***");
        System.out.println("Radi               : " + getRadi());
        System.out.println("Rotació eix        : " + getRotEix());
        System.out.println("Massa:             : " + getMassa());
        System.out.println("Temperatura mitjana: " + getTempMitjana());
        System.out.println("Gravetat           : " + getGravetat());
        System.out.println("Distància planeta  : " + getDistPlaneta());
        System.out.println("Òrbita al planeta  : " + getOrbPlaneta());
        System.out.println("Perteneix planeta  : " + planeta.getNom());
    }

    // GETTERS Y SETTERS
    
    public double getDistPlaneta() {
        return distPlaneta;
    }

    public void setDistPlaneta(double distPlaneta) {
        this.distPlaneta = distPlaneta;
    }

    public double getOrbPlaneta() {
        return orbPlaneta;
    }

    public void setOrbPlaneta(double orbPlaneta) {
        this.orbPlaneta = orbPlaneta;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    
}
