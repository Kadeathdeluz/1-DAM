/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;

/**
 * UF09 Exercici 03: Classe Canari
 */
class Canari extends Au {
    
    // Atributs
    private String color;
    private boolean canta;

    // Constructor
    Canari (String nom, int edat, String estat, String dataNac, String bec, boolean vola, String color, boolean canta) {
        super(nom, edat, estat, dataNac, bec, vola);
        this.color = color;
        this.canta = canta;
    }

    void mostra() {
        System.out.println("Nom      : " + this.getNom());
        System.out.println("Edat     : " + this.getEdat());
        System.out.println("Estat    : " + this.getEstat());
        System.out.println("Nascut   : " + this.getDataNac());
        System.out.println("Bec      : " + this.getBec());
        System.out.println("Vola     : " + this.getVola());
        System.out.println("Color    : " + this.getColor());
        System.out.println("Canta    : " + this.getCanta());
    }

    void parla() {
        System.out.println("PIU PIU");
    }

    void saluda() {
        System.out.println("Hola hola, piu piu");
    }

    void volar() {
        this.setEstat("Volant");
    }
    
    // GETTERES Y SETTERS


    public String getColor() {
        return color;
    }

    public void setColor(String origen) {
        this.color = origen;
    }

    public boolean getCanta() {
        return canta;
    }

    public void setCanta(boolean parla) {
        this.canta = parla;
    }
    
    
}
