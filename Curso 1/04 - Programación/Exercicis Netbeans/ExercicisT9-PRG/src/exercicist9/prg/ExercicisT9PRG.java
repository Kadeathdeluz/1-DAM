package exercicist9.prg;

import exercicist9.prg.exercici1.Producte;
import exercicist9.prg.exercici2.Planeta;
import exercicist9.prg.exercici2.Satelite;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ExercicisT9PRG {

    public static void main(String[] args) {
        //exercici1(); //hecho
        exercici2();
        
    }
    
    public static void exercici1() {
        //1- Crea 5 instancias de Producte
        Producte prod1 = new Producte("Producte 1", 1);
        Producte prod2 = new Producte("Producte 2", 2);
        Producte prod3 = new Producte("Producte 3", 3);
        Producte prod4 = new Producte("Producte 4", 4);
        Producte prod5 = new Producte("Producte 5", 5);
        Producte nouProd;
        //2- Crea un ArrayList
        ArrayList<Producte> arrayListProductes = new ArrayList();
        Iterator iterator;
        
        //3- Añade las instancias al ArrayList
        arrayListProductes.add(prod1);
        arrayListProductes.add(prod2);
        arrayListProductes.add(prod3);
        arrayListProductes.add(prod4);
        arrayListProductes.add(prod5);
        
        //4- Utiliza Iterator para mostrar el contenido del ArrayList
        System.out.println(" ----------- Apartat 4 ----------- ");
        iterator = arrayListProductes.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        
        //5- Elimina dos elementos del ArrayList (elijo los dos últimos, pero podía ser cualquier posición)
        arrayListProductes.removeLast();
        arrayListProductes.removeLast();
        
        //6- Añade un nuevo elemento en medio de la ArrayList ( size()/2 )
        nouProd = new Producte("Producte en mig", 10);
        arrayListProductes.add(arrayListProductes.size()/2,nouProd);
        
        //7- Visualiza el nuevo contenido con Iterator
        System.out.println(" ----------- Apartat 7 ----------- ");
        iterator = arrayListProductes.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        
        //8 - Elimina todos los valores del ArrayList
        arrayListProductes.clear();
    }
    
    public static void exercici2() {
        Satelite luna = new Satelite("Luna", 500, 100, 1, -5, 1500, (float)(2 * Math.PI * 1500), "Terra 1");
        Satelite cassiopea = new Satelite("Cassiopea", 250, 100, 2, -10, 1500, (float)(2 * Math.PI * 1500), "Terra 1");
        ArrayList<Satelite> satelitsTerra = new ArrayList<>();
        
        satelitsTerra.add(luna);
        satelitsTerra.add(cassiopea);
        
        Planeta terra = new Planeta("Terra 1", 1230, 300, 365, 50, 30000, (float)(2 * Math.PI * 30000), satelitsTerra);
        
        System.out.println(" ------------ Planeta ------------ \n" 
                + terra + " \n--------------------------------- " );
    }
    
    public static void exercici3() {
        
    }
    
    public static void exercici4() {
        
    }
    
    public static void exercici5() {
        
    }
    
    public static void exercici6() {
        
    }
    
    public static void exercici7() {
        
    }

}
