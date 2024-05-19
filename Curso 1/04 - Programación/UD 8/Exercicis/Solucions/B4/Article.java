/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_B4;

/**
 * UF08 Exercici B4: Classe Article. Valida que les dades de l'article siguen correctes.
 */
public class Article {
    
    String nom;
    double preu;
    int iva;
    int quantsEnQueden;

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
    
}
