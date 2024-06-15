// Declaración del paquete service
package service;

// Importación de las clases necesarias
import dao.OperacionesDao; // Para acceder a los métodos del DAO relacionados con operaciones bancarias
import dao.PersonDao;      // Importación no utilizada en este código específico
import model.Person;       // Para manejar objetos de tipo Person

import java.util.List;     // Para manejar listas
import java.util.Scanner;  // Para manejar la entrada de datos desde el usuario

// Definición de la clase OperacionesService
public class OperacionesService {
    private Person usuario; // Atributo para almacenar el usuario actual
    Scanner sc = new Scanner(System.in); // Objeto Scanner para entrada de datos

    // Método para establecer el usuario actual
    public void setUsuario(Person usuario) {
        this.usuario = usuario;
    }

    // Método para realizar diferentes operaciones bancarias
    public void realizarOperaciones() {
        // Menú de operaciones
        System.out.println("Seleccione la operación que desea realizar:");
        System.out.println("1. Abonar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Mostrar movimientos");
        System.out.print("Opción: ");
        int opcion = sc.nextInt(); // Leer la opción seleccionada por el usuario

        // Ejecutar la operación correspondiente según la opción seleccionada
        switch (opcion) {
            case 1:
                // Opción para abonar
                System.out.print("Ingrese el monto a abonar: ");
                double montoAbono = sc.nextDouble(); // Leer el monto a abonar
                OperacionesDao.abonar(usuario.getId_costumer(), montoAbono); // Realizar el abono utilizando el DAO
                break;
            case 2:
                // Opción para retirar
                System.out.print("Ingrese el monto a retirar: ");
                double montoRetiro = sc.nextDouble(); // Leer el monto a retirar
                OperacionesDao.retirar(usuario.getId_costumer(), montoRetiro); // Realizar el retiro utilizando el DAO
                break;
            case 3:
                // Opción para consultar el saldo
                double saldo = OperacionesDao.consultarSaldo(usuario.getId_costumer()); // Consultar el saldo utilizando el DAO
                System.out.println("Saldo actual: $" + saldo); // Mostrar el saldo actual
                break;
            case 4:
                // Opción para mostrar movimientos
                List<String> movimientos = OperacionesDao.obtenerMovimientos(usuario.getId_costumer()); // Obtener los movimientos utilizando el DAO
                System.out.println("Movimientos realizados:");
                for (String movimiento : movimientos) {
                    System.out.println(movimiento); // Mostrar cada movimiento
                }
                break;
            default:
                // Opción no válida
                System.out.println("Opción no válida");
        }
    }

    // Método para ver los movimientos de un usuario específico
    public void verMovimientos(String idCostumer) {
        System.out.println("\n----- Movimientos -----");
        for (String movimiento : OperacionesDao.obtenerMovimientos(idCostumer)) {
            System.out.println(movimiento); // Mostrar cada movimiento
        }
        System.out.println("-----------------------");
    }

    // Método para consultar el saldo de un usuario específico
    public void consultarSaldo(String idCostumer) {
        double saldo = OperacionesDao.consultarSaldo(idCostumer); // Consultar el saldo utilizando el DAO
        System.out.println("\nSaldo actual: $" + saldo); // Mostrar el saldo actual
    }
}
