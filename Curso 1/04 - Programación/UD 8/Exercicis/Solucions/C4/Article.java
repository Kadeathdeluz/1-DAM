/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_C4;

/**
 * UF08 Exercici C4: Classe Article. Valida que les dades de l'article siguen correctes.
 */
public class Article {
    
        private String nom;
    private double preu;
    private int iva;
    private int quantsEnQueden;

    public Article(String nom, double preu, int iva, int quantsEnQueden) {
        if (nom.equals("")) {
            System.err.println("ERROR: El nom no pot estar buit");
        } else if (preu <= 0) {
            System.err.println("ERROR: El preu no pot ser menor o igual a cero");
        } else if (iva != 21) {
            System.err.println("ERROR: L'iva ha de ser del 21%");
        } else if (quantsEnQueden < 0) {
            System.err.println("ERROR: El stock no pot ser menor de cero");
        } else {
            this.nom = nom;
            this.preu = preu;
            this.iva = iva;
            this.quantsEnQueden = quantsEnQueden;
        }
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public int getIva() {
        return iva;
    }

    public int getQuantsEnQueden() {
        return quantsEnQueden;
    }

    public void setNom(String nom) {
        if (nom.equals("")) {
            System.err.println("ERROR: El nom no pot estar buit");
        } else {
            this.nom = nom;
        }
    }

    public void setPreu(double preu) {
        if (preu <= 0) {
            System.err.println("ERROR: El preu no pot ser menor o igual a cero");
        } else {
            this.preu = preu;
        }
    }

    public void setIva(int iva) {
        if (iva != 21) {
            System.err.println("ERROR: L'iva deu ser del 21%");
        } else {
            this.iva = iva;
        }
    }

    public void setQuantsEnQueden(int quantsEnQueden) {
        if (quantsEnQueden < 0) {
            System.err.println("ERROR: El stock no pot ser menor de cero");
        } else {
            this.quantsEnQueden = quantsEnQueden;
        }

    }
    
}
