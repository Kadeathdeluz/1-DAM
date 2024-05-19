package utils;

import ciutadansepd.Ciutada;
import ciutadansepd.Huma;
import ciutadansepd.Llop;
import ciutadansepd.Vampir;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class BdadesDelPoble {

    private static String url = "jdbc:mysql://localhost:3306/poble";
    private static String username = "root";
    private static String password = "";
    private static Connection conection;

    /* Retorna la conexió actual i si no existeix la crea  */
    public static Connection getConexion() throws SQLException {
        if (conection == null) {
            conection = DriverManager.getConnection(url, username, password);
        }
        return conection;
    }

    /* Comproba si una taula existeix o no */
    public static boolean existeixTaula(String taula) throws SQLException {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = " + taula;
        PreparedStatement pstmt = conection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            existe = true;
        }
        rs.close();
        pstmt.close();
        return existe;
    }

    /* Borra una taula de la BD donat el seu nom */
    public static void eliminarTaula(String taula) {
        String sql = "DROP TABLE " + taula;

    }

    /* Crea una taula a la BD (si no existeix ja) amb el nom especificat */
    public static void crearTaula(String taula) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + taula
                + "( id" + taula + " INT NOT NULL AUTO_INCREMENT,"
                + " nom VARCHAR(15) NOT NULL,"
                + " vida INT,"
                + " vulnerable VARCHAR(10),"
                + " PRIMARY KEY(id" + taula + "));";
        conection.createStatement().execute(sql);
    }

    /**/
    public static void guardarDades(ArrayList<Ciutada> ciutadans) throws SQLException, FileNotFoundException {
        
        //Eliminem totes les taules
        eliminarTaula("vampir");
        eliminarTaula("huma");
        eliminarTaula("llop");

        //Creem totes les taules
        crearTaula("vampir");
        crearTaula("huma");
        crearTaula("llop");
        
        for(Ciutada ciut : ciutadans) {
            int vida = ciut
        } 
     
        //@TODO: Insertar els ciutadans
        String insertSQL = "INSERT INTO ? (nom, vida, vulnerable) "
                + "VALUES (?, ?, ?";
    }
    
    /* Carrega les dades desde la BD */
    public static ArrayList<Ciutada> carregarDades(ArrayList<Ciutada> ciutadans) throws IOException {
        
        //Borra la llista
        ciutadans.clear();
        
        //Reseteja cada població
        Huma.resetPoblacio();
        Llop.resetPoblacio();
        Vampir.resetPoblacio();
        String sql
        ArrayList<Huma> humans = carregarTaula(new ArrayList<Huma>(),"");
        
        
    }

    private static ArrayList<Ciutada> carregarTaula(ArrayList<Ciutada> arrayList, String string) {
        String sql = "";
        
        String [] noms = new String [];
    }

}
