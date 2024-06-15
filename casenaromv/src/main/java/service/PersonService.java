// Declaración del paquete service
package service;

// Importación de la clase ValidaPerson para validar los datos ingresados
import Help.ValidaPerson;

// Importación de la clase PersonDao para manejar las operaciones relacionadas con la base de datos
import dao.PersonDao;

// Importación de la clase Person que representa un cliente
import model.Person;

// Importación de la clase Scanner para leer la entrada del usuario
import java.util.Scanner;

// Definición de la clase PersonService
public class PersonService {
    // Creación de un objeto Scanner para leer la entrada del usuario
    Scanner sc = new Scanner(System.in);

    // Método para crear un nuevo registro de persona en la base de datos
    public void crearPersona(Person person, Scanner sc) {
        // Mensaje de bienvenida
        System.out.println("¡Bienvenido al registro!");

        // Solicitar y validar el ID del cliente
        System.out.print("Ingrese su Id: ");
        String id = sc.next();
        while (!ValidaPerson.validarId(id)) {
            System.out.print("ID inválido. Por favor, ingrese un ID válido: ");
            id = sc.next();
        }

        // Solicitar y validar el nombre del cliente
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.next();
        while (!ValidaPerson.validarNombre(nombre)) {
            System.out.print("Nombre inválido. Por favor, ingrese un nombre válido: ");
            nombre = sc.next();
        }

        // Solicitar y validar el apellido del cliente
        System.out.print("Ingrese su apellido: ");
        String apellido = sc.next();
        while (!ValidaPerson.validarApellido(apellido)) {
            System.out.print("Apellido inválido. Por favor, ingrese un apellido válido: ");
            apellido = sc.next();
        }

        // Solicitar y validar el teléfono del cliente
        System.out.print("Ingrese su telefono: ");
        String telefono = sc.next();
        while (!ValidaPerson.validarTelefono(telefono)) {
            System.out.print("Telefono inválido. Por favor, ingrese uno válido: ");
            telefono = sc.next();
        }

        // Solicitar y validar el correo electrónico del cliente
        System.out.print("Ingrese su correo eletrónico: ");
        String correo = sc.next();
        while (!ValidaPerson.validarCorreo(correo)) {
            System.out.print("Correo inválido. Por favor, ingrese un correo válido: ");
            correo = sc.next();
        }

        // Solicitar y validar la clave del cliente
        System.out.print("Ingrese una clave de 4 dígitos para iniciar: ");
        int clave = sc.nextInt();
        while (!ValidaPerson.validarClave(String.valueOf(clave))) {
            System.out.print("Clave inválida. Por favor, ingrese una clave de 4 dígitos: ");
            clave = sc.nextInt();
        }

        // Solicitar el saldo inicial del cliente
        System.out.print("Ingrese el monto con el que desea abrir su cuenta: ");
        double saldo = sc.nextDouble();

        // Solicitar el tipo de producto (cuenta de ahorro)
        System.out.println("Por favor ingrese 1 para crear su cuenta de ahorro con nosotros:");
        int producto = sc.nextInt();

        // Establecer los datos validados en el objeto Person
        person.setId_costumer(id);
        person.setCostumer_name(nombre);
        person.setCostumer_last_name(apellido);
        person.setPhone(telefono);
        person.setMail(correo);
        person.setPassw(clave);
        person.setBalance(saldo);
        person.setProduct(producto);

        // Crear el registro del cliente en la base de datos
        PersonDao.createPersonBD(person);
    }
}
