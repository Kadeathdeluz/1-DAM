/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uf13exercici4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

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
        
        // Insertar 5 productos aleatorios
        String[] codigos = {"P001", "P002", "P003", "P004", "P005"};
        String[] secciones = {"Ropa", "Electrónica", "Deportes", "Juguetes", "Hogar"};
        String[] nombres = {"Camiseta", "Smartphone", "Raqueta", "Peluche", "Lámpara"};
        double[] precios = {9.99, 599.99, 29.99, 14.99, 39.99};
        String[] paises = {"España", "Francia", "Alemania", "Italia", "Reino Unido"};
        java.sql.Date[] fechas = {new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis())};

        for (int i = 0; i < codigos.length; i++) {
            String insert = "INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conection.prepareStatement(insert);
            pstmt.setString(1, codigos[i]);
            pstmt.setString(2, secciones[i]);
            pstmt.setString(3, nombres[i]);
            pstmt.setDouble(4, precios[i]);
            pstmt.setString(5, paises[i]);
            pstmt.setDate(6, fechas[i]);
            pstmt.executeUpdate();
        }
        System.out.println("Tabla productos creada y productos aleatorios insertados.");
    }
}
