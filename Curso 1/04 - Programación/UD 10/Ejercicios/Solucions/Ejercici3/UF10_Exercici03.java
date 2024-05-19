/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici03;
import java.util.*;
/**
 * UF10 Exercici 03: Programa que crea un vector tipus double de grandària 5 i després, utilitzant
 * un bucle, demane cinc valors per teclat i els introduïsca en el vector.
 * Detecta les possibles excepcions i finalment mostra el vector.
 */
public class UF10_Exercici03 {
    
        public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        double[] vector = new double[5];       

        int i =0;
        
        while (i < vector.length) {
            
            try {  
                
                System.out.println("Introdueix el valor de la posició " + i + ": ");
                vector[i] = entrada.nextDouble();
                i++;      // Si arriba a este punt és perquè no hi ha error i passa al seguent element. 
                
            } catch(InputMismatchException e) {
                
                System.out.println("Valor introduït incorrecte. Torna a introducir el valor.");
                e.printStackTrace(); 
                entrada.nextLine();
                
            }      
            
        }
        
        mostrarVector(vector);
        
    }
    
    public static void mostrarVector(double[] v) {
        
       System.out.print("Dades del vector [ ");

        for(int j = 0; j < v.length; j++) {
            System.out.print(v[j] + ", ");
        }

        System.out.println("\b\b ]"); 
    }
}
