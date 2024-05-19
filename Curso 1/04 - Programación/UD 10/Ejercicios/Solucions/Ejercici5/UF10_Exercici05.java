/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF10_Exercici05;
import java.util.*;
/**
 * UF10 Exercici 05: Programa amb tres funcions:
 * - void imprimeixPositiu(int p): Imprimeix el valor p. Llança una ‘Exception’ si p < 0
 * - void imprimeixNegatiu(int n): Imprimeix el valor n. Llança una ‘Exception’ si p >= 0
 * - La funció main cridar a totes dues funcions amb diferents valors.
 */
public class UF10_Exercici05 {
    
    public static void main(String[] args) throws Exception{
        
        Scanner entrada = new Scanner(System.in);
        int num;        

        for(int i = 0; i < 5; i++) {
            try {
                System.out.print("Introdueix un enter positiu: ");
                num = entrada.nextInt();
                imprimeixPositiu(num);
                
                System.out.print("Introdueix un enter negativo: ");
                num = entrada.nextInt();
                imprimeixNegatiu(num);
            } catch(InputMismatchException e) {
                System.out.println("Valor introduït incorrecte");
                entrada.nextLine();                
            } catch(Exception e) {
                System.out.println(e);            
            } 
        }
    }
    
    static void imprimeixPositiu(int p) throws Exception {
        if(p < 0) {
            throw new Exception ("Error: número negatiu");
        }
        
        System.out.println("El número positiu és el: " + p);        
    }
    
    static void imprimeixNegatiu(int n) throws Exception {
        if(n >= 0) {
            throw new Exception("Error: número positiu");
        }
        
        System.out.println("El número negatiu és el: " + n);
    }
    
}
