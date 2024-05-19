/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici02;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * UF09 Exercici 02: Programa que gestiona una jerarquia de classes de planetes i satèlits
 */
public class ProgramaAstres {
    
    // Mostra la llista d'astres (sols els noms)
    public static void mostrarLlistaAstres(ArrayList astres) {
        System.out.println("=== LLISTA D'ASTRES ===");
        for (int i = 0; i < astres.size(); i++) {
            Astre a = (Astre) astres.get(i);
            System.out.println("Astre " + i + ": " + a.getNom());
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Creem una llista
        ArrayList<Astre> astres = new ArrayList<Astre>();

        // Instanciem planetes
        Planeta terra = new Planeta("Terra", 5.97E24, 12742.0, 1.0, 365.25, 14.05, 9.78, 146600000.0);
        Planeta venus = new Planeta("Venus", 4.869E24, 12103.6, 243.02, 584.0, 463.85, 8.87, 108200000.0);
        Planeta mart = new Planeta("Mart", 6.42E23, 6794.4, 24.62, 686.97, -46.0, 3.711, 227940000.0);
        
        // Instanciem satèl·lits
        Satel_lit lluna = new Satel_lit("Lluna", 7.349E22, 3474.0, 27.5, 27.5, -153.0, 1.62, 384400.0, terra);
        Satel_lit fobos = new Satel_lit("Fobos", 1.072E16, 11000.0, 0.0, 0.319, -40.15, 0.0084, 6000, mart);
        Satel_lit deimos = new Satel_lit("Deimos", 2.244E15, 12400.0, 0.0, 1.262, -40.15, 0.0039, 23460, mart);
        
        // Afegim satèl·lits a planetes
        terra.afegirSatel_lit(lluna);
        mart.afegirSatel_lit(fobos);
        mart.afegirSatel_lit(deimos);

        // Afegim planetes i satèlits a la llista
        astres.add(terra);
        astres.add(venus);
        astres.add(mart);
        astres.add(lluna);
        astres.add(fobos);
        astres.add(deimos);

        // Menú per elegir astre i mostrar la seua informació. Es repiteix fins introduir -1
        int opcio;
        do {
            // Mostrem llista d'astres
            mostrarLlistaAstres(astres);
            
            // Demanem que trie un número de la llista per mostrar-lo
            System.out.print("Tria un número d'astre (-1 per eixir): ");
            opcio = in.nextInt();

            // Si número válid, mostrar info de l'astre            
            if (opcio >= 0 && opcio < astres.size()) {
                Astre a = (Astre) astres.get(opcio);
                a.mostra(); 
                // Demanem enter per continuar
                    System.out.println("Enter per continuar");
                    in.nextLine();
                    in.nextLine();
            } // Sinó és -1 per finalitzar donem error.           
            else { if (opcio != -1) {
                System.out.println("Opció incorrecta");
                 }
            }

        } while (opcio!=-1);

    }
    
}
