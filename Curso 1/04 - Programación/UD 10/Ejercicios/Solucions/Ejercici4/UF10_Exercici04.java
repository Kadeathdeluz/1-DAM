/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici04;
import java.util.*;
/**
 * UF10 Exercici 04: Programa que crea un vector d'enters de grandària N (número aleatori entre
 * 1 i 100) amb valors aleatoris entre 1 i 10. Després se pregunta a l'usuari quina posició del
 * vector vol mostrar per pantalla, repetint-se una vegada i una altra fins que s'introduïsca un
 * valor negatiu. Maneja totes les possibles excepcions
 */
public class UF10_Exercici04 {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner (System.in);
        
        int N = (int)(Math.random() * 100 + 1);
        int[] vector = new int[N];
        
        for(int i = 0; i < N; i++) {
            vector[i] = (int)(Math.random() * 10 + 1);
        }
        
        int valor = 0;
        
        do{
            try {
                System.out.println("Introdueix la posició del vector a mostrar (número negatiu per a eixir): ");
                valor = entrada.nextInt();
                System.out.println("Valor en el vector: " + vector[valor]);  
                entrada.nextLine();                
            } catch(InputMismatchException e) {
                System.out.println("Valor introduït incorrecte");
                entrada.nextLine();                
            } catch(ArrayIndexOutOfBoundsException e) {
                if(valor >= 0) {
                    System.out.println("Posició fora dels límits del vector");   
                }                        
            }                    
            
        } while(valor >= 0);
        
        System.out.println("Fi del programa");
             
    }    
    
}
