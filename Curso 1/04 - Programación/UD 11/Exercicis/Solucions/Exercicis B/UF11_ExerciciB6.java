/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF11_ExerciciB6;
import java.io.*;
import java.util.*;

/**
 * UF11 Exercici B6: Programa que demana a l'usuari un número de qualsevol longitud, com per exemple
 * “1234”, i li diu a l'usuari si aquest número apareix en el primer milió de decimals del núm. pi (estan
 * en l'arxiu ‘pi-million.txt’). No està permés utilitzar cap llibreria ni classe ni mètode que realitze la
 * cerca. Has d'implementar l'algorisme de cerca tu mateix.
 */
public class UF11_ExerciciB6 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        try {
            // Demanem el numero enter a cercar
            System.out.print("Introdueix el número enter a cercar: ");
            String numeroCercar = entrada.nextLine();  
            
            // Intentem obrir el fitxer 'pi-million.txt'
            File fileNumeroPI = new File("Documentos/pi-million.txt");
            Scanner lector = new Scanner(fileNumeroPI);
            
            // Agafem tots els decimals del número PI del fitxer
            String decimalsPI = (lector.nextLine()).substring(2);
            lector.close();
            
            boolean trobat = false;
            int i=0;
            while (!trobat && i < decimalsPI.length() - numeroCercar.length()){
                // Comparem si 'numeroCercar' està al substring de 'decimalsPI'
                if(numeroCercar.equals(decimalsPI.substring(i, i+numeroCercar.length()))) {
                    trobat = true;
                }
                i++;
            }
            
            if(trobat) {
                System.out.println("El número " + numeroCercar + " s'ha trobat en la posició " + i );
            } else {
                System.out.println("El número " + numeroCercar + " no s'ha trobat" );
            }
            
        } catch (FileNotFoundException e){
            System.out.println("Error: L'arxiu no existeix");
        }catch (Exception e) {
            System.out.println("Error: " + e);
        } 
    }    
    
}
