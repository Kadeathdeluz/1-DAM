package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class FitxersDelPoble {

    public static final String ruta = "src/utils/noms.txt";
    
    /* Obté els noms d'una raza*/
    public static ArrayList<String> obtindreNoms(String raza) throws FileNotFoundException{
        ArrayList<String> noms = new ArrayList<>();
        File fitxer = new File(ruta);
        Scanner reader = new Scanner(fitxer);
        
        //Si troba la raza es posiciona a eixa linia
        if(reader.findInLine(raza).equals(raza)){
            int i = 1;    
            //Just després de la raza van 20 noms
            while(reader.hasNextLine() && i <=20){
                String nom = reader.nextLine();
                noms.add(nom);
                i++;
            }
        }
        return noms;
    }
    
    /* Obté un nom aleatori de la raza especificada */
    public static String nomAleatori(String raza) throws FileNotFoundException{
        String nom = raza;
        ArrayList<String> noms = obtindreNoms(raza);
        
        if(noms != null || !noms.isEmpty()){
            int random = (int) Math.random() * noms.size();
            nom = noms.get(random);
        }
        
        return nom;
    }
}
