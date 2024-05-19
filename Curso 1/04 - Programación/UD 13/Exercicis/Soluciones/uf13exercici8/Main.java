/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf13exercici8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import uf13exercici8.utils.ConexionBBDD;
import uf13exercici8.utils.Producto;
import uf13exercici8.utils.ProductoIncompletoExcepcion;
import uf13exercici8.utils.ProcesadorDeFitxers;
import java.io.IOException;

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
            // Llegim el fitxer de productes
            String path = "./fitxers/productes.csv";
            try {
                // Creem un objecte ProcessadorDeFitxers amb el path del fitxer i el nombre de camps que ha de tenir cada línia
                ProcessadorDeFitxers processador = new ProcessadorDeFitxers(path, 6);
                // Preparem el statement per inserir productes a la base de dades
                String insert = "INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conection.prepareStatement(insert);
                // Llegim el fitxer línia a línia
                String linia;
                while ((linia = br.readLine()) != null) {
                    try {
                        // Processar la línia i obtenir les dades del producte
                        String[] dadesProducte = processador.processarLinia(linia);                        
                        // Afegim els valors del producte a la sentència SQL
                        for (int i = 0; i < dadesProducte.length; i++) {
                            pstmt.setString(i + 1, dadesProducte[i]);
                        }
                        // Executem la sentència
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected == 1) {
                            System.out.println("Producte creat: " + dadesProducte[2]);
                        } else {
                            System.err.println("No s'ha pogut crear el producte: " + dadesProducte[2]);
                        }                   
                    } catch (ProducteIncompletExcepcio e) {
                        System.err.println(e.getMessage() + ": " + linia);
                    }
                }
                // Tanquem el fitxer
                processador.tancar();
                // Tanquem el PreparedStatement
                pstmt.close();  
            } catch (IOException e) {
                System.err.println("Error al llegir el fitxer: " + e.getMessage());
            }

            String select = "SELECT * FROM productos";
            PreparedStatement ps = conn.prepareStatement(query);
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
            ps.close();
            for (Producto p : productos) {
                System.out.println(p.getCODIGO_ARTICULO() + " - " + p.getSECCION() + " - " + p.getNOMBRE() +
                        " - " + p.getPRECIO() + " - " + p.getPAIS() + " - " + p.getFECHA());
            }
        } catch (SQLException | Excepcio e) {
            System.err.println("Error al realitzar la consulta SQL: " + e.getMessage());
        }
    }
    
}
