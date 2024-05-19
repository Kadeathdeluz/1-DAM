/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_E4;


/**
 * UF08 Exercici D4: Programa per a la gestió d'articles amb nom, preu, iva (sempre 21%) i quantitat.
 */
public class ProgramaArticle {
    
    public static void main(String[] args) {

        Article a1 = new Article("Camisa de quadres", 20, 21, 5);
        Article a2 = new Article("Pantaló de pana", 100, 21, 10);
        a1.mostra();
        a2.mostra();
        System.out.println("");

        a1.setNom("Jaqueta de llana");
        a1.setPreu(0);
        a1.setPreu(30);
        a2.setIva(10);
        a2.setQuantsEnQueden(-5);
        a2.setQuantsEnQueden(0);
        a1.mostra();
        a2.mostra();
        System.out.println("");
        
        if (a1.vendre(1000)) {
            System.out.println("He venut mil!");
        } else {
            System.out.println("No he venut mil, se cancela la venda per falta de stock");
        }
        
        if (a1.vendre(2)) {
            System.out.println("He venut 2!");
        } else {
            System.out.println("No he venut 2, se cancela la venda por falta de stock");
        }
        
        System.out.println("Vaig a emmagatzemar 3 més");
        if (a1.emmagatzemar(3)) {
            System.out.println("He emmagatzemat 3!");
        } else {
            System.out.println("No he emmagatzemat 3, no hi ha lloc");
        }

        a1.mostra();
        a2.mostra();
        System.out.println("");

        a1.setIva(5);
        a1.setIva(10);
        a2.setIva(12);
        a2.setIva(4);
        
        a1.mostra();
        a2.mostra();
    }

    
}
