/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciA3;
import java.io.File;
import java.util.Arrays;
/**
 * UF11 Exercici A3: Programa que canvia el nom de les carpetes i arxius continguts
 * en la carpeta Documents.
 */
public class UF11_ExerciciA3 {
    
        public static void main(String[] args) {

        ///////////////////////
        // RENOMBRAR CARPETES
        
        File docOrigen = new File("Documentos");
        File docDesti = new File("DOCS");
        docOrigen.renameTo(docDesti);
        
        File fotOrigen = new File("DOCS/Fotografias");
        File fotDesti = new File("DOCS/FOTOS");
        fotOrigen.renameTo(fotDesti);
        
        File libOrigen = new File("DOCS/Libros");
        File libDesti = new File("DOCS/LECTURAS");
        libOrigen.renameTo(libDesti);

        
        /////////////////////////////////////////
        // LLEVAR L'EXTENSIÓ DELS ARXIUS EN 'FOTOS'
        
        // Mostra la llista d'arxius ordenada abans de llevar les extensions
        System.out.println("Llistat d'arxius de " + fotDesti + " abans de llevar extensions: ");
        imprimirLlistaArxius(fotDesti);
        System.out.println("");

        // Renombra els arxius llevant-los l'extensió
        llevarExtensioArxius(fotDesti);

        // Mostra la llista d'arxius ordenada després de llevar les extensions
        System.out.println("Llistat d'arxius de " + fotDesti + " després de llevar extensions: ");
        imprimirLlistaArxius(fotDesti);
        System.out.println("");

        
        ////////////////////////////////////////////
        // LLEVAR L'EXTENSIÓ DELS ARXIUS EN LECTURAS'
        
        // Mostra la llista d'arxius ordenada abans de llevar les extensions
        System.out.println("Llistat d'arxius de " + libDesti + " abans de llevar extensions: ");
        imprimirLlistaArxius(libDesti);
        System.out.println("");

        // Renombra els arxius llevant-los l'extensió
        llevarExtensioArxius(libDesti);

        // Mostra la llista d'arxius ordenada després de llevar les extensions
        System.out.println("Llistat d'arxius de " + libDesti + " després de llevar extensions: ");
        imprimirLlistaArxius(libDesti);
        System.out.println("");
    }

    // Renombra els arxius llevant-los l'extensió
    public static void llevarExtensioArxius(File ruta) {
        // Recorre la llista d'arxius
        for (File f : ruta.listFiles()) {
            // Separa en dos el nom de l'arxius en base a la posició del punt
            String[] trozosArchivo = f.getName().split("\\.");
            File fDesti = new File(f.getParent() + "/" + trozosArchivo[0]);
            // Renombra l'arxiu
            f.renameTo(fDesti);
        }
    }

    // Mostra la llista d'arxius ordenada
    public static void imprimirLlistaArxius(File ruta) {
        File[] lista = ruta.listFiles();
        // Ordena la llista alfabèticament
        Arrays.sort(lista);
        // Recorre la llista mostrant el nom dels arxius
        for (File f : lista) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }
    
}
