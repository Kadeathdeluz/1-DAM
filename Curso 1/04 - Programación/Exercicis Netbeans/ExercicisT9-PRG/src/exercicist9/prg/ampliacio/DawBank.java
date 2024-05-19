package exercicist9.prg.ampliacio;

import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class DawBank {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        CompteBancari compte;
        String iban, titular;
        int opcio;
        
        System.out.println("Benvingut a DAWBANK, anem a crear un compte per a poder començar.");

        //Bucle per a crear un compte correctament (IBAN vàlid)
        do {
            System.out.println("Introdueïx el IBAN: ");
            //iban = entrada.nextLine();
            iban = "ES1234567890123456789012";
            
            System.out.println("Introdueïx el titular: ");
            //titular = entrada.nextLine();
            titular = "Paco Pérez";
            
            compte = new CompteBancari(iban, titular);
            
            if (!compte.comprovaIban()) {
                System.out.println("ERROR, iban incorrecte.");
            }
            
        } while (!compte.comprovaIban());

        //Bucle per al menú
        do {
            mostraMenu();
            opcio = entrada.nextInt();
            switchOpcions(opcio, compte);
            
            entrada.nextLine(); //neteja el buffer
        } while (opcio != 8);
        
        entrada.close();
    }
    
    public static void mostraMenu() {
        System.out.println("1. Dades del compte. Mostrarà l' IBAN, el titular i el saldo.\n"
                + "2. IBAN. Mostrarà l'IBAN.\n"
                + "3. Titular. Mostrarà el titular.\n"
                + "4. Saldo. Mostrarà el saldo disponible.\n"
                + "5. Ingrés. Demanarà la quantitat a ingressar i realitzarà l'ingrés si és possible.\n"
                + "6. Retirada. Demanarà la quantitat a retirar i realitzarà la retirada si és possible.\n"
                + "7. Moviments. Mostrarà una llista amb l'historial de moviments.\n"
                + "8. Eixir. Finalitza el programa.");
    }
    
    private static void switchOpcions(int opcio, CompteBancari compte) {
        switch (opcio) {
            case 1 -> {
                System.out.println(compte); //crida al métode toString de la clase CompteBancari -> mostra les dades
            }
            case 2 -> {
                System.out.println("IBAN: " + compte.getIban());
            }
            case 3 -> {
                System.out.println("Titular: " + compte.getTitular());
            }
            case 4 -> {
                System.out.println("Saldo: " + compte.getSaldo());
            }
            case 5 -> {
                afigMoviment(compte, TipusMoviment.INGRES);
            }
            case 6 -> {
                afigMoviment(compte, TipusMoviment.RETIRADA);
            }
            case 7 -> {
                mostraMoviments(compte);
            }
            default -> {
                System.out.println("Fins aviat!");
            }
        }
    }
    
    private static void afigMoviment(CompteBancari compte, TipusMoviment tipus) {
        Scanner entrada = new Scanner(System.in);
        Moviment moviment;
        float quantitat;
        
        do {
        System.out.print("Introdueïx la quantitat: ");
        quantitat = entrada.nextFloat();
        
        entrada.nextLine(); //limpia el buffer
        }while(quantitat <= 0);
        
        moviment = new Moviment(compte.getSaldo(), quantitat, tipus);
        
        if (compte.afigMoviment(moviment)) {
            compte.setSaldo(moviment.getSaldoResultant());
        }
        else {
            System.out.println("Moviment erroni!");
        }
        
    }
    
    private static void mostraMoviments(CompteBancari compte) {       
        for (Moviment moviment : compte.getMoviments()) {
            System.out.println(moviment);
        }
    }
}
