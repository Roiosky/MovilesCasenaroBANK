// Declaración del paquete service
package service;

// Importación de las clases necesarias
import Help.ValidaPerson;  // Para validar el correo electrónico y la clave
import dao.LoginDao;       // Para acceder a los métodos del Data Access Object (DAO) relacionados con el login
import dao.PersonDao;      // Importación a la personDao
import model.Person;       // Para manejar objetos de tipo Person

import java.util.Scanner;  // Para manejar la entrada de datos desde el usuario

// Definición de la clase LoginService
public class LoginService {

    // Creación de un objeto Scanner para entrada de datos
    Scanner sc = new Scanner(System.in);

    // Declaración del atributo privado usuario de tipo Person
    private Person usuario;

    // Método para iniciar sesión
    public Person iniciarSesion(Scanner sc) {
        System.out.println("¡Bienvenido al inicio de sesión!");

        // Solicitar y validar el correo electrónico
        System.out.print("Ingrese su correo electrónico: ");
        String correo = sc.next();
        while (!ValidaPerson.validarCorreo(correo)) {
            System.out.print("Correo electrónico inválido. Por favor, ingrese un correo electrónico válido: ");
            correo = sc.next();
        }

        // Solicitar y validar la clave
        System.out.print("Ingrese su clave: ");
        String clave = sc.next();
        while (!ValidaPerson.validarClave(clave)) {
            System.out.print("Clave inválida. Por favor, ingrese una clave válida de 4 dígitos: ");
            clave = sc.next();
        }

        // Buscar el usuario por correo electrónico usando el DAO de login
        usuario = LoginDao.getPersonByEmail(correo);

        // Verificar si el usuario existe y si la clave es correcta
        if (usuario != null && Integer.parseInt(clave) == usuario.getPassw()) {
            System.out.println("Inicio de sesión exitoso");
            return usuario;  // Retornar el usuario si el inicio de sesión es exitoso
        } else {
            System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
            return null;  // Retornar null si el inicio de sesión falla
        }
    }
}
