/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici05;
import java.util.ArrayList;
/**
* UF09 Exercici 5: Classe Empresa
*/
public class Empresa {
    
    // Atributs
    private final String nom;
    private final String cif;
    private String telefon;
    private String direccio;
    ArrayList<Empleat> llistaEmpleats;
    
    // Constructor
    public Empresa(String nom, String cif, String telefon, String direccio) {
        this.nom = nom;
        this.cif = cif;
        this.telefon = telefon;
        this.direccio = direccio;
        llistaEmpleats = new ArrayList<Empleat>();
    }
    
    // Getters y setters
    public String getNom() {
        return nom;
    }
    
    public String getCIF() {
        return cif;
    }
    
    public String getTelefon() {
        return telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public String getDireccio() {
        return direccio;
    }
    
    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }
    
    public ArrayList getEmpleats() {
        return llistaEmpleats;
    }    
    
    // MÈTODES
    
    // Mètode per afegir un empleat
    
    public void afegirEmpleat (Empleat e)     {
        llistaEmpleats.add(e);
    }
    
    // Mètode per eliminar un empleat
    public void eliminarEmpleat (Empleat e) {
        llistaEmpleats.remove(e);
    }
    
    // Mètode per mostrar la informació de tots els empleats
    public void mostraInformacioEmpleats()     {
        System.out.println("***** INFORMACIÓ D'EMPLEATS *****");
        
        for (int i = 0; i < llistaEmpleats.size(); i++) {
            Empleat e = llistaEmpleats.get(i);
            e.mostraEmpleat();
        }
        System.out.println("");
    }
    
    
    // Mètode per mostrar els sous de tots els empleats
    public void mostraSouEmpleats() {
        System.out.println("******* INFORMACIÓ DE SOU D'EMPLEATS *******");
        
        for (int i = 0; i < llistaEmpleats.size(); i++) {
            Empleat e = llistaEmpleats.get(i);
            System.out.println(e.getDNI() + " -- " + e.getSouBrut() + " -- " + e.calculaSouNet());    
        }   
        System.out.println("");
    }
    
    // Mètode per calcular la suma total del sou brut de todos els empleats
    public double calcularTotalSouBrut() {
        double totalSB = 0;
        
        for (int i = 0; i < llistaEmpleats.size(); i++) {
            totalSB+=llistaEmpleats.get(i).getSouBrut();
        }
        return totalSB;
    }
    
    // Mètode per calcular la suma total del sou net de todos els empleats
    
    public double calcularTotalSouNet() {
        double totalSN = 0;
        
        for (int i = 0; i < llistaEmpleats.size(); i++) {
            totalSN+=llistaEmpleats.get(i).calculaSouNet();
        }
        return totalSN;
    }
}
