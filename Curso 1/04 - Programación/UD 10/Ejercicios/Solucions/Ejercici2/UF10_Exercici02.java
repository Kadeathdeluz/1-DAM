/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici02;
import java.util.*;

/**
 * UF10 Exercici 02: Programa que demana dos enters A i B, i calcula la divisió A/B.
 * Tracta les excepcions InputMismatchException i ArithmeticException.
 */
public class UF10_Exercici02 {
    
        public static void main(String[] args) {
            
        Scanner entrada = new Scanner(System.in);
        
        int A,B, resultat;       
        
        try {
            
            System.out.println("Introdueix el numerador: ");
            A = entrada.nextInt();
            
            System.out.println("Introdueix el denominador: ");
            B = entrada.nextInt();
            
            resultat = A / B;
            
            System.out.println(A + " / " + B + " = " + resultat);         
            
        } catch (InputMismatchException e) {
            
            System.out.println("Valor introduït incorrecte");
            e.printStackTrace();  
            
        } catch (ArithmeticException e) {
            
            System.out.println("Divisió entre cero: " + e); 
            e.printStackTrace(); 
            
        }
        
        System.out.println("Fin del programa");
    }
}
