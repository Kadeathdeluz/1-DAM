 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Scanner;
 
 /**
 * Main class of the Java program.
 * @author: Roldan Sanchis Martinez 
 */
public class Examen1AvVesprada {
    
    public static HashMap<String,Double> clients = new HashMap<String,Double>();
    public static String [] baralla = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "sota","cavall", "rei"}; ;
    public static ArrayList<Integer> arraylist = new ArrayList<>();

    public static void main(String[] args) {
        String nom;
        Double saldo;
        //Afegim el jugador Paco amb un saldo de 500.0
        afegirClient("Paco", 500.0);
        
        jugarBlackjack();
    }
    
    public static void afegirClient(String nom, Double saldo) {
        clients.put(nom,saldo);
    }
    
    public static void mostrarClient(String nom) {
        if(clients.containsKey(nom)) {
            System.out.println("Client: " + nom + ", Saldo: " + clients.get(nom));
        }
        else {
            System.out.println("Client amb nom " + nom + " no trobat.");
        }
        
    }
    
    public static void modificarSaldo(String nom, Double quantitat) {
        Double nouSaldo;
        if(clients.containsKey(nom)){
            nouSaldo = clients.get(nom) + quantitat;
            clients.put(nom,nouSaldo);
            System.out.println("Client: " + nom + ", Saldo: " + clients.get(nom));
        }
        else {
            System.out.println("Client amb nom " + nom + " no trobat.");
        }
    }
    
    public static int obtindreCartaAleatoria() {
        return (int) (Math.random() * 12);
    }
    
    public static void prendreCarta(ArrayList<String> ma) {
        int carta = obtindreCartaAleatoria();
        ma.add(baralla[carta]);
    }
    
    public static int calcularValorCartes(ArrayList<String> ma) {
        int total = 0;
        
        for(int i = 0; i < ma.size(); i++) {
            try {
                //Si es 1 es un as -> +11
                if(ma.get(i).equals("1")) {
                    total+= 11;
                }
                //En cas contrari es suma el numero, p.e. carta = 3 -> +3
                else {
                    total+= Integer.parseInt(ma.get(i));
                }
                //Si son lletres es una figura -> +10
            } catch(Exception e) {
                total += 10;
            }
            
        }
        
        return total;
    }
    
    public static void mostrarResultatsBlackjack(ArrayList<String> maJugador, ArrayList<String> maCrupier) {
        int puntsJ = 0, puntsC = 0;
        
        String guanyador;
        
        puntsJ = calcularValorCartes(maJugador);
        puntsC = calcularValorCartes(maCrupier);
        
        System.out.println("Cartes del jugador: " + maJugador);
        System.out.println("Cartes del crupier: " + maCrupier);
        
        System.out.println("Valor de les cartes del jugador: " + puntsJ);
        System.out.println("Valor de les cartes del crupier: " + puntsC);
        
        if(puntsJ > puntsC) {
            if(puntsJ <= 21) {
                guanyador = "Jugador";
            }
            else {
                guanyador = "Crupier";
            }
        }
        else if(puntsC <= 21) {
            guanyador = "Crupier";
        } else {
            guanyador = "Jugador";
        }
        System.out.println(guanyador + " guanya!");
        
    }
    
    public static void jugarBlackjack() {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> cartesJ = new ArrayList<>();
        ArrayList<String> cartesC = new ArrayList<>();
        
        prendreCarta(cartesJ);
        prendreCarta(cartesC);
        
        System.out.println("Prendre carta? s/n");
        
        if(entrada.nextLine().toLowerCase().equals("s")) {
            prendreCarta(cartesJ);
            System.out.println(cartesJ.get(cartesJ.size()-1) );
            
            if(calcularValorCartes(cartesJ) > 21) {
                mostrarResultatsBlackjack(cartesJ,cartesC);
            }
            else {
                prendreCarta(cartesC);
                if(calcularValorCartes(cartesC) > 21) {
                    mostrarResultatsBlackjack(cartesJ, cartesC);
                }
            }
        }
        else {
            while(calcularValorCartes(cartesC) < 17 ) {
                prendreCarta(cartesC);
            }
        }
        mostrarResultatsBlackjack(cartesJ, cartesC);
        
    }
    
}



















