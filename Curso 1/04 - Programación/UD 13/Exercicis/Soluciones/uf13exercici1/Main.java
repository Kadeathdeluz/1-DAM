/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf13exercici1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ggarrido
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/uf13";
        String username = "root";
        String password = "";

        try {

            //Objecte Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //Creació de la query
            Statement stmt = conn.createStatement();

            //Creació del resultSet per a guardar el resultat de la query
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos1");

            //Recorrem el cursor
            while (resultado.next()){
                System.out.println(resultado.getString("NOMBRE"));
            }

            /*
            Si tinguérem una excepció, les sentències close() no s'executarien. 
            Per a evitar això es deurien possar dins d'un finally.
            */
            resultado.close();
            stmt.close();
            conn.close();
        } catch (SQLException | Excepcio e) {
            System.err.println("Error al realitzar la consulta SQL: " + e.getMessage());
        }
    }
    
}
