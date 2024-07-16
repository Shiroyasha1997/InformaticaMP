package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String USER = "root";
    private static final String PASSWORD = "mp2024";
    private static final String DATABASE = "informatica_mp";
    private static final String URL = "jdbc:mysql://localhost/" + DATABASE;

    public static Connection getConexion() throws SQLException {
        Connection connection = null;
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Manejar errores al conectar
            System.err.println("Error al conectar con la base de datos.");
            e.printStackTrace();
            throw e; // Relanzar la excepción para manejarla en otro lugar si es necesario
        }
        return connection;
    }

    public static void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Manejar errores al cerrar la conexión
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
