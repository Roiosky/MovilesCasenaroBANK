// Declaración del paquete model
package model;

// Importación de las clases necesarias para manejar listas y el escáner
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

// Definición de la clase Person
public class Person {

    // Creación de un objeto Scanner para entrada de datos
    Scanner sc = new Scanner(System.in);

    // Declaración de atributos privados
    private String id_costumer, costumer_name, costumer_last_name, phone, mail;
    private int passw;
    private double balance;
    private int product;

    // Lista para almacenar los movimientos del cliente
    private List<String> movimientos;

    // Constructor por defecto que inicializa la lista de movimientos
    public Person() {
        this.movimientos = new ArrayList<>();
    }

    // Constructor que inicializa todos los atributos de la clase
    public Person(String id_costumer, String costumer_name, String costumer_last_name, String phone, String mail, int passw, double balance, int product) {
        this.id_costumer = id_costumer;
        this.costumer_name = costumer_name;
        this.costumer_last_name = costumer_last_name;
        this.phone = phone;
        this.mail = mail;
        this.passw = passw;
        this.balance = balance;
        this.product = product;
        this.movimientos = new ArrayList<>();
    }

    // Método para agregar un movimiento a la lista de movimientos
    public void agregarMovimiento(String movimiento) {
        movimientos.add(movimiento);
    }

    // Método para obtener la lista de movimientos
    public List<String> getMovimientos() {
        return movimientos;
    }

    // Método para establecer la lista de movimientos
    public void setMovimientos(List<String> movimientos) {
        this.movimientos = movimientos;
    }

    // Métodos getter y setter para el atributo id_costumer
    public String getId_costumer() {
        return id_costumer;
    }

    public void setId_costumer(String id_costumer) {
        this.id_costumer = id_costumer;
    }

    // Métodos getter y setter para el atributo costumer_name
    public String getCostumer_name() {
        return costumer_name;
    }

    public void setCostumer_name(String costumer_name) {
        this.costumer_name = costumer_name;
    }

    // Métodos getter y setter para el atributo costumer_last_name
    public String getCostumer_last_name() {
        return costumer_last_name;
    }

    public void setCostumer_last_name(String costumer_last_name) {
        this.costumer_last_name = costumer_last_name;
    }

    // Métodos getter y setter para el atributo phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Métodos getter y setter para el atributo mail
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // Métodos getter y setter para el atributo passw
    public int getPassw() {
        return passw;
    }

    public void setPassw(int passw) {
        this.passw = passw;
    }

    // Métodos getter y setter para el atributo balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Métodos getter y setter para el atributo product
    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }
}
