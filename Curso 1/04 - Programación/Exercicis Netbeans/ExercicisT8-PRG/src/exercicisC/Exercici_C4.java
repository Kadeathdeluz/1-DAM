package exercicisC;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_C4 {

    public static void main(String[] args) {
        Article a1, a2;

        System.out.println("------------ ARTICLE 1 -----------------");
        a1 = new Article("Pijama", 10, 21, 3);
        System.out.println(a1.getNom() + " - Preu: " + a1.getPreu()
                + "€ - IVA: "
                + a1.getIVA() + "% - PVP: "
                + (a1.getPreu() * (1 + a1.getIVA() / 100.0f)) + "€");

        System.out.println("\n------------ ARTICLE 1 (modificat) -----------------");
        a1.setNom("Pijama 2.0");
        a1.setPreu(12);
        a1.setQuantsQueden(5);
        System.out.println(a1.getNom() + " - Preu: " + a1.getPreu()
                + "€ - IVA: "
                + a1.getIVA() + "% - PVP: "
                + (a1.getPreu() * (1 + a1.getIVA() / 100.0f)) + "€");

        System.out.println("\n------------ ARTICLE 2 -----------------");
        a2 = new Article("Camisa", 20, 21, 1);
        System.out.println(a2.getNom() + " - Preu: " + a2.getPreu()
                + "€ - IVA: "
                + a2.getIVA() + "% - PVP: "
                + (a2.getPreu() * (1 + a2.getIVA() / 100.0f)) + "€");
        
        System.out.println("\n------------ ARTICLE 2 (modificat) -----------------");
        a2.setNom("");
        a2.setPreu(-1);
        a2.setQuantsQueden(-1);
        System.out.println(a2.getNom() + " - Preu: " + a2.getPreu()
                + "€ - IVA: "
                + a2.getIVA() + "% - PVP: "
                + (a2.getPreu() * (1 + a2.getIVA() / 100.0f)) + "€");

    }
}

/**
 */
class Article {

    private String nom;
    private int preu;
    private int IVA = 21;
    private int quantsQueden;

    public Article(String nom, int preu, int iva, int quantsQueden) {

        //Que el nom no estiga buit, el preu siga major que 0, l'IVA siga 21 i queden 0 o més productes
        if ((!nom.isBlank()) && (preu > 0) && (iva == 21) && (quantsQueden >= 0)) {
            this.nom = nom;
            this.preu = preu;
            this.IVA = iva;
            this.quantsQueden = quantsQueden;
        } else {
            System.err.println("ERROR, algún valor incorrecte - '" + nom + "'.");
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (!nom.isBlank()) {
            this.nom = nom;
        } else {
            System.err.println("ERROR amb el nom '" + nom + "'.");
        }
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        if (preu > 0) {
            this.preu = preu;
        } else {
            System.err.println("ERROR amb el preu '" + preu + "'.");
        }
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int iva) {
        if (iva == 21) {
            this.IVA = iva;
        }
        else {
            System.err.println("ERROR, el IVA ha de ser 21%");
        }
    }

    public int getQuantsQueden() {
        return quantsQueden;
    }

    public void setQuantsQueden(int quantsQueden) {
        if (quantsQueden >= 0) {
            this.quantsQueden = quantsQueden;
        } else {
            System.err.println("ERROR amb la quantitat '" + quantsQueden + "'.");
        }
    }

}
