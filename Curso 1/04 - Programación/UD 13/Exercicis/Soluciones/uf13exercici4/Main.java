/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf13exercici4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uf13exercici4.utils.ConexionBBDD;

/**
 *
 * @author ggarrido
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //AutoClose
        try (   Connection conn = ConexionBBDD.getConexion();){
            if (!ConexionBBDD.existeTabla("productos2")) {
                ConexionBBDD.crearTablaProductos();
            }
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos2");
            while (resultado.next()){
                System.out.print(resultado.getString("CODIGO_ARTICULO") + " | ");
                System.out.print(resultado.getString("SECCION") + " | ");
                System.out.print(resultado.getString("NOMBRE") + " | ");
                System.out.print(resultado.getDouble("PRECIO") + " | ");
                System.out.print(resultado.getString("PAIS") + " | ");
                System.out.println(resultado.getDate("FECHA"));
            }
            resultado.close();
            stmt.close();
        } catch (SQLException | Excepcio e) {
            System.err.println("Error al realitzar la consulta SQL: " + e.getMessage());
        }
    }
    
}
