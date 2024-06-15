package service; // Define el paquete al que pertenece esta clase

import model.Person; // Importa la clase Person del paquete model
import Help.ValidaPerson; // Importa la clase ValidaPerson del paquete Help

import java.util.Scanner; // Importa la clase Scanner del paquete java.util para leer entradas del usuario

public class TestPersonS { // Define la clase principal TestPersonS
    public static void main(String[] args) { // Método principal
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer entradas del usuario
        boolean salir = false; // Define una variable booleana para controlar el ciclo del menú principal
        Person usuario = null; // Declara una variable Person para almacenar el usuario actual

        // Ciclo que se ejecuta mientras el usuario no decida salir
        while (!salir) {
            if (usuario == null) { // Si no hay un usuario autenticado
                mostrarMenuInicial(); // Muestra el menú inicial
                System.out.print("Seleccione una opción: "); // Pide al usuario que seleccione una opción
                int opcion = sc.nextInt(); // Lee la opción seleccionada por el usuario

                // Ejecuta una acción según la opción seleccionada por el usuario
                switch (opcion) {
                    case 1:
                        usuario = registrarUsuario(sc); // Registra un nuevo usuario
                        break;
                    case 2:
                        usuario = iniciarSesion(sc); // Inicia sesión con un usuario existente
                        break;
                    case 3:
                        salir = true; // Cambia la variable salir a true para salir del ciclo
                        break;
                    default:
                        System.out.println("Opción no válida"); // Informa que la opción no es válida
                }
            } else { // Si ya hay un usuario autenticado
                mostrarMenuOperaciones(); // Muestra el menú de operaciones
                System.out.print("Seleccione una operación: "); // Pide al usuario que seleccione una operación
                int opcion = sc.nextInt(); // Lee la opción seleccionada por el usuario

                OperacionesService operacionesService = new OperacionesService(); // Crea un objeto OperacionesService
                operacionesService.setUsuario(usuario); // Pasa el usuario autenticado a OperacionesService

                // Ejecuta una acción según la operación seleccionada por el usuario
                switch (opcion) {
                    case 1:
                        operacionesService.realizarOperaciones(); // Realiza operaciones
                        break;
                    case 2:
                        operacionesService.verMovimientos(usuario.getId_costumer()); // Ve movimientos del usuario
                        break;
                    case 3:
                        operacionesService.consultarSaldo(usuario.getId_costumer()); // Consulta el saldo del usuario
                        break;
                    case 4:
                        PdfGenerator.generateMovimientosPDF(usuario.getId_costumer()); // Genera un PDF con los movimientos del usuario
                        break;
                    case 5:
                        salir = true; // Cambia la variable salir a true para salir del ciclo
                        break;
                    default:
                        System.out.println("Opción no válida"); // Informa que la opción no es válida
                }
            }
        }
    }

    // Método que muestra el menú inicial
    public static void mostrarMenuInicial() {
        System.out.println("\n----- Menú Inicial -----");
        System.out.println("1. Registro");
        System.out.println("2. Inicio de sesión");
        System.out.println("3. Salir");
        System.out.println("-------------------------\n");
    }

    // Método que muestra el menú de operaciones
    public static void mostrarMenuOperaciones() {
        System.out.println("\n----- Menú de Operaciones -----");
        System.out.println("1. Realizar operación");
        System.out.println("2. Ver movimientos");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Imprimir movimientos");
        System.out.println("5. Salir");
        System.out.println("--------------------------------\n");
    }

    // Método que registra un nuevo usuario
    public static Person registrarUsuario(Scanner sc) {
        PersonService personService = new PersonService(); // Crea un objeto PersonService
        Person person = new Person(); // Crea un objeto Person
        personService.crearPersona(person, sc); // Llama al método crearPersona, pasando el objeto Person y el Scanner como argumentos
        return person; // Retorna el objeto Person registrado
    }

    // Método que inicia sesión con un usuario existente
    public static Person iniciarSesion(Scanner sc) {
        LoginService loginService = new LoginService(); // Crea un objeto LoginService
        return loginService.iniciarSesion(sc); // Llama al método iniciarSesion, pasando el Scanner como argumento, y retorna el usuario autenticado
    }
}
