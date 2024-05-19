/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;

/**
 * UF09 Exercici 03: Classe Abstracta Au
 */
abstract class Au extends Mascota {
    
    // Atributs
    private String bec;
    private boolean vola;

    // Constructor
    Au (String nom, int edat, String estat, String dataNac, String bec, boolean vola) {
        super(nom, edat, estat, dataNac);
        this.bec = bec;
        this.vola = vola;
    }

    // MÈTODES ABSTRACTES
    
    abstract void mostra();

    abstract void parla();

    abstract void volar();

    // GETTERS Y SETTERS
    
    public String getBec() {
        return bec;
    }
    
    public void setBec(String bec) {
        this.bec = bec;
    }

    public boolean getVola() {
        return vola;
    }

    public void setVola(boolean vola) {
        this.vola = vola;
    }
}
