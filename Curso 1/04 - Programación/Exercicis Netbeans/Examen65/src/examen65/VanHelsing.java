package examen65;

import ciutadansepd.Huma;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public final class VanHelsing extends Huma {
    private static int totalVanHelsings;
    
    public VanHelsing(){
        super("VAN_HELSING");
        totalVanHelsings++;
    }
    public static int getPoblacio() {
        return totalVanHelsings;
    }

}
