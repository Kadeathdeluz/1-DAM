/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciA4;
import java.io.File;
/**
 * UF11 Exercici A4: Programa que crea les carpetes "Les meues Coses" i "Afabet"
 */
public class UF11_ExerciciA4 {
    
    public static void main(String[] args) {

        // Instanciem la clase File amb les rutes relatives de les carpetes a crear
        File misCosas = new File("Documentos/Mis Cosas");
        File alfabeto = new File("Documentos/Alfabeto");

        // Creem les carpetes        
        boolean resultat1 = misCosas.mkdir();
        System.out.println("S'ha creat la carpeta 'Documentos/Mis Cosas'? " + resultat1);
        boolean resultat2 = alfabeto.mkdir();
        System.out.println("¿S'ha creat la carpeta 'Documentos/Alfabeto'? " + resultat2);

        // Instanciem la clase File amb les rutes d'origen i desti relatives
        File fotOrigen = new File("Documentos/Fotografias");
        File fotDesti = new File("Documentos/Mis Cosas/Fotografias");

        File libOrigen = new File("Documentos/Libros");
        File libDesti = new File("Documentos/Mis Cosas/Libros");

        // Movemo les carpetes 'Fotografias' i 'Libros' dins de 'MisCosas'
        resultat1 = fotOrigen.renameTo(fotDesti);
        System.out.println("¿S'ha mogut la carpeta 'Documentos/Fotografias' a 'Documentos/Mis Cosas/Fotografias'? " + resultat1);
        resultat2 = libOrigen.renameTo(libDesti);
        System.out.println("¿Se ha mogut la carpeta 'Documentos/Libros' a 'Documentos/Mis Cosas/Libros'? " + resultat2);

        // Creem dins de la carpeta 'Alfabeto', una carpeta per cada lletra de l'alfabet (en mayúscula)
        for (int i = 'A'; i <= 90; i++) {
            File novaCarpeta = new File(alfabeto.getParent() + "/" + alfabeto.getName() + "/" + (char) i);
            novaCarpeta.mkdir();
        }
    }
}
