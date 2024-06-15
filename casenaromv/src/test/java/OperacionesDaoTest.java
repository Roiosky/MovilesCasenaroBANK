import dao.OperacionesDao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperacionesDaoTest {

    @Test
    public void testConsultarSaldo() {
        // Simulamos un id de cliente existente en la base de datos
        String idClienteExistente = "1";

        // Saldo Cliente
        double saldoEsperado = 1910.0;

        // saldo real
        double saldoReal = OperacionesDao.consultarSaldo(idClienteExistente);

        // Comparamos el saldo esperado con el saldo real
        assertEquals(saldoEsperado, saldoReal);
    }
}


