/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_Exercici01;
import java.util.Scanner;
/**
* UF08 Exercici 01: Programa que crea les places d'aparcament i gestiona les entrades i eixides de vehicles.
*/
public class ProgramaAparcament {

        final static int PLACES=20;
    
    public static void main (String[] args){
    
        // Definició de variables
        int i, opcio=0;
        boolean opcioValida;
        Aparcament[] places = new Aparcament [PLACES];
        Scanner menu = new Scanner (System.in);

        // Inicialització de les places.
        for (i = 0; i < PLACES; i++){
            places[i] = new Aparcament();
        }
        
        // Processar menù d'opcions
        do {
            
            opcioValida=false;
            
            System.out.println ("\n========= MENÚ APARCAMENT ========");
            System.out.println ("1.- Entra de vehicle");
            System.out.println ("2.- Eixida de vehicle");
            System.out.println ("3.- Estat d'una plaça");
            System.out.println ("4.- Estat del parking");
            System.out.println ("0.- Finalitzar");            

            // Validar opció triada
            do {
                System.out.print("Introdueix una opció: ");
                if(menu.hasNextInt()) {
                    opcio=menu.nextInt();
                    if ((opcio >=0) && (opcio<=4)){
                        opcioValida=true;
                    } else {
                        System.out.println("L'opció no és correcta.");
                    }
                }
                menu.nextLine();
            } while (!opcioValida);
                
            // Executar opció
            switch (opcio) {
                case 1:
                    entradaVehicle(places);
                    break;
                case 2:
                    eixidaVehicle(places);
                    break;
                case 3:
                    informacioPlaça(places);
                    break;
                case 4:
                    informacioAparcament(places);
                    break;
            }
                
        } while (opcio!=0);
        
        System.out.println("Adeu!");
    }

    // Procediment que gestiona l'entrada d'un vehicle
    public static void entradaVehicle(Aparcament[] places){
        
        int i;
        boolean trobat=false;
        Scanner entrada = new Scanner (System.in);
        String matricula;
        
        // Si l'aparcament està complet donem un avis
        if (Aparcament.mostraLliures()<=0){
            System.out.println ("Ho sentim molt, l'aparcament està complet.");
        // Si hi ha places donem la primera lliure
        } else {
            System.out.println ("Introdueix la matrícula: ");
            matricula = entrada.nextLine();
            i=0;
            while (i<PLACES && !trobat){
                if (places[i].mostraEstat()==Estat.LLIURE){
                    trobat=true;
                    places[i].processaEntrada(matricula);
                    System.out.println ("Vaja a la plaça número " + places[i].mostraNumero());
                }
                i++;
            }
        }
    }

    // Procediment que gestiona l'eixida d'un vehicle    
    public static void eixidaVehicle(Aparcament[] places){
    
        int posicio;
        boolean trobat=false;
        Scanner entrada = new Scanner (System.in);
        
        // Validar el número de la plaça
        do {
            System.out.print("Introdueix el número de la plaça: ");
            if(entrada.hasNextInt()) {
                posicio=entrada.nextInt();
                if ((posicio >=1) && (posicio<=PLACES)&& (places[posicio-1].mostraEstat() == Estat.OCUPADA)){
                    trobat=true;
                    places[posicio-1].processaEixida();
                    System.out.println ("Ja pot eixir de l'aparcament. Moltes gràcies.");
                }
            }
            entrada.nextLine();
            if (!trobat) {
                System.out.println("La plaça indicada no és correcta.");                
            }
        } while (!trobat);
    }

    // Procediment que mostra l'estat d'una plaça d'aparcament
    public static void informacioPlaça(Aparcament [] places){

        Scanner entrada = new Scanner (System.in);
        int posicio=0;
        boolean opcioValida=false;
        
        do {
            System.out.print("\nIntrodueix el número de la plaça a consultar: ");
            if(entrada.hasNextInt()) {
                posicio=entrada.nextInt();
                if ((posicio >=1) && (posicio<=PLACES)){
                    opcioValida=true;
                }
            }
            entrada.nextLine();
            if (!opcioValida){
                System.out.println("El número de plaça triat no és correcte.");
            }
        } while (!opcioValida);
        
        System.out.println (places[posicio-1]);
    }

    // Procediment que mostra l'estat de l'aparcament complet
    public static void informacioAparcament(Aparcament [] places){
    
        int i;
        
        System.out.println ("\nESTAT ACTUAL DE L'APARCAMENT");
        for (i = 0; i < PLACES; i++){
            System.out.println (places[i]);

        }
        
    }
    
}
