/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;

/**
 * UF09 Exercici 03: Programa principal per a la gestió de l'inventari de mascotes
 */
public class ProgramaInventari {
    
     public static void main(String args[]) {
        
        // Creem unes quantes mascotes
        Gos gos1 = new Gos("Bobby", 5, "jugant", "Feb-2015", "Pastor alemà", false);
        Gos gos2 = new Gos("Lulu", 7, "dormint", "Abril-2013", "Rottweiler", false);
        Gat gat1 = new Gat("Lluna", 2, "dormint", "Sept-2018", "negre", false);
        Gat gat2 = new Gat("Pigues", 2, "rascant-se", "Juliol-2018", "blanc", true);
        Lloro lloro1 = new Lloro("Arturet", 10, "parlant", "Gener-2010", "llarg", true, "Murcia", true);
        Canari canari1 = new Canari("Basili", 5, "piulant", "Des-2015", "curt", true, "groc", true);
        
        // Creem inventari
        Inventari inventari = new Inventari();
        
        // Agegim mascotes a l'inventari
        inventari.inserirAnimal(gos1);
        inventari.inserirAnimal(gos2);
        inventari.inserirAnimal(gat1);
        inventari.inserirAnimal(gat2);
        inventari.inserirAnimal(lloro1);
        inventari.inserirAnimal(canari1);
        
        // Mostrem llista d'animals
        inventari.mostrarLlistaAnimals();
        System.out.println("");
        
        // Mostrem tots els animals
        inventari.mostrarTotsAnimals();
        
        // Eliminem un parell de mascotes
        inventari.eliminarAnimal(1);
        inventari.eliminarAnimal(2);
        
        // Mostrem llista d'animals
        inventari.mostrarLlistaAnimals();
        System.out.println("");
        
    }   
    
}
