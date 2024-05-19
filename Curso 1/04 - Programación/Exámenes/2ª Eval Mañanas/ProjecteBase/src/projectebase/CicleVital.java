package projectebase;

import java.util.ArrayList;

public interface CicleVital {
    
    int NATALITAT_MINIMA = 2;
    
    void reproduir (ArrayList<Ciutada> ciutadans);
    
    void envellir (ArrayList<Ciutada> ciutadans);
    
}
