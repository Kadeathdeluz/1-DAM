package exercicist9.prg.exercici1;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Producte {
    private String nom;
    private int quantitat;
    
    public Producte(String nom, int quantitat) {
        this.nom = nom;
        this.quantitat = quantitat;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitat() {
        return quantitat;
    }
    
    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
    
    //Aunque no se pide, queda mejor visualizar los Producte así
    @Override
    public String toString() {
        return "Nom: " + nom 
                + ".\nQuantitat: " + quantitat + ".";
    }
}
