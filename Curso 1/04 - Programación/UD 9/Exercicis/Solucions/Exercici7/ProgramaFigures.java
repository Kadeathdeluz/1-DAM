/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF09_Exercici07;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * UF09 Exercici 7: Programa principal per a gestionar figures
 */
public class ProgramaFigures {
    
        public static void main(String[] args) {
        
        // Creem la llista de figures
        ArrayList<iFigura2D> llistaFigures = new ArrayList<iFigura2D>();
        
        // Creemos els objectes
        Quadrat quadrat1 = new Quadrat(3);
        Rectangle rectangle1 = new Rectangle(5,2);
        Triangle triangle1 = new Triangle(3,3);
        Cercle cercle1 = new Cercle(5);
        
        // Añadimos los objetos a la lista
        llistaFigures.add(quadrat1);
        llistaFigures.add(rectangle1);
        llistaFigures.add(triangle1);
        llistaFigures.add(cercle1);
        
                
        mostrarFigures(llistaFigures);
        escalarFigures(llistaFigures, 2);
        mostrarFigures(llistaFigures);
        escalarFigures(llistaFigures, 0.1);
        mostrarFigures(llistaFigures);
        
    }   
    
    // Funció per a recorrer l'ArrayList d'iFigura2D i cridar al mètode imprimir() de cada objecte
    public static void mostrarFigures(ArrayList<iFigura2D> figures) {
       
        // Iterem i mostrem dades
        for (Iterator it = figures.iterator(); it.hasNext();) {
            iFigura2D figura = (iFigura2D)it.next();
            figura.imprimir();
        } 
         System.out.println("");
    }
    
    // Funció per a recorrer l'ArrayList d'iFigura2D i cridar al mètode escalar() de cada objecte
    public static void escalarFigures(ArrayList<iFigura2D> figures, double escala) {

        // Iteramos y escalamos
        for(Iterator it = figures.iterator(); it.hasNext();) {
            iFigura2D figura = (iFigura2D)it.next();
            figura.escalar(escala);
        }    
    }
}
