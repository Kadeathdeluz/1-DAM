/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uf13exercici8.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public static boolean existeTabla(String tabla) throws SQLException {
    boolean existe = false;
    String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = '" + tabla + "'";
        PreparedStatement pstmt = conection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            existe = true;
        }
        rs.close();
        pstmt.close();
        return existe;
    }

    public static void crearTablaProductos() throws SQLException {
        String sql = """
                     CREATE TABLE IF NOT EXISTS productos2 (
                     CODIGO_ARTICULO VARCHAR(10) PRIMARY KEY,
                     SECCION VARCHAR(50) NOT NULL,
                     NOMBRE VARCHAR(50) NOT NULL,
                     PRECIO DOUBLE NOT NULL,
                     PAIS VARCHAR(50) NOT NULL,
                     FECHA DATE NOT NULL
                     );""";
        conection.createStatement().execute(sql);
    }
}
