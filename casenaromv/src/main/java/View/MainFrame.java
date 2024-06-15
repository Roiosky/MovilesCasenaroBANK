package View;

import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private JButton registerButton;
    private JButton loginButton;
    private JButton exitButton;
    private JButton operationsButton;

    public MainFrame() {
        setTitle("CasenaroBank");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        registerButton = new JButton("Registro");
        registerButton.setBounds(50, 30, 200, 30);
        registerButton.addActionListener(this);
        add(registerButton);

        loginButton = new JButton("Inicio de Sesion");
        loginButton.setBounds(50, 70, 200, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        operationsButton = new JButton("Operaciones");
        operationsButton.setBounds(50, 110, 200, 30);
        operationsButton.addActionListener(this);
        add(operationsButton);

        exitButton = new JButton("Salir");
        exitButton.setBounds(50, 150, 200, 30);
        exitButton.addActionListener(this);
        add(exitButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            RegisterFrame registerFrame = new RegisterFrame();
            registerFrame.setVisible(true);
        } else if (e.getSource() == loginButton) {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        } else if (e.getSource() == operationsButton) {
            OperationsFrame operationsFrame = new OperationsFrame();
            operationsFrame.setVisible(true);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}

