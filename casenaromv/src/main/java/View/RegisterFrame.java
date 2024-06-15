package View;

import Help.ValidaPerson;
import dao.PersonDao;
import model.Person;
import service.PersonService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private JLabel idLabel;
    private JTextField idField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel lastNameLabel;
    private JTextField lastNameField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterFrame() {
        setTitle("Registro");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        // Labels y TextFields
        idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 30, 100, 30);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(150, 30, 200, 30);
        add(idField);

        nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(50, 70, 100, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(150, 70, 200, 30);
        add(nameField);

        lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(50, 110, 100, 30);
        add(lastNameLabel);
        lastNameField = new JTextField();
        lastNameField.setBounds(150, 110, 200, 30);
        add(lastNameField);

        phoneLabel = new JLabel("Teléfono:");
        phoneLabel.setBounds(50, 150, 100, 30);
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(150, 150, 200, 30);
        add(phoneField);

        emailLabel = new JLabel("Correo Electrónico:");
        emailLabel.setBounds(50, 190, 100, 30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(150, 190, 200, 30);
        add(emailField);

        passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 230, 100, 30);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 230, 200, 30);
        add(passwordField);

        // Botón de registro
        registerButton = new JButton("Registro");
        registerButton.setBounds(50, 270, 200, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos del formulario
                String id = idField.getText();
                String nombre = nameField.getText();
                String apellido = lastNameField.getText();
                String telefono = phoneField.getText();
                String correo = emailField.getText();
                String clave = new String(passwordField.getPassword());

                // Crear un objeto Person con los valores ingresados por el usuario
                Person person = new Person();
                person.setId_costumer(id);
                person.setCostumer_name(nombre);
                person.setCostumer_last_name(apellido);
                person.setPhone(telefono);
                person.setMail(correo);

                try {
                    person.setPassw(Integer.parseInt(clave));
                } catch (NumberFormatException ex) {
                    // Manejar la excepción si la contraseña no es un número válido
                    JOptionPane.showMessageDialog(RegisterFrame.this, "La contraseña debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Configurar saldo inicial y producto predeterminado
                person.setBalance(0.0);
                person.setProduct(1);

                // Llamar al método createPersonBD de PersonDao para registrar la persona en la base de datos
                PersonDao.createPersonBD(person);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(RegisterFrame.this, "Usuario registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Limpiar los campos del formulario
                clearFields();
            }
        });
        add(registerButton);
    }

    // Método para limpiar los campos del formulario
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }
}



