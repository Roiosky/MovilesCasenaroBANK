
package Help;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ValidaPerson {

        private static final String ID_REGEX = "^\\d+$"; // valida si una cadena contiene solo dígitos
        private static final String NAME_REGEX = "^[a-zA-ZáéíóúÉÓÚñÑ\\s]+"; // valida si una cadena contiene solo letras (mayúsculas o minúsculas)
        private static final String LASTNAME_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        private static final String PHONE_REGEX = "^(?:[0-9] ?){6,14}[0-9]$";
        private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        private static final String PASSWORD_REGEX = "^\\d{4}$"; // Validación de clave de 4 dígitos

        private static final Pattern idPattern = Pattern.compile(ID_REGEX);
        private static final Pattern namePattern = Pattern.compile(NAME_REGEX);
        private static final Pattern lastNamePattern = Pattern.compile(NAME_REGEX);
        private static final Pattern phonePattern = Pattern.compile(PHONE_REGEX);
        private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        private static final Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);

        public ValidaPerson() {
        }

        public static boolean validarId(String id) {
            try {
                return idPattern.matcher(id).matches();
            } catch (PatternSyntaxException e) {
                System.err.println("Error en el ingreso de su ID, intente nuevamente: " + e.getMessage()); //Este método devuelve una cadena que describe la excepción.
                return false;
            }
        }

        public static boolean validarNombre(String name) {
            try {
                return namePattern.matcher(name).matches();
            } catch (PatternSyntaxException e) {
                System.err.println("Error en el ingreso de su Nombre, intente nuevamente: " + e.getMessage());
                return false;
            }
        }

    public static boolean validarApellido(String last_name) {
        try {
            return lastNamePattern.matcher(last_name).matches();
        } catch (PatternSyntaxException e) {
            System.err.println("Error en el ingreso de su Apellido, intente nuevamente: " + e.getMessage());
            return false;
        }
    }


    public static boolean validarTelefono(String telefono) {
            try {
                return phonePattern.matcher(telefono).matches();
            } catch (PatternSyntaxException e) {
                System.err.println("Error en el ingreso de su Telefono, intente nuevamente: " + e.getMessage());
                return false;
            }
        }

        public static boolean validarCorreo(String correo) {
            try {
                return emailPattern.matcher(correo).matches();
            } catch (PatternSyntaxException e) {
                System.err.println("Error en el ingreso de su correo, intente nuevamente: " + e.getMessage());
                return false;
            }
        }

        public static boolean validarClave(String clave) {
            try {
                return passwordPattern.matcher(clave).matches();
            } catch (PatternSyntaxException e) {
                System.err.println("Error en el ingreso de su correo, intente nuevamente: " + e.getMessage());
                return false;
            }
        }

    }


