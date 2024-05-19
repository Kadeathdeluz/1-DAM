/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici04;

/**
 * UF09 Exercici 04: Programa principal que realitza la gestió bancaria
 */
public class GestioBanc {
    
    public static void main(String arg[]) {

        // Creamos una cuenta corriente y otra de ahorro
        CompteCorrent cc = new CompteCorrent("ES6256465847", 1000);
        CompteEstalvi ce = new CompteEstalvi("ES9956415656", 3000);

        // Mostrem dades dels comptes
        cc.mostrar();
        ce.mostrar();
        System.out.println("");

        // Ingressem, retirem i mostrem
        cc.ingressar(1000);
        ce.retirar(500);
        cc.mostrar();
        ce.mostrar();
        System.out.println("");

        // Traspassem 1000 de cc a ce i mostrem
        cc.traspass(1000, ce);
        cc.mostrar();
        ce.mostrar();
        System.out.println("");

        // Calculem interesos i mostrem
        cc.calcularInteressos();
        ce.calcularInteressos();
        cc.mostrar();
        ce.mostrar();
    }    
    
}
