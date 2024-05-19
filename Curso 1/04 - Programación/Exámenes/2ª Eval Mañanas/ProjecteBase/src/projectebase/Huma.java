package projectebase;

import java.util.ArrayList;
import java.util.Random;

public class Huma extends Ciutada implements CicleVital{
    // Atributs de classe
    private static int totalHumans=0;
    private static int ultimHuma=0;
    private static final Random ALEATORI = new Random();

    // Atributs d'instancia
    private final Vulnerable VULNERABLE;
    private int vida;
    
    
    public Huma (){
        super("HUMA" + ++ultimHuma);
        this.VULNERABLE = Vulnerable.Vampir;
        this.vida = ALEATORI.nextInt(6) + 1;
        totalHumans++;
    }
    
        // Mètode que ens indica la població d'aquesta classe (cada subclasse tindrà el seu propi)
    public static int getPoblacio() {
        return totalHumans;
    }
    
    // Mètode per a reduir la població quan es mengen a un esser d'aquesta classe
    @Override
    public void setPoblacio(int numero){
        totalHumans += numero;
        super.setPoblacio(numero);
    }
    
    @Override
    public void reproduir (ArrayList<Ciutada> ciutadans){
        int numFills = NATALITAT_MINIMA + ALEATORI.nextInt(NATALITAT_MINIMA * 3 - NATALITAT_MINIMA) + 1;
        System.out.print("Estem de enhorabona! " + this.getNom() + 
                " ha tingut " + numFills + " fills: ");
        for(int i=0; i<numFills; i++){
            if(i != 0){
                System.out.print(", ");
            }
            Huma fill = new Huma();
            ciutadans.add(fill);
            System.out.print(fill.getNom());
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
        this.vida--;
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
     * Mètode que mostra les dades d'un humà
     * @param ciutadans
     * @param estimat
     */
    @Override
    public String toString(){
        return "Huma amb " + super.toString() ;
    }
   
    
}
