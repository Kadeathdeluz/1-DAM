/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici03;
import java.util.ArrayList;

/**
 * UF09 Exercici 03: Classe Inventari mante un ArrayList de mascotes
 */
public class Inventari {
    
    private ArrayList<Mascota> animals = new ArrayList();

    // Retorna un String amb el tipus d'Animal
    private String getTipusMascota(Mascota m) {
        if (m instanceof Gos) {
            return "Gos";
        } else if (m instanceof Gat) {
            return "Gat";
        } else if (m instanceof Lloro) {
            return "Lloro";
        } else if (m instanceof Canari) {
            return "Canari";
        } else {
            return null;
        }
    }

    // Mostra la llista d'animals (sols tipus i nom)
    public void mostrarLlistaAnimals() {
        System.out.println("==== LLISTA D'ANIMALS ====");
        for (int i = 0; i < animals.size(); i++) {
            Mascota m = animals.get(i);
            String tipus = getTipusMascota(m);
            String nom = m.getNom();
            System.out.println(i + ": " + tipus + " " + nom);
        }
    }

    public void mostrarUnAnimal(int index) {
        if (index >= 0 && index < animals.size()) {
            System.out.println("*** MASCOTA " + index + " ***");
            Mascota m = animals.get(index);
            m.mostra();
        }
    }

    public void mostrarTotsAnimals() {
        for (int i = 0; i < animals.size(); i++) {
            mostrarUnAnimal(i);
            System.out.println("");
        }
    }

    public void inserirAnimal(Mascota a) {
        animals.add(a);
    }

    public boolean eliminarAnimal(int index) {
        if (index >= 0 && index < animals.size()) {
            animals.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void buidarInventario() {
        animals.clear();
    }    
    
}
