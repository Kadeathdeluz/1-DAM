/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciA1;
import java.io.*;
import java.util.Scanner;
/**
 * UF11 Exercici A1: programa que demane a l'usuari introduir per teclat una ruta del sistema d'arxius
 * i mostra informnació sobre aquesta ruta (contingut de carpetes i arxius).
 */
public class UF11_ExerciciA1 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String rutaIntroduida = "";
        // Mentre la ruta introduïda siga distinta de buida (tecla intro)
        do {
            try {
                System.out.print("Introdueix la ruta (intro per a eixir): ");
                rutaIntroduida = entrada.nextLine();

                if (!rutaIntroduida.equals("")) {
                    File f = new File(rutaIntroduida);
                    mostraInfoRuta(f);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        } while (!rutaIntroduida.equals(""));

        System.out.println("Fi del programa");
    }

    public static void mostraInfoRuta(File ruta) throws FileNotFoundException {
        // Si la ruta no existeix llança una excepció
        if (!ruta.exists()) {
            throw new FileNotFoundException("La ruta introduida no existeix.");
        }
        // Si la ruta es un archiu mostra el nom de l'arxiu
        if (ruta.isFile()) {
            System.out.println("Nom de l'archiu: " + ruta.getName());
        // Si no, si la ruta és una carpeta, primer mostra la llista de carpetes i després mostra els arxiu    
        } else if (ruta.isDirectory()) 
        {
            File[] llista = ruta.listFiles();
            // Recorre la llista i mostra les carpetes
            for (int i = 0; i < llista.length; i++) {
                if (llista[i].isDirectory()) {
                    System.out.println("[*] " + llista[i].getName());
                }
            }
            // Recorre la llista i mostra els arxius
            for (int i = 0; i < llista.length; i++) {
                if (llista[i].isFile()) {
                    System.out.println("[A] " + llista[i].getName());
                }
            }
        }

        System.out.println("");
    }
    
}
