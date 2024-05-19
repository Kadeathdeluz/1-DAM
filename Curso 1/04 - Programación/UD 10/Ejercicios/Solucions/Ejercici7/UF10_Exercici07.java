/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici07;
import java.util.*;
/**
 * UF10 Exercici 07: Programa que crea un ArrayList amb 5 objectes de la classe Gat.
 * Les dades de cada gat es demanen per pantalla. Si les dades no són correctes es tornen a demanar
 * de forma que al final queden 5 gat en l'ArrayList.
 */
public class UF10_Exercici07 {
    
    public static void main(String[] args) {
        
        // Creem l'ArrayList de tipus Gat
        ArrayList<Gat> llistaGats = new ArrayList<Gat>();
        
        Scanner entrada = new Scanner(System.in);
        
        String nom = "";
        int edat = 0;
        
        do         {            
            try
            {
                // Demanem el nom i edat del gat
                System.out.print("Introdueix el nom del gat: ");
                nom = entrada.nextLine();
                
                System.out.print("Introdueix l'edat del gat: ");
                edat = entrada.nextInt();
                entrada.nextLine();
                
                // Creem l'objecte Gat
                Gat g = new Gat(nom, edat);
                
                // Afegim el gat a l'ArrayList
                llistaGats.add(g);
                
            } catch(Exception e) {
                System.out.println(e);                
            }
            
        } while(llistaGats.size() < 5);
        
        // Mostrem la informació de l'ArrayList
        for(int i = 0; i < llistaGats.size(); i++) {
            System.out.println("Gat " + i);
            llistaGats.get(i).imprimir();
        }        
    }    
}
