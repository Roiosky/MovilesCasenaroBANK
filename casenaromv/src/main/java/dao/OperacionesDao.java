// Declaración del paquete dao (Data Access Object)
package dao;

// Importación de las clases necesarias para manejar la conexión a la base de datos, declaraciones preparadas, excepciones SQL, y colecciones
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Definición de la clase OperacionesDao
public class OperacionesDao {

    // Método estático para abonar un monto a la cuenta de un cliente
    public static void abonar(String idCostumer, double monto) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();

        // Consulta SQL para actualizar el saldo del cliente sumando el monto especificado
        String query = "UPDATE costumer SET balance = balance + ? WHERE id_costumer = ?";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece los valores de los parámetros en la consulta SQL
            ps.setDouble(1, monto);
            ps.setString(2, idCostumer);
            // Ejecuta la actualización
            ps.executeUpdate();

            // Registrar el movimiento de abono
            registrarMovimiento(idCostumer, "Abono de $" + monto);
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error al realizar el abono");
        }
    }

    // Método estático para retirar un monto de la cuenta de un cliente
    public static void retirar(String idCostumer, double monto) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();

        // Consulta SQL para actualizar el saldo del cliente restando el monto especificado
        String query = "UPDATE costumer SET balance = balance - ? WHERE id_costumer = ?";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece los valores de los parámetros en la consulta SQL
            ps.setDouble(1, monto);
            ps.setString(2, idCostumer);
            // Ejecuta la actualización
            ps.executeUpdate();

            // Registrar el movimiento de retiro
            registrarMovimiento(idCostumer, "Retiro de $" + monto);
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error al realizar el retiro");
        }
    }

    // Método estático para consultar el saldo de la cuenta de un cliente
    public static double consultarSaldo(String idCostumer) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();
        // Declaración de la variable saldo, inicialmente con valor 0
        double saldo = 0;

        // Consulta SQL para obtener el saldo del cliente
        String query = "SELECT balance FROM costumer WHERE id_costumer = ?";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece el valor del parámetro en la consulta SQL
            ps.setString(1, idCostumer);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet rs = ps.executeQuery();
            // Si se encuentra el saldo del cliente, se asigna a la variable saldo
            if (rs.next()) {
                saldo = rs.getDouble("balance");
            }
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error al consultar el saldo");
        }
        // Retorna el saldo del cliente
        return saldo;
    }

    // Método estático para obtener la lista de movimientos de la cuenta de un cliente
    public static List<String> obtenerMovimientos(String idCostumer) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();
        // Declaración de la lista de movimientos, inicialmente vacía
        List<String> movimientos = new ArrayList<>();

        // Consulta SQL para obtener los movimientos del cliente
        String query = "SELECT movimiento FROM movimientos WHERE id_costumer = ?";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece el valor del parámetro en la consulta SQL
            ps.setString(1, idCostumer);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet rs = ps.executeQuery();
            // Itera sobre el conjunto de resultados y añade cada movimiento a la lista
            while (rs.next()) {
                movimientos.add(rs.getString("movimiento"));
            }
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error al obtener los movimientos");
        }
        // Retorna la lista de movimientos
        return movimientos;
    }

    // Método privado para registrar un movimiento en la base de datos
    private static void registrarMovimiento(String idCostumer, String movimiento) {
        // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
        Conexion conexion = new Conexion();

        // Consulta SQL para insertar un nuevo movimiento en la tabla movimientos
        String query = "INSERT INTO movimientos (id_costumer, movimiento) VALUES (?, ?)";
        try (
                // Establece la conexión a la base de datos
                Connection connection = conexion.get_connection();
                // Prepara la declaración SQL con la consulta definida
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            // Establece los valores de los parámetros en la consulta SQL
            ps.setString(1, idCostumer);
            ps.setString(2, movimiento);
            // Ejecuta la inserción
            ps.executeUpdate();
            // Captura de cualquier excepción SQLException que ocurra durante la ejecución de la consulta
        } catch (SQLException e) {
            // Se imprime la excepción en la consola
            System.out.println(e);
            // Se imprime un mensaje de error adicional
            System.out.println("Error al registrar el movimiento");
        }
    }
}
