/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici08;
import java.util.Scanner;
/**
 * UF09 Exercici 8: Programa principal per a gestionar el compte bancari DawBank.
 */
public class UF09_Exercici08 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        CompteBancari compte;
        
        // Demanem dades i creem el compte. Repetim mentre no siga vàlid.
        do {
            System.out.print("Introdueix el número IBAN: ");
            String iban = entrada.nextLine();
            System.out.print("Introdueix el titular del compte: ");
            String titular = entrada.nextLine();
            compte = new CompteBancari(iban, titular);
            
        } while (!compte.getValid());

        int opcio;
        double quantitat;

        do {
            System.out.println("Trieu una opció");
            System.out.println("1. Dades del compte.");
            System.out.println("2. IBAN.");
            System.out.println("3. Titular.");
            System.out.println("4. Saldo.");
            System.out.println("5. Ingrés.");
            System.out.println("6. Retirada.");
            System.out.println("7. Movimients.");
            System.out.println("8. Eixir.");

            opcio = entrada.nextInt();

            switch (opcio) {
                case 1:
                    compte.imprimirDades();
                    break;
                case 2:
                    System.out.println("IBAN: " + compte.getIban());
                    break;
                case 3:
                    System.out.println("Titular: " + compte.getTitular());
                    break;
                case 4:
                    System.out.println("Saldo: " + compte.getSaldo());
                    break;
                case 5:
                    System.out.print("Introduiu quantitat a ingressar: ");
                    quantitat = entrada.nextDouble();
                    if (compte.ingressar(quantitat)) {
                        System.out.println("Ingrés: OK");
                    } else {
                        System.out.println("Ingrés: ERROR");
                    }
                    break;
                case 6:
                    System.out.print("Introduiu quantitat a retirar:");
                    quantitat = entrada.nextDouble();
                    if (compte.retirar(quantitat)) {
                        System.out.println("Retirada: OK");
                    } else {
                        System.out.println("Retirada: ERROR");
                    }
                    break;
                case 7:
                    compte.imprimirMoviments();
                    break;
                case 8:
                    System.out.println("GRÀCIES PER UTILITZAR LA NOSTRA APLICACIÓ");
                    break;
                default:
                    System.out.println("Opció triada incorrecta.");
                    break;
            }
        } while (opcio != 8);

        entrada.close();
    }
}
