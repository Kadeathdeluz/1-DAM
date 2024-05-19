/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf13exercici7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import uf13exercici7.utils.ConexionBBDD;
import uf13exercici7.utils.Producto;

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
            
            String query2 = "UPDATE productos2 SET PRECIO = ? WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement ps2 = conn.prepareStatement(query2);
            ps2.setDouble(1, 9999.0); // nou preu
            ps2.setString(2, "Deportes"); // valor per a SECCION
            ps2.setString(3, "Alemania"); // valor per a PAIS
            int rowsAffected = ps2.executeUpdate();
            System.out.println(rowsAffected + " filas afectadas.");
            p2.close();
            
            String query3 = "SELECT * FROM productos";
            PreparedStatement ps3 = conn.prepareStatement(query);
            ArrayList<Producto> productos = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("CODIGO_ARTICULO");
                String seccion = rs.getString("SECCION");
                String nombre = rs.getString("NOMBRE");
                double precio = rs.getDouble("PRECIO");
                String pais = rs.getString("PAIS");
                Date fecha = rs.getDate("FECHA");
                Producto producto = new Producto(codigo, seccion, nombre, precio, pais, fecha);
                productos.add(producto);
            }
            rs.close();
            p3.close();

            for (Producto p : productos) {
                System.out.println(p.getCODIGO_ARTICULO() + " - " + p.getSECCION() + " - " + p.getNOMBRE() +
                        " - " + p.getPRECIO() + " - " + p.getPAIS() + " - " + p.getFECHA());
            }
        } catch (SQLException | Excepcio e) {
            System.err.println("Error al realitzar la consulta SQL: " + e.getMessage());
        }
    }
    
}
