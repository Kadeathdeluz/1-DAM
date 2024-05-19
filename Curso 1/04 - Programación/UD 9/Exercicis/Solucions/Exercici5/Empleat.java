/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici05;

/**
 * UF09 Exercici 5: Classe Empleat
 */
public class Empleat {
    
    
    // Atributs
    private final String nom; // Una vegada inicialitzat ja no es pot modificar
    private final String dni;    // Una vegada inicialitzat ja no es pot modificar
    private double souBrut;
    private int edat;
    private String  telefon;
    private String direccio;
    
    // Constructors
    public Empleat (String nom, String dni, double souBrut) {
        this.nom = nom;
        this.dni = dni;
        this.souBrut = souBrut;
        this.edat = 0;
        this.telefon = "";
        this.direccio = "";
    }    
    
    public Empleat (String nom, String dni, double souBrut, int edat, String telefon, String direccio) {        
        this.nom = nom;
        this.dni = dni;
        this.souBrut = souBrut;
        this.edat = edat;
        this.telefon = telefon;
        this.direccio = direccio;       
    }    
    
    // Getters i setters 
    
    public String getNom() {
        return this.nom;
    }
    
    public String getDNI() {
        return this.dni;
    } 
    
    public double getSouBrut() {
        return this.souBrut;
    }
    
    public void setSouBrut(double souBrut) {
        this.souBrut = souBrut;
    }
    
    public int getEdat() {
       return edat;       
    }
    
    public void setEdat(int edat) {
        this.edat = edat;
    }
    
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;        
    }
    
    public String getDireccio() {
        return this.direccio;
    }
    
    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }
    
    // MÈTODES
    
    // Mètode que calcula el sou net de l'empleat
    public double calculaSouNet()     {
        double irpf = 0;        
        double souBrutAnual = this.getSouBrut() * 12;
        
        if(souBrutAnual < 12000) {
            irpf = 20.0;            
        } else { 
            if (souBrutAnual >= 12000 && souBrutAnual <= 25000) {
                irpf = 30.0;
            } else {
                irpf = 40.0;
            }
        }
        return this.souBrut * (1 - irpf/100);
    }
    
    // Mètode que mostra la informació de l'empleat (tambè es pot resoldre sense utilitzar mètodes accedint directament a this.nom ja que estem dins de la classe)
    public void mostraEmpleat() {
        System.out.println("Empleat => Nom: " + this.getNom() + "  DNI: " + this.getDNI() + "  Sou Brut: " + this.getSouBrut() + "  Edat: " + this.getEdat() + "  Telèfon: " + this.getTelefon() + "  Direcció: " + this.getDireccio());
    }   
}
