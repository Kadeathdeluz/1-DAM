/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;

/**
 * UF09 Exercici 03: Classe Gos
 */
class Gos extends Mascota {

    // Atributs
    private String raça;
    private boolean puces;

    // Constructor
    Gos(String nom, int edat, String estat, String dataNac, String raça, boolean puces) {
        super(nom, edat, estat, dataNac);
        this.raça = raça;
        this.puces = puces;
    }

    void mostra() {
        System.out.println("Nom      : " + this.getNom());
        System.out.println("Edat     : " + this.getEdat());
        System.out.println("Estat    : " + this.getEstat());
        System.out.println("Nascut   : " + this.getDataNac());
        System.out.println("Raça     : " + this.getRaça());
        System.out.println("Puces    : " + this.getPuces());
    }

    void parla() {
        System.out.println("BUB BUB");
    }

    // GETTERS Y SETTERS

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public boolean getPuces() {
        return puces;
    }

    public void setPuces(boolean puces) {
        this.puces = puces;
    }    
    
}
