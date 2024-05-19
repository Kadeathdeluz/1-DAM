package exercicist11.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ExercicisT11PRG_B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //exercici1B();
        //exercici2B();
        //exercici3B();
    }

    private static void exercici1B() {
    }

    private static void exercici2B() {

    }

    private static void exercici3B() {
        ArrayList<String> contingut = new ArrayList<>();
        
        try {
            File origen = new File("Documentos/usa_personas.txt");
            Scanner entrada = new Scanner(origen);
            
            File desti = new File("Documentos/usa_personas_sorted.txt");
            FileWriter salida = new FileWriter(desti);
            
            while(entrada.hasNextLine()) {
                String linea = entrada.nextLine().trim();
                if(linea.length() != 0){
                    contingut.add(linea);
                }
            }
            Collections.sort(contingut);
            
            for(String element : contingut){
                salida.write(element + "\n");
            }
            entrada.close();
            salida.close();
        } catch (IOException e) {

        }
    }

}
