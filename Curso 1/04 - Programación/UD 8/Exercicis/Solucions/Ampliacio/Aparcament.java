/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF08_Exercici01;
import java.util.Scanner;
/**
 * UF08 Exercici 01: Classe Aparcament
 * Atributs: plaçaNumero, estat, matricula
 * Atributs de classe: placesLliures, placesOcupades
 */
public class Aparcament {
    
    // Atributs de classe
    private static int placesLliures = 0;
    private static int placesOcupades = 0;

    // Atributs d'instància
    private final int numero;
    private Estat estat;
    private String matricula;
    
    // Mètode constructor
    public Aparcament() {
        placesLliures++;
        this.numero = placesLliures;
        this.estat = Estat.LLIURE;
        this.matricula=null;
    }
    
    
    // Mètodes getter
    public Estat mostraEstat() {
        return this.estat;
    }
    
    public int mostraNumero() {
        return this.numero;
    }
    
    public static int mostraLliures() {
        return Aparcament.placesLliures;
    }
    
    public static int mostraOcupades() {
        return Aparcament.placesOcupades;
    }
    
    // Mètode per a mostrar l'esta d'una plaça d'aparcament
    public String toString() {
        String missatge;
   
        if (this.estat==Estat.LLIURE) {
            missatge= "La plaça d'aparcament número " + this.numero + " es troba " + this.estat;
        } else {
            missatge= "La plaça d'aparcament número " + this.numero + " es troba " + this.estat + " pel vehicle " + this.matricula;    
        }
   
        return missatge;
    }
    
    public void processaEntrada (String matricula){
        placesOcupades++;    
        placesLliures--;
        this.estat = Estat.OCUPADA;
        this.matricula=matricula;
    }
    
    public void processaEixida (){
        placesOcupades--;    
        placesLliures++;
        this.estat = Estat.LLIURE;
        this.matricula=null;    
    }
}
