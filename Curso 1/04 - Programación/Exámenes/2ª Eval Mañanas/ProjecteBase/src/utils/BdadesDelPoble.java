package utils;

import java.sql.*;
import projectebase.Ciutada;
import projectebase.Huma;
import projectebase.Llop;
import projectebase.Mestis;
import projectebase.Vampir;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class BdadesDelPoble {

    private static String url = "jdbc:mysql://localhost:3306/poble";
    private static String username = "root";
    private static String password = "";
    private static Connection conexio;

    public static Connection getConnexio() throws SQLException {
        //Crea la conexió a la BDD poble
        conexio = DriverManager.getConnection(url, username, password);

        return conexio;
    }

    /* Tanca la conexió amb la BDD */
    public static void tancarConnexio() {
        try {
            conexio.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /* Elimina una taula donat el seu nom */
    public static void eliminarTaula(String taula) {
        String sqlDrop = "DROP TABLE " + taula;
        try {
            conexio.createStatement().execute(sqlDrop);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /* Crea una taula donat el seu nom amb els parámetres id, nom, força, vida, vulnerable i tipus*/
    public static void crearTaula(String taula) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + taula
                + "\nid INT NOT NULL"
                + "\nnom VARCHAR(15) NOT NULL "
                + "\nforça INT NOT NULL,"
                + "\nvida INT NOT NULL,"
                + "\nvulnerable VARCHAR(10),"
                + "\ntipus VARCHAR(6) NOT NULL,"
                + "\n PRIMARY KEY(id)); ";
        try {
            conexio.createStatement().execute(sqlCreate);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /* Si la taula existeix l'elimina i la torna a crear */
    public static void resetejarTaula(String taula) {
        String sqlSelect = "SELECT COUNT(*) "
                + "FROM information_schema.tables "
                + "WHERE table_name = " + taula;
        try {
            Statement statement = conexio.createStatement();
            ResultSet resultSet = statement.executeQuery(url);

            if (resultSet.next() && resultSet.getInt(1) > 0) {

                eliminarTaula(taula);
                crearTaula(taula);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    /* Inserta el ciutada a la taula de la BDD */
    public static void guardarDades(String taula, Ciutada ciutada) {
        String sqlInsert = "INSERT INTO " + taula + " (id, nom, força, vida, vulnerable, tipus) "
                + "VALUES (? , ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexio.prepareStatement(sqlInsert);
            switch (taula.toLowerCase()) {
                case "huma" ->
                    ciutada = (Huma) ciutada;
                case "vampir" ->
                    ciutada = (Vampir) ciutada;
                case "llop" ->
                    ciutada = (Llop) ciutada;
                case "mestis" ->
                    ciutada = (Mestis) ciutada;
            }
            preparedStatement.setInt(1, 0); //TODO: afegir id
            preparedStatement.setString(2, ciutada.getNom()); //TODO: afegir id

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /* */
    public static void borrarDades(String taula, Ciutada ciutada) {
        String sqlDelete = "DELETE FROM NOM_DE_LA_TAULA WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexio.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, 0/*ciutada.getID()*/); //TODO: getID
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
