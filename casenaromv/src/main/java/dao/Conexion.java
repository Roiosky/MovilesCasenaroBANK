// Declaración del paquete dao (Data Access Object)
package dao;

// Importación de las clases necesarias para manejar la conexión a la base de datos y las excepciones SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Definición de la clase Conexion
public class Conexion {

    // Método público que devuelve un objeto Connection
    public Connection get_connection() {
        // Declaración de la variable connection, inicialmente nula
        Connection connection = null;

        try {
            // Intento de establecer la conexión a la base de datos utilizando la URL de la base de datos, el usuario y la contraseña
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casenarobank", "root", "");

            // Si la conexión es exitosa, se imprime un mensaje en la consola
            if (connection != null) {
                System.out.println("Conexion exitosa");
            }
            // Captura de cualquier excepción SQLException que ocurra durante el intento de conexión
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error 3");
        }

        // Retorna la conexión (si fue exitosa, será un objeto Connection; si falló, será null)
        return connection;
    }
}
