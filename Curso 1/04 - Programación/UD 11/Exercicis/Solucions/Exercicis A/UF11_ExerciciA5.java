/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciA5;

import java.io.*;

/**
 * UF11 Exercici A5: Programa amb una funció boolean esborraTot(File f) que
 * esborre f: Si no existeix llança una excepció. Si és un arxiu l'esborra. Si
 * és un directori, esborra primer els seus arxius i després el propi directori
 * (per a poder esborrar un directori ha d'estar buit). Retorna ‘true’ si va
 * poder esborrar el ‘File f’ (‘false’ si no ha sigut possible).
 */
public class UF11_ExerciciA5 {

    public static void main(String[] args) {

        // Instanciem la clase File amb les rutes relatives de les carpetes a esborrar
        File fotografias = new File("Documentos/Fotografias");
        File libros = new File("Documentos/Libros");
        File documentos = new File("Documentos");

        boolean res = false;

        try {
            // Esborrem la carpeta 'Fotografias' i tot el seu contingut
            res = esborraTot(fotografias);
            if (res) {
                System.out.println("La carpeta 'Fotografias' s'ha esborrat.");
            }

            // Esborrem la carpeta 'Libros' i tot el seu contingut
            res = esborraTot(libros);
            if (res) {
                System.out.println("La carpeta 'Libros' s'ha esborrat.");
            }

            // Esborrem la carpeta 'Documentos' i tot el seu contingut
            res = esborraTot(documentos);
            if (res) {
                System.out.println("La carpeta 'Documentos' s'ha esborrat.");
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // Funció que esborra els arxius i les carpetes d'una ruta
    public static boolean esborraTot(File ruta) throws FileNotFoundException {

        boolean esborrat = false;

        // Si no existeix la ruta mostra una excepció
        if (!ruta.exists()) {
            throw new FileNotFoundException("La ruta introduïda no existeix.");
        } else {
            // Si és un arxiu l'esborra
            if (ruta.isFile()) {
                esborrat = ruta.delete();
            } else {
                // Si és una carpeta primer esborra els seus arxius i després esborra la carpeta
                if (ruta.isDirectory()) {
                    for (File f1 : ruta.listFiles()) {
                        f1.delete();
                    }
                    esborrat = ruta.delete();
                }
            }
        }
        return esborrat;
    }
}
