/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciB2;
import java.io.*;
import java.util.*;
/**
 * UF11 Exercici B2: Programa que mostra per pantalla la nota mitjana de cada alumne al costat del seu nom i cognom,
 * ordenat per nota mitjana de major a menor.
 */
public class UF11_ExerciciB2 {
    
        public static void main(String[] args) {
            
        try {
            // Intentem obrir l'arxiu
            File f = new File("Documentos/alumnos_notas.txt");
            Scanner lector = new Scanner(f);

            // ArrayList d'alumnes
            ArrayList<String> alumnes = new ArrayList<String>();

            // Comptador de número de línias
            int nLinia = 1;

            // Recorrem l'arxiu. Per a cada línia (alumne)
            while (lector.hasNextLine()) {
                // Trossegem la línia en paraules i agafem l'info de l'alumne
                String[] trossosLinia = (lector.nextLine()).split(" ");

                // Si la línea no tiene el formato correcto la saltamos
                if (trossosLinia.length < 2) {
                    System.err.println("Linia " + nLinia + " mal formatejada. L'ignorem.");
                    continue;
                }

                // Agafem l'info dels alumnes
                String nom = trossosLinia[0];
                String cognom = trossosLinia[1];

                // Calculem la seua nota mitjana
                int suma = 0;
                for (int j = 2; j < trossosLinia.length; j++) {
                    suma += Integer.valueOf(trossosLinia[j]);
                }
                double mitjana = (double) (suma) / (double) (trossosLinia.length - 2);

                // Creem una cadena amb nota mitjana, nom i cognom i l'afegim a l'ArrayList
                alumnes.add(String.format("%.2f %s", mitjana, nom + " " + cognom));

                // Actualitzem comptador de línias
                nLinia++;
            }

            // Ordenem la llista en ordre descendent
            Collections.sort(alumnes, Collections.reverseOrder());
            
            System.out.println("LLISTAT DE NOTES MITJANES DELS ALUMNES");
            System.out.println("--------------------------------------");
            
            // Mostra primer alumnes amb un 10 de mitjana (si n'hi ha)
            for (String a : alumnes) {
                if (a.split(" ")[0].equals("10.00"))
                    System.out.println(a);
            }
            
            // Mostrem la resta d'alumnes
            for (String a : alumnes) {
                if (!a.split(" ")[0].equals("10.00"))
                    System.out.println(a);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: L'arxiu no existeix");
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
        }
    }
    
}
