 package exercicist6.exercicisTC;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
/**Ejercicio propuesto por Jose Cantó en una TC - enviado por correo */
public class Agenda {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        HashMap<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();
        
        System.out.println("Quantes persones vols introduïr? ");
        int peopleNum = input.nextInt();
        
        do {
            System.out.println("Introdueix el document d'identitat: ");
            String id = input.next();

            System.out.println("Introdueix quants telèfons vols introduïr: ");
            int quantity = input.nextInt();

            ArrayList<String> phoneArrayList = new ArrayList<String>();

            while (quantity > 0) {
                System.out.println("Introdueix un número de telèfon: ");
                phoneArrayList.add(input.next());
                quantity--;
            }
            phonebook.put(id, phoneArrayList);
            
            peopleNum--;
        } while (peopleNum > 0);

        for (String idDoc : phonebook.keySet()) {
            ArrayList<String> phoneArrayList = phonebook.get(idDoc);
            System.out.println(idDoc + ": " + phoneArrayList.toString());
            
        }

        input.close();
    }
}
