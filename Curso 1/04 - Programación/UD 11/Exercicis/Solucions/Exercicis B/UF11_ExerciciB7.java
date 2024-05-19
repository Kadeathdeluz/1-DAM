/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciB7;
import java.io.*;
import java.util.*;
/**
 * UF11 Exercici B7: Programa que llig un document de text i mostra per pantalla algunes dades
 * estadístiques: núm. de línies, núm. de paraules, núm. de caràcters i quines són les 10 paraules més
 * comunes (i quantes vegades apareixen). Prova el programa amb els arxius de la carpeta ‘Llibres’.
 */
public class UF11_ExerciciB7 {
    
    public static void main(String[] args) {

        System.out.println("ESTADÍSTIQUES DE LLIBRES");
        System.out.println("------------------------");
        System.out.println("");

        try {
            // Obtenim la llista d'arxius de la carpeta Libros
            File rutaLlibres = new File("Documentos/Libros");
            File[] llistaLlibres = rutaLlibres.listFiles();

            // Per a cada arxiu
            for (File llibre : llistaLlibres) {
                
                // Lector d'arxius
                Scanner lector = new Scanner(llibre);
                
                // Inicialitzem comptadors i Hashtable
                int numLin = 0, numPar = 0, numCar = 0;
                Hashtable<String, Integer> hashParaules = new Hashtable<String, Integer>();
                
                // Processem línies mentre quedi alguna cosa per llegir
                while (lector.hasNext()) {
                    // Línia
                    String linia = lector.nextLine();
                    numLin++;

                    // Paraules
                    String[] paraules = linia.split(" ");
                    numPar += paraules.length;

                    // Per a cada paraula actualitzem numCar i fiquem a la Hashtable
                    for (String paraula : paraules) {
                        char[] lletres = paraula.toCharArray();
                        numCar += lletres.length;

                        // Si ja existeix la paraula augmentem el seu valor, si no existeix la guardem
                        if (hashParaules.containsKey(paraula)) {
                            hashParaules.put(paraula, hashParaules.get(paraula) + 1);
                        } else {
                            hashParaules.put(paraula, 1);
                        }
                    }
                }
                
                // Mostrem estadístiques del llibre
                System.out.println("Llibre: " + llibre.getName());
                System.out.println("Línias totals: " + numLin);
                System.out.println("Número de paraules: " + numPar);
                System.out.println("Número de caràcters: " + numCar);
                System.out.println("Les 10 paraules més comunes sén: ");
                
                // Mostra les 10 paraules més comunes
                mostraParaulesMesComunes(hashParaules);
                
                System.out.println("");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: L'arxiu no existeix");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Mostra las 10 paraules más comunes
    public static void mostraParaulesMesComunes(Hashtable<String, Integer> t) {

        // Obtindrem una llista ordenada per n. de paraules
        ArrayList<Map.Entry<String, Integer>> l = new ArrayList(t.entrySet());
        
        Collections.sort(l, Collections.reverseOrder(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }));

        // Imprimeix les 10 paraules més comunes
        for (int i = 0; i < 10; i++) {
            System.out.println(l.get(i));
        }
    }
    
}
