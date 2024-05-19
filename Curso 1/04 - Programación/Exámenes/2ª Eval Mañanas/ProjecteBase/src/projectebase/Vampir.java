package projectebase;

import java.util.ArrayList;

public class Vampir extends Ciutada{
    
    // Atributs de classe
    private static int totalVampirs=0;
    private static int ultimVampir=0;
    // Atributs d'instancia
    private final Vulnerable VULNERABLE;
    
    
    public Vampir (){
        super ("VAMPIR" + ++ultimVampir);
        this.VULNERABLE = Vulnerable.Llop;
        totalVampirs++;
    }
    
        // Mètode que ens indica la població d'aquesta classe (cada subclasse tindrà el seu propi)
    public static int getPoblacio (){
        return totalVampirs;
    }
    
    // Mètode per a reduir la població quan es mengen a un esser d'aquesta classe
    @Override
    public void setPoblacio(int numero){
        totalVampirs += numero;
        super.setPoblacio(numero);
    }
    
    @Override
    public Ciutada combat(Ciutada oponent){
        System.out.print(this.getNom() + " ataca " + oponent.getNom());
        if(oponent.getClass().getSimpleName().equals(getVulnerable().toString())){
            System.out.println(" pero mor a la llum del sol.");
            return this;
        }else{
            System.out.print(" guanya convertint-lo en el seu vampir personal ");
            return oponent;
        }
    }
    
    @Override
    public void morir(ArrayList<Ciutada> ciutadans){
        this.setPoblacio(-1);
        ciutadans.remove(this);
    }

    /**
     * @return the vulnerable
     */
    public Vulnerable getVulnerable() {
        return VULNERABLE;
    }

    /**
     * Mètode mostrar les dades del vampir
     * @param ciutadans
     */
    @Override
    public String toString(){
        return "Vampir amb " + super.toString() ;
    }
    
}
