package projectebase;

import java.util.ArrayList;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Mestis extends Ciutada {

    private static int totalMestis=0;
    
    public Mestis(String nom, int vida, int forza) {
        super(nom,vida,forza,Vulnerable.Tots);
        totalMestis++;
    }

    /**
     * @return the totalMestis
     */
    public static int getTotalMestis() {
        return totalMestis;
    }

    /**
     * @param aTotalMestis the totalMestis to set
     */
    public static void setTotalMestis(int aTotalMestis) {
        totalMestis = aTotalMestis;
    }
    
    @Override
    public void morir(ArrayList<Ciutada> ciutadans) {
        this.setPoblacio(-1);
        ciutadans.remove(this);
    }

    @Override
    public Ciutada combat(Ciutada oponent){
        //La forza i la vida de this (el ciutada)
        int forza1 = this.getForca();
        int vida1 = this.getVida();
        
        //La forza i la vida de l'oponent
        int forza2 = oponent.getForca();
        int vida2 = oponent.getVida();
        
        if(vida2 > 1) {
            //do
        }
        
        System.out.print(this.getNom() + " ataca " + oponent.getNom());
        if(oponent.getClass().getSimpleName().equals(this.getVulnerable().toString())){
            this.setVida(vida1-forza2);
            return this;
        }else{
            oponent.setVida(vida2-forza1);
            return oponent;
        }
    }
    
    @Override
    public String toString(){
        return "Mestís amb " + super.toString() ;
    }

    

}
