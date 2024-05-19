/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;

/**
 * UF09 Exercici 03: Classe Lloro
 */
class Lloro extends Au {
    
    // Atributs
    private String origen;
    private boolean parla;

    // Constructor
    Lloro (String nom, int edat, String estat, String dataNac, String bec, boolean vola, String origen, boolean parla) {
        super(nom, edat, estat, dataNac, bec, vola);
        this.origen = origen;
        this.parla = parla;
    }

    void mostra() {
        System.out.println("Nom      : " + this.getNom());
        System.out.println("Edat     : " + this.getEdat());
        System.out.println("Estat    : " + this.getEstat());
        System.out.println("Nascut   : " + this.getDataNac());
        System.out.println("Bec      : " + this.getBec());
        System.out.println("Vola     : " + this.getVola());
        System.out.println("Origen   : " + this.getOrigen());
        System.out.println("Parla    : " + this.getParla());
    }

    void parla() {
        System.out.println("HOLA HOLA");
    }

    void saluda() {
        System.out.println("Bon dia");
    }

    void volar() {
        this.setEstat("Volant");
    }

    // GETTERES Y SETTERS

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public boolean getParla() {
        return parla;
    }

    public void setParla(boolean parla) {
        this.parla = parla;
    }
    
}
