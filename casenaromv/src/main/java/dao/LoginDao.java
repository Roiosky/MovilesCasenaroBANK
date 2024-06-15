// Declaración del paquete dao (Data Access Object)
package dao;

// Importación de la clase Person del paquete model
import model.Person;

// Importación de las clases necesarias para manejar la conexión a la base de datos, declaraciones preparadas y excepciones SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Definición de la clase LoginDao
public class LoginDao {

    // Método estático que devuelve un objeto Person basado en el correo electrónico proporcionado
    public static Person getPersonByEmail(String email) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();
        // Declaración de la variable usuario de tipo Person, inicialmente nula
        Person usuario = null;

        // Consulta SQL para seleccionar los datos del usuario basado en el correo electrónico
        String query = "SELECT * FROM costumer WHERE mail = ?";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece el valor del parámetro en la consulta SQL
            ps.setString(1, email);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet rs = ps.executeQuery();
            // Si se encuentra un usuario con ese correo, se crea un objeto Person con los datos obtenidos de la base de datos
            if (rs.next()) {
                usuario = new Person(
                        rs.getString("id_costumer"),         // ID del cliente
                        rs.getString("costumer_name"),       // Nombre del cliente
                        rs.getString("costumer_last_name"),  // Apellido del cliente
                        rs.getString("phone"),               // Teléfono del cliente
                        rs.getString("mail"),                // Correo electrónico del cliente
                        rs.getInt("passw"),                  // Contraseña del cliente (probablemente debería ser un hash)
                        rs.getDouble("balance"),             // Saldo del cliente
                        rs.getInt("product")                 // Producto asociado al cliente
                );
            }
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error al obtener el usuario por correo electrónico");
        }
        // Retorna el objeto Person (si se encontró uno, será un objeto Person; si no, será null)
        return usuario;
    }
}
