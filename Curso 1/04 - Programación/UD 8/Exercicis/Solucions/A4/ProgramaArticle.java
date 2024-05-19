/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_A4;

/**
 * UF08 Exercici A4: Programa per a la gestió d'articles amb nom, preu, iva (sempre 21%) i quantitat.
 */
public class ProgramaArticle {
    
        public static void main(String[] args) {

        Article a1 = new Article();
        a1.nom = "Camisa de quadres";
        a1.preu = 20;
        a1.iva = 21;
        a1.quantsEnQueden = 5;

        System.out.println(a1.nom + " - Preu: " + a1.preu + "€ - IVA: " + a1.iva + "% - PVP: " + (a1.preu + (a1.preu * a1.iva / 100)) + "€");

        a1.preu = 10;

        System.out.println(a1.nom + " - Preu: " + a1.preu + "€ - IVA: " + a1.iva + "% - PVP: " + (a1.preu + (a1.preu * a1.iva / 100)) + "€");

    }
}
