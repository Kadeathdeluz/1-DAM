/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_B4;

/**
 * UF08 Exercici B4: Programa per a la gestió d'articles amb nom, preu, iva (sempre 21%) i quantitat.
 */
public class ProgramaArticle {
    
    public static void main(String[] args) {

        Article a1 = new Article("Camisa de quadres", 20, 21, 5);
        Article a2 = new Article("Pantaló de pana", 100, 10, -5);

        System.out.println(a1.nom + " - Preu: " + a1.preu + "€ - IVA: " + a1.iva + "% - PVP: " + (a1.preu + (a1.preu * a1.iva / 100)) + "€");
        System.out.println(a2.nom + " - Preu: " + a2.preu + "€ - IVA: " + a2.iva + "% - PVP: " + (a2.preu + (a2.preu * a2.iva / 100)) + "€");

    }
    
}
