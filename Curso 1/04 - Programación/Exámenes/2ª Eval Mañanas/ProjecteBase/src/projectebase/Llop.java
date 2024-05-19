package projectebase;

import java.util.ArrayList;
import java.util.Random;

public class Llop extends Ciutada implements CicleVital{
    // Atributs de classe
    private static int totalLlops=0;       
    private static int ultimLlop=0;
    private static final Random ALEATORI = new Random();

    // Atributs d'instancia
    private final Vulnerable VULNERABLE;
    private int vida;
    
    
    public Llop (){
        super("LLOP" + ++ultimLlop);
        this.VULNERABLE = Vulnerable.Huma;
        this.vida = ALEATORI.nextInt(10) + 1;
        totalLlops++;
    }
    
        // Mètode que ens indica la població d'aquesta classe (cada subclasse tindrà el seu propi)
    public static int getPoblacio (){
        return totalLlops;
    }
    
    @Override
    public void setPoblacio(int numero){
        totalLlops += numero;
        super.setPoblacio(numero);
    }
    
    @Override
    public void reproduir (ArrayList<Ciutada> ciutadans){
        int numCadells = ALEATORI.nextInt(NATALITAT_MINIMA * 2) + 1;
        
        System.out.print("Estem de enhorabona! " + this.getNom() + 
                " ha tingut " + numCadells + " cadells: ");
        for(int i=0; i<numCadells; i++){
            if(i != 0){
                System.out.print(", ");
            }
            Llop cadell = new Llop();
            ciutadans.add(cadell);
            System.out.print(cadell.getNom());
        }
        System.out.println();
    }
    
    @Override
    public void morir (ArrayList<Ciutada> ciutadans){
        this.setPoblacio(-1);
        ciutadans.remove(this);
    }   
    
    @Override
    public void envellir (ArrayList<Ciutada> ciutadans){
        this.vida -= 2;
        if(this.vida <= 0){
            System.out.println(this.getNom() + " ha mort de vell.");
            this.morir(ciutadans);   
        }
    }

    /**
     * @return the vulnerable
     */
    public Vulnerable getVulnerable() {
        return this.VULNERABLE;
    }

    /**
     * Mètode que mostra les dades d'un llop
     * @return String
     */
    @Override
    public String toString(){
        return "Llop amb " + super.toString() ;
    } 
}
