// Declaración del paquete dao (Data Access Object)
package dao;

// Importación de la clase Person del paquete model
import model.Person;

// Importación de las clases necesarias para manejar la conexión a la base de datos, declaraciones preparadas, excepciones SQL, y colecciones
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Definición de la clase PersonDao
public class PersonDao {

    // Constructor de la clase PersonDao
    public PersonDao() {
    }

    // Método estático para crear un nuevo registro de una persona en la base de datos
    public static void createPersonBD(Person person) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();

        // Verificar si ya existe un registro con el mismo ID
        if (personExistsWithId(person.getId_costumer())) {
            System.out.println("¡Error! El usuario ya está registrado con este ID.");
            return;
        }

        // Verificar si ya existe un registro con el mismo correo electrónico
        if (personExistsWithEmail(person.getMail())) {
            System.out.println("¡Error! El usuario ya está registrado con este correo electrónico.");
            return;
        }

        // Consulta SQL para insertar un nuevo registro en la tabla costumer
        String query = "INSERT INTO costumer (id_costumer, costumer_name, costumer_last_name, phone, mail, passw, balance, product) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece los valores de los parámetros en la consulta SQL
            ps.setString(1, person.getId_costumer());
            ps.setString(2, person.getCostumer_name());
            ps.setString(3, person.getCostumer_last_name());
            ps.setString(4, person.getPhone());
            ps.setString(5, person.getMail());
            ps.setInt(6, person.getPassw());
            ps.setDouble(7, person.getBalance());
            ps.setInt(8, person.getProduct());

            // Ejecutar la inserción
            int rowsAffected = ps.executeUpdate();
            // Verificar si se afectaron filas (si se realizó la inserción)
            if (rowsAffected > 0) {
                System.out.println("Registro de Cliente exitoso");
            } else {
                System.out.println("No se pudo insertar el registro");
            }
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error 2");
        }
    }

    // Método para verificar si ya existe un registro con el mismo ID
    private static boolean personExistsWithId(String id) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();
        // Consulta SQL para contar los registros con el ID especificado
        String query = "SELECT COUNT(*) FROM costumer WHERE id_costumer = ?";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece el valor del parámetro en la consulta SQL
            ps.setString(1, id);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet rs = ps.executeQuery();
            // Si se encuentra un resultado, verifica si el conteo es mayor a 0
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para verificar si ya existe un registro con el mismo correo electrónico
    private static boolean personExistsWithEmail(String email) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();
        // Consulta SQL para contar los registros con el correo electrónico especificado
        String query = "SELECT COUNT(*) FROM costumer WHERE mail = ?";
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
            // Si se encuentra un resultado, verifica si el conteo es mayor a 0
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
