/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;

/**
 * UF09 Exercici 03: Classe Gat
 */
class Gat extends Mascota {
    
    // Atributs
    private String color;
    private boolean pelLlarg;
    
    // Constructor
    Gat(String nom, int edat, String estat, String dataNac, String color, boolean pelLlarg) {
        super(nom, edat, estat, dataNac);
        this.color = color;
        this.pelLlarg = pelLlarg;
    }

    void mostra() {
        System.out.println("Nom      : " + this.getNom());
        System.out.println("Edat     : " + this.getEdat());
        System.out.println("Estat    : " + this.getEstat());
        System.out.println("Nascut   : " + this.getDataNac());
        System.out.println("Color    : " + this.getColor());
        System.out.println("Pel Llarg: " + this.getPelLlarg());
    }

    void parla() {
        System.out.println("MÈU MÈU");
    }

    // GETTERS Y SETTERS
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getPelLlarg() {
        return pelLlarg;
    }

    public void setPelLlarg(boolean pelLlarg) {
        this.pelLlarg = pelLlarg;
    }   
    
    
    
}
