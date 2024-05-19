/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf13exercici5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uf13exercici5.utils.ConexionBBDD;

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
            String query = "SELECT * FROM productos2 WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "Deportes"); // valor per a SECCION
            ps.setString(2, "Alemania"); // valor per a PAIS
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()){
                System.out.print(resultado.getString("CODIGO_ARTICULO") + " | ");
                System.out.print(resultado.getString("SECCION") + " | ");
                System.out.print(resultado.getString("NOMBRE") + " | ");
                System.out.print(resultado.getDouble("PRECIO") + " | ");
                System.out.print(resultado.getString("PAIS") + " | ");
                System.out.println(resultado.getDate("FECHA"));
            }
            resultado.close();
            ps.close();
        } catch (SQLException | Excepcio e) {
            System.err.println("Error al realitzar la consulta SQL: " + e.getMessage());
        }
    }
    
}
