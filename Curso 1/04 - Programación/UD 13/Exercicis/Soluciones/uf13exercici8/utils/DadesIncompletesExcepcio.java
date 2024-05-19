/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uf13exercici8.utils;

/**
 *
 * @author ggarrido
 */
public class DadesIncompletesExcepcio extends Exception {
    //Excepció que es llança quan una línia de dades no té totes les dades necessàries.
    public DadesIncompletesExcepcio() {
        super("Línia amb dades incompletes.");
    }
}