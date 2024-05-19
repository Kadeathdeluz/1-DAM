/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici01;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * UF09 Exercici 1: Programa que gestiona la classe Producte amb un ArrayList.
 */
public class ProgramaProducte {
    public static void main(String args[]) {
            
        // 1.- Creem 5 instàncies de Producte
        Producte p1 = new Producte("Pa", 6);
        Producte p2 = new Producte("Llet", 2);
        Producte p3 = new Producte("Pomes", 5);
        Producte p4 = new Producte("Bròcoli", 2);
        Producte p5 = new Producte("Carn", 2);
        
        // 2.- Creem un ArrayList de Productes
        ArrayList<Producte> llista = new ArrayList<Producte>();

        // 3.- Afegim els productes a l'ArrayList
        llista.add(p1);
        llista.add(p2);
        llista.add(p3);
        llista.add(p4);
        llista.add(p5);
        
        // 4.- Mostrem contingut de la llista
        mostraLlista(llista);
        
        // 5.- Eliminem dos elements
        llista.remove(0);
        llista.remove(0);
        
        // 6.- Afegim un element nou a la llista
        llista.add(0, new Producte("Peix", 3));

        // 7.- Mostrem contingut de la llista
        mostraLlista(llista);
        
        // Eliminar tots els valors de l'ArrayList
        llista.clear();
        
    }
    
    // Mostramos contenido de la lista
    public static void mostraLlista(ArrayList<Producte> llista) {

        System.out.println("LLISTA DE PRODUCTES AMB " + llista.size() + " ELEMENTS");
        for (Iterator<Producte> it = llista.iterator(); it.hasNext();) {
            Producte prodact = it.next();
            System.out.println(prodact.getNom() + ": " + prodact.getQuantitat());
        }
        System.out.println("");
    }
    
}
