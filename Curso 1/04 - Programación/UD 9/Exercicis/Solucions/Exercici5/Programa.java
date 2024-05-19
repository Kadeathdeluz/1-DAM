/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici05;

/**
 * UF09 Exercici 5: Programa que gestiona les dades de empreses i empleats.
 */
public class Programa {
    
        public static void main(String[] args) {
        
        // Creem diverses empreses
        Empresa empresa1 = new Empresa("Mercadelice, S.L.", "B-123456789", "655.698.992", "Ctra. Nacional 332, s/n");
        Empresa empresa2 = new Empresa("OREMAPE, S.L.", "B-987654321", "964.66.58.99", "Av. Ausias March, nº 5");
        
        // Creem diversos empleats
        Empleat e1 = new Empleat("Gerard Serrà", "20.222.444-L", 900);
        Empleat e2 = new Empleat("Margarida Gil", "12.122.221-R", 1500, 35, "666.999.999" , "C/ Sant Josep, nº 12" );
        Empleat e3 = new Empleat("Josep Marco", "22.544.365-N", 2000, 44, "658.134.254", "C/ Segorb, 33");
        Empleat e4 = new Empleat("Maria Sanxis", "53.422.543-P", 1200);
        Empleat e5 = new Empleat("Julià Peris", "57.455.210-N", 2500, 25, "699.366.333", "Av. Sud-oest, 133 baix");
        
        // Afegim empleats en les empreses
        empresa1.afegirEmpleat(e1);
        empresa1.afegirEmpleat(e2);
        
        empresa2.afegirEmpleat(e3);
        empresa2.afegirEmpleat(e4);
        empresa2.afegirEmpleat(e5);
        
        // Eliminem un empleat
        empresa2.eliminarEmpleat(e5);
        
        // Mostrem la informació de tots els empleats de les dues emmpreses        
        empresa1.mostraInformacioEmpleats();      
        empresa2.mostraInformacioEmpleats();
        
        // Mostrem els sous de tots els empleats de les dues emmpreses
        empresa1.mostraSouEmpleats();
        System.out.printf("Empresa1: %20s - Suma total de sous bruts: %.2f - Suma total de sous nets: %.2f\n", empresa1.getNom(), empresa1.calcularTotalSouBrut(), empresa1.calcularTotalSouNet());
        System.out.println("");
        
        empresa2.mostraSouEmpleats();
        System.out.printf("Empresa2: %20s - Suma total de sous bruts: %.2f - Suma total de sous nets: %.2f\n", empresa2.getNom(), empresa2.calcularTotalSouBrut(), empresa2.calcularTotalSouNet());
        System.out.println("");
    }
    
    
}
