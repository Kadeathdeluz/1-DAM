package exercicisB;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_B4 {

    public static void main(String[] args) {
        Article a1, a2;

        System.out.println("------------ ARTICLE 1 -----------------");
        a1 = new Article("Pijama", 10, 21, 3);
        System.out.println(a1.nom + " - Preu: " + a1.preu
                + "€ - IVA: "
                + a1.IVA + "% - PVP: "
                + (a1.preu * (1 + a1.IVA / 100.0f)) + "€");
        
        System.out.println("------------ ARTICLE 1 (modificat) -----------------");
        a1.nom = "Pijama 2.0";
        a1.preu = 12;
        a1.quantsQueden = 5;
        System.out.println(a1.nom + " - Preu: " + a1.preu
                + "€ - IVA: "
                + a1.IVA + "% - PVP: "
                + (a1.preu * (1 + a1.IVA / 100.0f)) + "€");
        
        System.out.println("------------ ARTICLE 2 -----------------");
        a2 = new Article("Camisa", -20, 21, 1);
        System.out.println(a2.nom + " - Preu: " + a2.preu
                + "€ - IVA: "
                + a2.IVA + "% - PVP: "
                + (a2.preu * (1 + a2.IVA / 100.0f)) + "€");

    }
}

/**
 */
class Article {

    String nom;
    int preu;
    int IVA = 21;
    int quantsQueden;

    public Article(String nom, int preu, int iva, int quantsQueden) {

        //Que el nom no estiga buit, el preu siga major que 0, l'IVA siga 21 i queden 0 o més productes
        if ( (!nom.isBlank()) && (preu > 0) && (iva == 21) && (quantsQueden >= 0) ) {
            this.nom = nom;
            this.preu = preu;
            this.IVA = iva;
            this.quantsQueden = quantsQueden;
        } else {
            System.err.println("ERROR, algún valor incorrecte.");
        }
    }

}
