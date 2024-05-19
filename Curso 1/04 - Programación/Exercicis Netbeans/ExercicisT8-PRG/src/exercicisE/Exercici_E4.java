package exercicisE;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Exercici_E4 {

    public static void main(String[] args) {
        Article a1, a2, a3;

        System.out.println("------------ ARTICLE 1 -----------------");
        a1 = new Article("Pijama", 10, 3,21);
        a1.imprimirDades();

        System.out.println("\n------------ ARTICLE 1 (modificat) -----------------");
        a1.setNom("Pijama 2.0");
        a1.setPreu(12);
        a1.setQuantsQueden(5);
        a1.imprimirDades();
        a1.vendre(3);
        System.out.println("DESPRÉS DE VENDRE");
        a1.imprimirDades();
        a1.emmagatzema(3);
        System.out.println("DESPRÉS DE EMMAGATZEMAR");
        a1.imprimirDades();

        System.out.println("\n------------ ARTICLE 2 -----------------");
        a2 = new Article("Formatge", 20, 1,4);
        a2.imprimirDades();
        a2.vendre(3);
        System.out.println("DESPRÉS DE VENDRE (AMB ERROR)");
        a2.imprimirDades();
        a2.emmagatzema(-1);
        System.out.println("DESPRÉS DE EMMAGATZEMAR (AMB ERROR)");
        a2.imprimirDades();
        
        System.out.println("\n------------ ARTICLE 3 -----------------");
        a3 = new Article("Bonometre", 5, 6,10);
        a3.imprimirDades();

    }
}

/**
 */
class Article {

    private String nom;
    private int preu;
    private int quantsQueden;
    private final int IVA;

    public Article(String nom, int preu, int quantsQueden, int iva) {
        //Que el nom no estiga buit, el preu siga major que 0, queden 0 o més productes i el tipus d'IVA siga correcte
        if ((!nom.isBlank()) && (preu > 0) && (quantsQueden >= 0) && tipusValid(iva)) {
            this.nom = nom;
            this.preu = preu;
            this.quantsQueden = quantsQueden;
            this.IVA = iva;

        } else {
            this.IVA = 21;
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

    public int getIVA() {
        return this.IVA;
    }

    public float getPVP() {
        return (getPreu() * (1 + IVA / 100.0f));
    }

    public float getPVPDescompte(int descompte) {
        return getPVP() * (1 - descompte / 100);
    }

    public boolean vendre(int quantitat) {
        if (quantitat <= this.quantsQueden) {
            this.setQuantsQueden(quantsQueden - quantitat);
            return true;
        }
        return false;
    }

    public boolean emmagatzema(int quantitat) {
        if (quantitat > 0) {
            this.setQuantsQueden(quantsQueden + quantitat);
        }
        return false;
    }

    private boolean tipusValid(int tipusIVA) {
        return tipusIVA == 21 || tipusIVA == 10 || tipusIVA == 4;
    }

    public void imprimirDades() {
        System.out.println(getNom() + " - Preu: " + getPreu()
                + "€ - IVA: "
                + IVA + "% - PVP: "
                + getPVP() + "€"
                + " - stock: " + getQuantsQueden());
    }

}
