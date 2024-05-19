package exercicist6.exercicisTC;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class AdvancedHashMap {

    public static void main(String[] args) {
        String model, correu;
        HashMap<String, ArrayList<String>> contactes = new HashMap<String, ArrayList<String>>();
        ArrayList<String> correus;
        String exitModel = "S", exitCorreu = "S", exitMostrar = "S";
        Scanner lector = new Scanner(System.in);
        
        // Es demana a l'usuari la introducció de models de cotxe i correus vinculats
        do {
            System.out.println("Per favor, indica el model de vehicle:");
            model = lector.nextLine();
            ArrayList<String> llistaCorreus = new ArrayList<String>();
            do {
                System.out.println("Per favor, indical el correu electrònic de contacte:");
                correu = lector.nextLine();

                llistaCorreus.add(correu);
                System.out.println("Vol continuar escrivint correus? (S/N)");
                exitCorreu = lector.next();

                //Neteja del buffer per a la següent iteració
                lector.nextLine();
            } while (exitCorreu.equalsIgnoreCase("S"));

            if (contactes.containsKey(model)) {
                contactes.replace(model, llistaCorreus);
            } else {
                contactes.put(model, llistaCorreus);
            }

            System.out.println("Vol continuar escrivint models? (S/N)");
            exitModel = lector.next();
            
            //Neteja del buffer per a la següent iteració
            lector.nextLine();
        } while (exitModel.equalsIgnoreCase("S"));
        
        // Es mostra els correus vinculats a un model de vehicle. 
        do {
            System.out.println("Eligeix un model: ");
            model = lector.nextLine();

            correus = contactes.get(model);
            if (correus.isEmpty()) {
                System.out.println("El model " + model + " no conté correus vinculats.");
            } else {
                System.out.println("Els contactes vinculats al model " + model + " son:");
                // Imprimir els correus electrònics d'una forma més visual
                System.out.println(correus);
            }

            System.out.println("Vols veure més models? (S/N)");
            exitMostrar = lector.next();

            //Neteja del buffer per a la següent iteració
            lector.nextLine();
        } while (exitMostrar.equalsIgnoreCase("S"));
        lector.close();
    }
}
