/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciA2;
import java.io.*;
import java.util.*;
/**
 * UF11 Exercici A2: programa que demane a l'usuari introduir per teclat una ruta del sistema d'arxius
 * i mostra informnació sobre aquesta ruta (contingut de carpetes i arxius) així com de les propietat de
 * cadasqun dels elements que conté.
 */
public class UF11_ExerciciA2 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String rutaIntroduida = "", resposta;
        boolean info = false;
        // Mentre la ruta introduïda siga distinta de buida (tecla intro)
        do {
            try {
                System.out.print("Introdueix la ruta (intro per a eixir): ");
                rutaIntroduida = entrada.nextLine();

                if (!rutaIntroduida.equals("")) {
                    File f = new File(rutaIntroduida);
                    mostraInfoRuta(f, true);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        } while (!rutaIntroduida.equals(""));

        System.out.println("Fi del programa");
    }

    public static void mostraInfoRuta(File ruta, boolean info) throws FileNotFoundException {
        // Si la ruta no existeix llança una excepció
        if (!ruta.exists()) {
            throw new FileNotFoundException("La ruta introduïda no existeix.");
        }
        // Si la ruta és un arxiu mostra el nom de l'arxiu
        if (ruta.isFile()) {
            System.out.println("Nom de l'arxiu: " + ruta.getName());
        // Si no, si la ruta és una carpeta, primer mostra la lllista de carpetes i després mostra els arxius    
        } else if (ruta.isDirectory()) 
        {
            File[] llista = ruta.listFiles();
            // Ordena la llista alfabèticament
            Arrays.sort(llista);
            // Recorre la llista i mostra les carpetes ordenades
            for (int i = 0; i < llista.length; i++) {
                if (llista[i].isDirectory()) {
                    if (info) {
                        System.out.println("[*] " + llista[i].getName() + "\t" + llista[i].length() + " bytes\t" + new Date(llista[i].lastModified()));
                    } else {
                        System.out.println("[*] " + llista[i].getName());
                    }
                }
            }
            // Recorre la llista i mostra els arxius ordenats
            for (int i = 0; i < llista.length; i++) {
                if (llista[i].isFile()) {
                    if (info) {
                        System.out.println("[A] " + llista[i].getName() + "\t" + llista[i].length() + " bytes\t" + new Date(llista[i].lastModified()));
                    } else {
                        System.out.println("[A] " + llista[i].getName());
                    }
                }
            }
        }

        System.out.println("");
    }
}
