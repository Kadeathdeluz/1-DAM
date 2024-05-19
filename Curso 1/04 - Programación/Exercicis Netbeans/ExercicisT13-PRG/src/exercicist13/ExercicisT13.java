package exercicist13;

import exercicist13.utils.ConexionBDD;
import exercicist13.utils.Productes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ExercicisT13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //exercici1();
        //exercici2();
        //exercici3();
        //exercici4();
        //exercici5();
        //exercici6();
        exercici7();
    }

    public static void exercici1() {
        //Datos para la conexión (URL, user y pass)
        final String url = "jdbc:mysql://localhost:3306/uf13";
        final String username = "root";
        final String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM productos1");

            while (resultSet.next()) {
                System.out.println("Producto: " + resultSet.getString("NOMBRE"));
            }

            //Cerramos el ResultSet, el Statement y finalmente la Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }

    public static void exercici2() {
        //Datos para la conexión (URL, user y pass)
        final String url = "jdbc:mysql://localhost:3306/uf13";
        final String username = "root";
        final String password = "";

        //Try-catch con auto-close de Connection
        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM productos1")) {

            while (resultSet.next()) {
                System.out.println("--------- Producto ---------");
                System.out.println("Código: " + resultSet.getString("CODIGO_ARTICULO"));
                System.out.println("Sección: " + resultSet.getString("SECCION"));
                System.out.println("Nombre: " + resultSet.getString("NOMBRE"));
                System.out.println("Precio: " + resultSet.getDouble("PRECIO") + "€");
                System.out.println("País: " + resultSet.getString("PAIS"));
                System.out.println("Fecha: " + resultSet.getDate("FECHA"));
                System.out.println("----------------------------\n");
            }
        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }

    public static void exercici3() {

        //Try-catch con auto-close de Connection creada con Conexion.getConexio()
        try (Connection connection = ConexionBDD.getConexio(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM productos1")) {

            while (resultSet.next()) {
                System.out.println("--------- Producto ---------");
                System.out.println("Código: " + resultSet.getString("CODIGO_ARTICULO"));
                System.out.println("Sección: " + resultSet.getString("SECCION"));
                System.out.println("Nombre: " + resultSet.getString("NOMBRE"));
                System.out.println("Precio: " + resultSet.getDouble("PRECIO") + "€");
                System.out.println("País: " + resultSet.getString("PAIS"));
                System.out.println("Fecha: " + resultSet.getDate("FECHA"));
                System.out.println("----------------------------\n");
            }
        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }

    public static void exercici4() {

        //Try-catch con auto-close de Connection creada con Conexion.getConexio()
        try (Connection connection = ConexionBDD.getConexio();) {

            if (!ConexionBDD.existeTabla("productos2")) {
                ConexionBDD.crearTablaProductos();
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM productos2");
            while (resultSet.next()) {
                System.out.println("--------- Producto ---------");
                System.out.println("Código: " + resultSet.getString("CODIGO_ARTICULO"));
                System.out.println("Sección: " + resultSet.getString("SECCION"));
                System.out.println("Nombre: " + resultSet.getString("NOMBRE"));
                System.out.println("Precio: " + resultSet.getDouble("PRECIO") + "€");
                System.out.println("País: " + resultSet.getString("PAIS"));
                System.out.println("Fecha: " + resultSet.getDate("FECHA"));
                System.out.println("----------------------------\n");
            }

            //Cerramos el resultSet y el statement
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }

    public static void exercici5() {

        //Try-catch con auto-close de Connection creada con Conexion.getConexio()
        try (Connection connection = ConexionBDD.getConexio();) {

            if (!ConexionBDD.existeTabla("productos2")) {
                ConexionBDD.crearTablaProductos();
            }

            String query = "SELECT * FROM productos2 WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Deportes");
            preparedStatement.setString(2, "Alemania");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("--------- Producto ---------");
                System.out.println("Código: " + resultSet.getString("CODIGO_ARTICULO"));
                System.out.println("Sección: " + resultSet.getString("SECCION"));
                System.out.println("Nombre: " + resultSet.getString("NOMBRE"));
                System.out.println("Precio: " + resultSet.getDouble("PRECIO") + "€");
                System.out.println("País: " + resultSet.getString("PAIS"));
                System.out.println("Fecha: " + resultSet.getDate("FECHA"));
                System.out.println("----------------------------\n");
            }

            //Cerramos el resultSet y el statement
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }

    public static void exercici6() {

        //Try-catch con auto-close de Connection creada con Conexion.getConexio()
        try (Connection connection = ConexionBDD.getConexio();) {

            if (!ConexionBDD.existeTabla("productos2")) {
                ConexionBDD.crearTablaProductos();
            }

            String query = "SELECT * FROM productos2 WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Deportes");
            preparedStatement.setString(2, "Alemania");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("--------- Producto ---------");
                System.out.println("Código: " + resultSet.getString("CODIGO_ARTICULO"));
                System.out.println("Sección: " + resultSet.getString("SECCION"));
                System.out.println("Nombre: " + resultSet.getString("NOMBRE"));
                System.out.println("Precio: " + resultSet.getDouble("PRECIO") + "€");
                System.out.println("País: " + resultSet.getString("PAIS"));
                System.out.println("Fecha: " + resultSet.getDate("FECHA"));
                System.out.println("----------------------------\n");
            }

            //Cerramos el resultSet y el statement
            resultSet.close();
            preparedStatement.close();

            //Creamos la nueva consulta, en este caso un Update
            String update = "UPDATE productos2 SET PRECIO = ? WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement updatePreparedStatement = connection.prepareStatement(update);
            updatePreparedStatement.setDouble(1, 9999); //Nuevo precio
            updatePreparedStatement.setString(2, "Deportes"); //Seccion
            updatePreparedStatement.setString(3, "Alemania"); //Pais

            //El update devuelve un int que corresponde al número de filas afectadas por el update
            int rowsAffected = updatePreparedStatement.executeUpdate();

            //Utilizo un Elvis operator en lugar de un if-else con dos sout.
            System.out.println(rowsAffected > 0 ? (rowsAffected + " filas afectadas.") : "Ninguna fila actualizada.");

        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }

    public static void exercici7() {

        //Try-catch con auto-close de Connection creada con Conexion.getConexio()
        try (Connection connection = ConexionBDD.getConexio();) {

            if (!ConexionBDD.existeTabla("productos2")) {
                ConexionBDD.crearTablaProductos();
            }

            String query = "SELECT * FROM productos2 WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Deportes");
            preparedStatement.setString(2, "Alemania");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("--------- Producto ---------");
                System.out.println("Código: " + resultSet.getString("CODIGO_ARTICULO"));
                System.out.println("Sección: " + resultSet.getString("SECCION"));
                System.out.println("Nombre: " + resultSet.getString("NOMBRE"));
                System.out.println("Precio: " + resultSet.getDouble("PRECIO") + "€");
                System.out.println("País: " + resultSet.getString("PAIS"));
                System.out.println("Fecha: " + resultSet.getDate("FECHA"));
                System.out.println("----------------------------");
            }

            //Cerramos el resultSet y el statement
            resultSet.close();
            preparedStatement.close();

            //Creamos la nueva consulta, en este caso un Update
            String update = "UPDATE productos2 SET PRECIO = ? WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement updatePreparedStatement = connection.prepareStatement(update);
            updatePreparedStatement.setDouble(1, 9999); //Nuevo precio
            updatePreparedStatement.setString(2, "Deportes"); //Seccion
            updatePreparedStatement.setString(3, "Alemania"); //Pais

            //El update devuelve un int que corresponde al número de filas afectadas por el update
            int rowsAffected = updatePreparedStatement.executeUpdate();

            //Utilizo un Elvis operator en lugar de un if-else con dos sout.
            System.out.println((rowsAffected > 0 ? (rowsAffected + " fila/s afectada/s.") : ("Ninguna fila actualizada.") )+ "\n");

            //Llista de productes
            ArrayList<Productes> llistaProductes = new ArrayList<>();
            //Query per a consultar tots els productes de la taula de la BD
            String select = """
                            SELECT * 
                            FROM productos2
                            """;
            Statement selectAll = connection.createStatement();
            ResultSet productes = selectAll.executeQuery(select);

            while (productes.next()) {
                Productes nouProducte = new Productes(
                        productes.getString("CODIGO_ARTICULO"),
                        productes.getString("SECCION"),
                        productes.getString("NOMBRE"),
                        productes.getDouble("PRECIO"),
                        productes.getString("PAIS"),
                        productes.getDate("FECHA"));
                llistaProductes.add(nouProducte);
            }
            
            for(Productes producte : llistaProductes) {
                System.out.println(producte.toString());
            }

        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }

    public static void exerciciProva() {
        //Datos para la conexión (URL, user y pass)
        final String url = "jdbc:mysql://localhost:3306/prova";
        final String username = ConexionBDD.getUSERNAME();
        final String password = ConexionBDD.getPASSWORD();

        //Try-catch con auto-close de Connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            //Nos conectamos a la base de datos mediante la url

            //Preparamos nuestra query para el PreparedStatement ? y ? se añaden luego
            String query = "SELECT * "
                    + "FROM venedors "
                    + "WHERE salari BETWEEN ? AND ?";
            //PreparedStatement con la query preparada
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "10000");
            preparedStatement.setString(2, "17000");

            //El ResultSet de la query resultante tras el PreparedStatement
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("--------- Venedor ---------");
                System.out.println("ID:" + resultSet.getInt("id"));
                System.out.println("Nom: " + resultSet.getString("nom"));
                System.out.println("Data d'ingrés: " + resultSet.getDate("data_ingres"));
                System.out.println("Salari: " + resultSet.getFloat("salari"));
                System.out.println("---------------------------\n");
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.err.println("EXCEPCIÓN SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("OTRA EXCEPCIÓN: " + e.getMessage());
        }
    }
}
