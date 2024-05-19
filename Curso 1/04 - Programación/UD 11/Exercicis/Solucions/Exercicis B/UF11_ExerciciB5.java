/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciB5;
import java.io.*;
import java.util.*;
/**
 * UF11 Exercici B5: Programa que crea la carpeta ‘Diccionari’ amb tants arxius com lletres de l'abecedari
 * (A.txt, B.txt... Z.txt). Introduirà en cada arxiu les paraules de ‘diccionari.txt’ que comencen per
 * aquesta lletra
 */
public class UF11_ExerciciB5 {
    
    public static void main(String[] args) {

        // Instanciem la classe File amb la ruta relativa
        File dirDiccionari = new File("Documentos/Diccionari");

        // Creem la carpeta 'Diccionari'        
        boolean resultat = dirDiccionari.mkdir();

        if (resultat) {
            try {
                // ArrayList on emmagatzemarem totes les paraules del fitxer diccionari.txt
                ArrayList<String> alDiccionari = new ArrayList();

                // Lectura de diccionario.txt
                File fileDiccionari = new File("Documentos/diccionario.txt");
                Scanner reader = new Scanner(fileDiccionari);

                // Recorrem l'arxiu i anem afegint les paraules a l'ArrayList
                while (reader.hasNext()) {
                    alDiccionari.add(reader.nextLine());
                }

                // Tanquem l'arxiu
                reader.close();

                // Creem dins de la carpeta 'Diccionari' tants fitxers com lletres de l'abecedari (A.txt, B.txt, C.txt,...)
                for (int i = 65; i <= 90; i++) {
                    // Escriptura
                    FileWriter writer = new FileWriter(new File(dirDiccionari.getParent() + "/" + dirDiccionari.getName() + "/" + (char) i + ".txt"));

                    // Recorrem les paraules de l'ArrayList
                    for (String palabra : alDiccionari) {
                        // Escrivim a cada arxiu les paraules que comencen pel nom del fitxer
                        if (palabra.toUpperCase().startsWith(Character.toString((char) i))) {
                            writer.write(palabra + "\n");
                        }
                    }

                    // Tanquem arxiu
                    writer.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: L'arxiu no existeix");
            } catch (IOException e) {
                System.out.println("Error: " + e);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            System.out.println("La carpeta " + dirDiccionari.getName() + " no s'ha pogut crear.");
        }
    }
    
}
