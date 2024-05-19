/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciB4;
import java.io.*;
import java.util.*;
/**
 * UF11 Exercici B4: Programa que genera aleatòriament noms de persona (combinant noms i cognoms
 * de ‘usa_noms.txt’ i ‘usa_cognoms.txt’). Se li demanarà a l'usuari quants noms de persona desitja
 * generar i a quin arxiu afegir-los (per exemple ‘usa_persones.txt’)
 */
public class UF11_ExerciciB4 {
    
    public static void main(String[] args) {

        int numPersones;
        String ruta;

        Scanner entrada = new Scanner(System.in);

        try {

            System.out.print("Número de nom de persones a generar: ");
            numPersones = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Ruta on vols guardar l'arxiu generat: ");
            ruta = entrada.nextLine();

            // Arxius de lectura
            File fileNoms = new File("Documentos/usa_nombres.txt");
            File fileCognoms = new File("Documentos/usa_apellidos.txt");

            // ArrayList con los datos de los ficheros de lectura         
            ArrayList llistaNoms = llegirDadesArxiu(fileNoms);
            ArrayList llistaCognoms = llegirDadesArxiu(fileCognoms);

            // FileWriter per a escriptura
            FileWriter writer = new FileWriter(new File(ruta));

            // Generem el nom i cognom aleatòriament i l'escrivim al fitxer
            for (int i = 0; i < numPersones; i++) {
                int indexNom = (int) (Math.random() * llistaNoms.size());
                int indexCognom = (int) (Math.random() * llistaCognoms.size());
                writer.write(llistaNoms.get(indexNom) + " " + llistaCognoms.get(indexCognom) + "\n");
            }

            // Tanquem FileWriter i donem missatge final
            writer.close();
            System.out.println("Arxiu generat correctament: " + ruta);

        } catch (FileNotFoundException e) {
            System.out.println("Error: L'arxiu no existeix.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Torna un ArrayList amb les dades llegides del fitxer
    public static ArrayList llegirDadesArxiu(File f) throws FileNotFoundException {
        Scanner lector = new Scanner(f);
        ArrayList llista = new ArrayList();
        while (lector.hasNext()) {
            llista.add(lector.nextLine());
        }
        lector.close();
        return llista;
    }
    
}
