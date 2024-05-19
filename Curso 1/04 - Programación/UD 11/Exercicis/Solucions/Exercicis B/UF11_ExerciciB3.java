/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciB3;
import java.io.*;
import java.util.*;
/**
 * UF11 Exercici B3: Programa que demana a l'usuari un nom d'arxiu A per a lectura i un altre nom d'arxiu 
 * per a escriptura. Llegirà el contingut de l'arxiu A (per exemple ‘usa_persones.txt’) i ho escriurà
 * ordenat alfabèticament en B (per exemple ‘usa_persones_sorted.txt’).
 */
public class UF11_ExerciciB3 {
    
    public static void main(String[] args) {
        try {
            
            String strOrigen;
            String strDesti;
            
            // Demanem noms de fitxers per llegir i escriure
            Scanner in = new Scanner(System.in);
            System.out.print("Arxiu a llegir: ");
            strOrigen = in.nextLine();
            System.out.print("Arxiu a escriure: ");
            strDesti = in.nextLine();
            
            // Creem els File
            File fileOrigen = new File(strOrigen);
            File fileDesti = new File(strDesti);
            
            // Comprovem si l'arxiu d'origen existeix
            if (!fileOrigen.exists()) {
                throw new FileNotFoundException();
            }
            
            // Objectes per a lectura i escriptura
            Scanner reader = new Scanner(fileOrigen);
            FileWriter writer = new FileWriter(fileDesti);
            
            // Llegim l'arxiu d'origen i ho emmagatzemem tot en un ArrayList
            ArrayList<String> nomPersones = new ArrayList();
            while (reader.hasNext()) {
                nomPersones.add(reader.nextLine());
            }
            
            // Ordenem l'ArrayList
            Collections.sort(nomPersones);
            
            // Recorrem l'ArrayList i anem escrivint l'arxiu de destinació
            for (String nom : nomPersones) {
                writer.write(nom + "\n");
            }
            
            // Tanquem el Scanner i el FileWriter
            reader.close();
            writer.close();

            System.out.println("L'arxiu " + fileDesti.getName() + " s'ha creat correctament.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: L'arxiu no existeix.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
