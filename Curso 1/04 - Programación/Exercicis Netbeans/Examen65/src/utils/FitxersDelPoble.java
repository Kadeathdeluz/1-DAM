package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class FitxersDelPoble {

    private static File fitxer = new File("CensPobleDormit.txt");
    
    /* Escriu una línia de text al fitxer CensPobleDormit.txt */
    public static void escriureFitxer(String linea) throws IOException{
        //Per simplificació afegim apend=true per a que cada nova línea siga afegida al fitxer sense esborrar res
        FileWriter writer = new FileWriter(fitxer, true);
        
        //Escriu la linia al fitxer i tanca el writer
        writer.write(linea);
        writer.close();
    }
    
}
