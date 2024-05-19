/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici01;
import java.util.*;
/**
 * UF10 Exercici 01: Progrma que tracta l'excepció d'un número enter introduït per consola
 * quan no es correspon amb un enter.
 */
public class UF10_Exercici01 {
    
    public static void main(String[] args) {
        
        // Declaració de variables
        Scanner entrada = new Scanner(System.in);
        int A;       
        
        // Demanar dades
        try {
            System.out.print("Introdueix un número enter: ");
            A = entrada.nextInt();
            System.out.println("Valor introduït: " + A); 
        }
        
        // Tractar excepció
        catch(InputMismatchException e)         {
            System.out.println("Valor introduït incorrecte");
            e.printStackTrace();            
        }
        
        System.out.println("Fi del programa");
        
    }  
    
}
