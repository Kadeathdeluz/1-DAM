/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_C4;

/**
 * UF08 Exercici C4: Programa per a la gestió d'articles amb nom, preu, iva (sempre 21%) i quantitat.
 */
public class ProgramaArticle {
    
        public static void main(String[] args) {

        Article a1 = new Article("Camisa de quadres", 20, 21, 5);
        Article a2 = new Article("Pantaló de pana", 100, 21, 10);

        System.out.println(a1.getNom() + " - Preu: " + a1.getPreu() + "€ - IVA: " + a1.getIva() + "% - PVP: " + (a1.getPreu() + (a1.getPreu() * a1.getIva() / 100)) + "€");
        System.out.println(a2.getNom() + " - Preu: " + a2.getPreu() + "€ - IVA: " + a2.getIva() + "% - PVP: " + (a2.getPreu() + (a2.getPreu() * a2.getIva() / 100)) + "€");

        a1.setNom("Jaqueta de llana");
        a1.setPreu(0);
        a1.setPreu(30);

        a2.setIva(10);
        a2.setQuantsEnQueden(-5);
        a2.setQuantsEnQueden(0);

        System.out.println(a1.getNom() + " - Preu: " + a1.getPreu() + "€ - IVA: " + a1.getIva() + "% - PVP: " + (a1.getPreu() + (a1.getPreu() * a1.getIva() / 100)) + "€");
        System.out.println(a2.getNom() + " - Preu: " + a2.getPreu() + "€ - IVA: " + a2.getIva() + "% - PVP: " + (a2.getPreu() + (a2.getPreu() * a2.getIva() / 100)) + "€");

    }
    
}
