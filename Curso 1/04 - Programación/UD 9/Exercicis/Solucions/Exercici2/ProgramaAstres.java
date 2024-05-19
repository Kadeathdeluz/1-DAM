/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ceedcv.ggarrido.ProgramaAstres;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ggarrido
 */
public class ProgramaAstres {

    // Mostra la llista d'astres (sols els noms)
    public static void mostrarLlistaAstres(ArrayList astres) {
        System.out.println("=== LLISTA D'ASTRES ===");
        for (int i = 0; i < astres.size(); i++) {
            Astre a = (Astre) astres.get(i);
            if(a.getClass().getSimpleName().equals("Planeta")){
                Planeta p = (Planeta) a;
                System.out.println("Planeta " + i + ": " + p.getNom());
                if(p.getTeSat()){
                    System.out.println("\tTe els satelits: ");
                    for (int j = 0; j < astres.size(); j++) {
                        Astre as = (Astre) astres.get(j);
                        if(as.getClass().getSimpleName().equals("Satel_lit")){
                            Satel_lit s = (Satel_lit) as;
                            if(s.getPlaneta().getNom().equals(p.getNom())){
                                System.out.println("\t\tSatelit: " + s.getNom());
                            }
                        }
                    }        
                }
            }           
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Creem una llista
        ArrayList<Astre> astres = new ArrayList<Astre>();

        // Instanciem planetes
        Planeta terra = new Planeta("Terra", 5.97E24, 12742.0, 1.0, 365.25, 14.05, 9.78, 146600000.0, true);
        Planeta venus = new Planeta("Venus", 4.869E24, 12103.6, 243.02, 584.0, 463.85, 8.87, 108200000.0);
        Planeta mart = new Planeta("Mart", 6.42E23, 6794.4, 24.62, 686.97, -46.0, 3.711, 227940000.0, true);
        
        // Instanciem satèl·lits
        Satel_lit lluna = new Satel_lit("Lluna", 7.349E22, 3474.0, 27.5, 27.5, -153.0, 1.62, 384400.0, terra);
        Satel_lit fobos = new Satel_lit("Fobos", 1.072E16, 11000.0, 0.0, 0.319, -40.15, 0.0084, 6000, mart);
        Satel_lit deimos = new Satel_lit("Deimos", 2.244E15, 12400.0, 0.0, 1.262, -40.15, 0.0039, 23460, mart);
        
        // Afegim planetes i satèlits a la llista
        astres.add(terra);
        astres.add(venus);
        astres.add(mart);
        astres.add(lluna);
        astres.add(fobos);
        astres.add(deimos);

        mostrarLlistaAstres(astres);
    }
}
