/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_E4;


/**
 * UF08 Exercici D4: Classe Article. Valida que les dades de l'article siguen correctes.
 */
public class Article {
    
    private String nom;
    private double preu;
    private int iva;
    private int quantsEnQueden;
    
    public static final int IVAGENERAL = 21;
    public static final int IVAREDUIT = 10;
    public static final int IVASUPERREDUIT = 4;

    public Article(String nom, double preu, int iva, int quantsEnQueden) {
        if (nom.equals("")) {
            System.err.println("ERROR: El nom no pot estar buit");
        } else if (preu <= 0) {
            System.err.println("ERROR: El preu no pot ser menor o igual a cero");
        } else if (iva != 21) {
            System.err.println("ERROR: L'iva ha de ser el 21%");
        } else if (quantsEnQueden < 0) {
            System.err.println("ERROR: El stock no pot ser menor que cero");
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
        if (iva != Article.IVAGENERAL && iva != Article.IVAREDUIT && iva != Article.IVASUPERREDUIT) {
            System.err.println("ERROR: IVA no vàlid");
        } else {
            this.iva = iva;
        }
    }

    public void setQuantsEnQueden(int quantsEnQueden) {
        if (quantsEnQueden < 0) {
            System.err.println("ERROR: El stock no pot ser menor que cero");
        } else {
            this.quantsEnQueden = quantsEnQueden;
        }
    }

    // Preu amb iva inclós
    public double getPVP() {
        return this.preu + (this.preu / 100.0 * this.iva);
    }

    // Preu amb descompte
    public double getPVPDescompte(double descompte) {
        double preu = this.getPVP();
        return preu - (preu * descompte / 100.0);
    }

    // Mètode vendre. Actualitza les quantitats si se pot vendre. 
    // Retorna true si la venda és correcta, false en cas contrari
    public boolean vendre(int unitats) {
        int quants = this.getQuantsEnQueden();
        // Si no se pot, retorna false
        if (unitats > quants) {
            return false;
        } // Si se pot, actualitza i retorna true
        else {
            this.setQuantsEnQueden(quants - unitats);
            return true;
        }
    }

    // Mètode vendre. Actualitza les quantitats si se pot emmagatzemar. 
    // Retorna true si l'emmagatzematge és possible
    // False si no és possible (exemple, números negatius)
    public boolean emmagatzemar(int unitats) {
        int quants = this.getQuantsEnQueden();
        if (quants + unitats > 0) {
            this.setQuantsEnQueden(quants + unitats);
            return true;
        } else {
            return false;
        }
    }

    // Mostra les dades
    public void mostra () {
        System.out.println("Nom:" + this.getNom() + " IVA:" + this.getIva() + " Preu:" + this.getPreu() + " PVP:" + this.getPVP() + " Unitats:" + this.getQuantsEnQueden());
    }

    
}
