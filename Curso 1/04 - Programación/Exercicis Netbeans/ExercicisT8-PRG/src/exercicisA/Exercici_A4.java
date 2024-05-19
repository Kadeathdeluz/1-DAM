package exercicisA;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_A4 {

    public static void main(String[] args) {
        Article a1;

        a1 = new Article();
        a1.nom = "Pijama";
        a1.preu = 10;
        a1.quantsQueden = 3;
        System.out.println(a1.nom + " - Preu: " + a1.preu
                + "€ - IVA: "
                + a1.IVA + "% - PVP: "
                + ( a1.preu * (1 + a1.IVA / 100.0f) ) + "€");

    }
}

class Article {

    String nom;
    int preu;
    int IVA = 21;
    int quantsQueden;

}
