/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uf13exercici3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ggarrido
 */
public class ConexionBBDD {
    //Creem les variables. Privades i estàtiques.
    private static String url = "jdbc:mysql://localhost:3306/uf13";
    private static String username = "root";
    private static String password = "";
    private static Connection conection;

    /*
    Mètode getConnexion() és el mètode que retorna la instància de la classe.
    Singleton és un patró de disseny que normalment s'usa quan no desitja crear diverses instàncies d'una classe.
     */
    public static Connection getConexion() throws SQLException {
        if (conection == null) {
            conection = DriverManager.getConnection(url, username, password);
        }
        return conection;
    }
}
