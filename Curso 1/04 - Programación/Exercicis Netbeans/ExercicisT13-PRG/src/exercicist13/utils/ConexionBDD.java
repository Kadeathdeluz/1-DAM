package exercicist13.utils;

import java.sql.*;

/**
 * La creació de la clase forma part de l'exercici 3.
 *
 * @author Roldán Sanchis Martínez
 */
public class ConexionBDD {

    private static final String URL = "jdbc:mysql://localhost:3306/uf13",
            USERNAME = "root",
            PASSWORD = "";
    private static Connection conexion;

    /**
     * @return the URL
     */
    public static String getURL() {
        return URL;
    }

    /**
     * @return the USERNAME
     */
    public static String getUSERNAME() {
        return USERNAME;
    }

    /**
     * @return the PASSWORD
     */
    public static String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * Retorna una conexión basada en l'URL, el USERNAME y el PASSWORD de la
     * clase. Forma part de l'exercici 3. Implementació del patró Singleton.
     *
     * @return
     * @throws java.sql.SQLException
     */
    public static Connection getConexio() throws SQLException {
        if (conexion == null) {
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return conexion;
    }

    /**
     * Forma part de l'exercici 4.
     *
     * @param tabla
     * @return
     * @throws java.sql.SQLException
     */
    public static boolean existeTabla(String tabla) throws SQLException {
        boolean existe = false;

        String query = "SELECT COUNT(*) "
                + "FROM information_schema.tables "
                + "WHERE table_name = '" + tabla + "'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        //Si hay más de 0 tablas con ese nombre quiere decir que existe
        if (resultSet.next() && resultSet.getInt(1) > 0) {
            existe = true;
        }

        resultSet.close();
        preparedStatement.close();

        return existe;
    }

    public static void crearTablaProductos() throws SQLException {
        String create = """
                        CREATE TABLE IF NOT EXISTS productos2 (
                        CODIGO_ARTICULO VARCHAR(10) PRIMARY KEY,
                        SECCION VARCHAR(50) NOT NULL,
                        NOMBRE VARCHAR(50) NOT NULL,
                        PRECIO DOUBLE NOT NULL,
                        PAIS VARCHAR(50) NOT NULL,
                        FECHA DATE NOT NULL)
                        """;
        //Creamos la tabla
        conexion.createStatement().execute(create);

        //Creamos 6 arrays para las 6 columnas, de modo que podamos insertar los 5 productos aleatorios
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

        //Inserta 5 productos
        for (int i = 0; i <codigos.length; i++) {
            String insert = "INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(insert);
            preparedStatement.setString(1, codigos[i]);
            preparedStatement.setString(2, secciones[i]);
            preparedStatement.setString(3, nombres[i]);
            preparedStatement.setDouble(4, precios[i]);
            preparedStatement.setString(5, paises[i]);
            preparedStatement.setDate(6, fechas[i]);
            //Lanza la preparedStatement a la BD para actualizar los datos
            preparedStatement.executeUpdate();
        }
        
        System.out.println("Datos insertados correctamente.");
    }

}
