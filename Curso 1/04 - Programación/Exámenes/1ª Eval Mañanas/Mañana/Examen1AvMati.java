import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Examen1Av class of the Java program.
 * @author Roldan Sanchis Martinez
 * System.out.println("Hola mon");
 */

public class Examen1AvMati {
    public static HashMap<String, double[]> clients = new HashMap<>(); //double [] = saldo, totalGuanyat, totalPerdut
    public static String [] opcions = {"Cirera", "Campana", "Bar", "Diamant", "Set"};

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nom, resposta;
        double saldo;
        
        System.out.println("Nom del jugador: ");
        nom = entrada.nextLine();
        
        System.out.println("Saldo del jugador: ");
        saldo = entrada.nextDouble();
        
        System.out.println("Benvingut!");
        afegirClient(nom, saldo);
        
        jugarEscuraButxaques(nom);
        
        entrada.close();
    }
    
    public static void afegirClient(String nom, double saldo) {
        //Inicialment el client no ha guanyat ni perdut saldo
        double [] valors = {saldo, 0.0, 0.0};
        
        clients.put(nom,valors);
    }
    
    public static void mostraClient(String nom) {
        double [] arraySaldos;
        double saldo, guanyat, perdut;
        
        if(clients.containsKey(nom)) {
            arraySaldos = clients.get(nom);
            saldo = arraySaldos[0];
            guanyat = arraySaldos[1];
            perdut = arraySaldos[2];
            
            System.out.println("Client: " + nom);
            System.out.println("Saldo: " + saldo);
            System.out.println("Total guanyat: " + guanyat);
            System.out.println("Total perdut: " + perdut);
        }
        else {
            System.out.println("Client amb nom " + nom + " no trobat.");
        }
    }
    
    public static void modificarSaldo(String nom, double quantitat) {
        double [] arraySaldos;
        double saldo, guanyat, perdut;
        
        if(clients.containsKey(nom)) {
            arraySaldos = clients.get(nom);
            saldo = arraySaldos[0] + quantitat;
            guanyat = arraySaldos[1];
            perdut = arraySaldos[2];
            if(quantitat > 0) {
                guanyat += quantitat;
            }
            else {
                perdut += quantitat;
            }
            arraySaldos[0] = saldo;
            arraySaldos[1] = guanyat;
            arraySaldos[2] = perdut;
            
            clients.put(nom,arraySaldos);
            System.out.println(Arrays.toString(arraySaldos));
            
        }
        else {
            System.out.println("Client amb nom " + nom + " no trobat.");
        } 
        
    }
    
    public static double assignarPremi(String [] combinacio) {
        double premi = 0.0;
        String figura = combinacio[0];
        
        if(esSet(combinacio)) {
            //En cas de ser un set (tres iguals) combprovem nomes un valor
            switch(figura) {
                case "Cirera":
                    premi = 3.0;
                    break;
                case "Campana":
                    premi = 5.0;
                    break;
                case "Bar":
                    premi = 7.0;
                    break;
                case "Diamant":
                    premi = 10.0;
                    break;
                case "Set":
                    premi = 15.0;
                    break;
                default:
                    System.out.println("ERROR");
                    break;
                    
            }

        }
        
        return premi;
    }
    
    public static boolean esSet(String [] combinacio) {
        String uno = combinacio[0], dos = combinacio[1], tres = combinacio[2];
        
        if(uno.equals(dos) && dos.equals(tres)) {
            return true;
        }
        return false;
        
    }
    
    public static String[] obtindreCombinacioAleatoria() {
        int posicio;
        String [] combinacio = new String[3];
        
        for(int i = 0; i < 3; i++) {
            posicio = (int) (Math.random() * 5);
            combinacio[i] = opcions[posicio];
        }
        return combinacio;
    }
    
    public static void jugarEscuraButxaques(String nom) {
        Scanner entrada = new Scanner(System.in);
        String resposta;
        String [] combinacio;
        double premi, saldo;
        
        do {
            modificarSaldo(nom, -1);
            saldo = clients.get(nom)[0];
            
            combinacio = obtindreCombinacioAleatoria();
            System.out.println("Combinacio: " + Arrays.toString(combinacio));
        
            premi = assignarPremi(combinacio);
            System.out.println("Premi: " + premi);
            
            if(premi > 0) {
                System.out.println("Enhorabona, " + nom + "!");
                System.out.println("Has obtingut: " + premi);
            }
            else {
                System.out.println("Ho sentim, " + nom + " ja guanyaras...");
            }
            modificarSaldo(nom, premi);
            saldo = clients.get(nom)[0];
            
            System.out.println("Saldo restant: " + saldo);
            
            if(saldo > 0) {
                System.out.println("Vols fer altra tirada? (si/no)");
                resposta = entrada.nextLine();
            }
            else {
                resposta = "no";
            }

        } while(!resposta.toLowerCase().equals("no") && saldo > 0.0);
        
        System.out.println("============================");
        mostraClient(nom);
        System.out.println("============================");
        
    }
}






















