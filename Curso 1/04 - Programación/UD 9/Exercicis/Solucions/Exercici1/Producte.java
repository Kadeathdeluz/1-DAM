/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici01;

/**
 * UF09 Exercici 1: Classe Producte.
 */
public class Producte {
    
    // Atributs
    private String nom;
    private int quantitat;

    // Constructor
    public Producte(String nom, int quantitat) {
        this.nom = nom;
        this.quantitat = quantitat;
    }

    // Mètodes setters i getters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
    
}
