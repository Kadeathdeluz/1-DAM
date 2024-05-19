/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici06;
import java.util.ArrayList;
/**
 * UF09 Exercici 6: Companya de transport
 */
public class ProgramaTransport {
    
    public static void main(String[] args) {
        
        // Creem els objectes
        Terrestre terrestre = new Terrestre("1234ABC", "Esportiu", 4);
        Aquatic aquatic = new Aquatic("ABC", "Fora borda", 10.2);
        Aeri aeri = new Aeri("ABCD123456", "Supersònic", 2);
        
        Cotxe cotxe1 = new Cotxe("8524KSY", "Tot Terreny", 5, true);
        Moto moto1 = new Moto("3585HFJ", "Custom", 2, "Negra");
        Vaixell vaixell1 = new Vaixell("jhfhhg", "Góndola", 100, false);
        Submari submari1 = new Submari("abcdefghij", "Submergible", 250, 520);
        Avio avio1 = new Avio("kkKK654852", "Jumbo", 150, 10000);
        Helicopter helicopter1 = new Helicopter("BeAB987123", "Helicop99", 8, 2);
        
        // Creem la lllista de vehicles
        ArrayList<Vehicle> llistaVehicles = new ArrayList<Vehicle>();
        
        // Afegim els objectes a la lllista
        llistaVehicles.add(terrestre);
        llistaVehicles.add(aquatic);
        llistaVehicles.add(aeri);
        llistaVehicles.add(cotxe1);
        llistaVehicles.add(moto1);
        llistaVehicles.add(vaixell1);
        llistaVehicles.add(submari1);
        llistaVehicles.add(avio1);
        llistaVehicles.add(helicopter1);
        
        // Recorreguem la llista per anar cridant al mètode imprimir() de cada objecte
        for (int i = 0; i < llistaVehicles.size(); i++) {
            Vehicle v = llistaVehicles.get(i);
            v.imprimir();
        }         
        
    }    
    
}
