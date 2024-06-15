// Declaración del paquete dao (Data Access Object)
package dao;

// Importación de la clase Connection y SQLException necesarias para manejar la conexión a la base de datos y excepciones SQL
import java.sql.Connection;
import java.sql.SQLException;

// Definición de la clase TestConexion
public class TestConexion {

    // Constructor de la clase TestConexion
    public TestConexion() {
    }

    // Método principal que se ejecuta cuando se inicia el programa
    public static void main(String[] args) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();

        try {
            // Establece la conexión a la base de datos
            Connection connection = conexion.get_connection();
            // Verifica si la conexión se ha establecido correctamente
            if (connection != null) {
                // Cierra la conexión
                connection.close();
            }
            // Captura de cualquier excepción SQLException que ocurra durante el manejo de la conexión
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error 4");
        }
    }
}
