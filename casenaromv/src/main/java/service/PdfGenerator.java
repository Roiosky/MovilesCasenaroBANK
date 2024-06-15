// Declaración del paquete service
package service;

// Importación de las clases necesarias de la biblioteca iText para generar PDFs
import com.itextpdf.kernel.geom.PageSize; // Para definir el tamaño de la página
import com.itextpdf.kernel.pdf.PdfDocument; // Para manejar documentos PDF
import com.itextpdf.kernel.pdf.PdfWriter; // Para escribir documentos PDF
import com.itextpdf.layout.Document; // Para manejar el contenido del documento
import com.itextpdf.layout.element.Paragraph; // Para manejar párrafos en el documento
import com.itextpdf.layout.element.Table; // Para manejar tablas en el documento

// Importación de la clase OperacionesDao para obtener movimientos
import dao.OperacionesDao;

import java.io.FileNotFoundException; // Para manejar excepciones cuando no se encuentra el archivo
import java.util.List; // Para manejar listas

// Definición de la clase PdfGenerator
public class PdfGenerator {

    // Método para generar un PDF con los movimientos de un cliente específico
    public static void generateMovimientosPDF(String idCustomer) {
        // Obtener la lista de movimientos del cliente utilizando el DAO
        List<String> movimientos = OperacionesDao.obtenerMovimientos(idCustomer);

        try {
            // Crear un escritor de PDF apuntando a un archivo llamado "movimientos.pdf"
            PdfWriter writer = new PdfWriter("movimientos.pdf");

            // Crear un documento PDF utilizando el escritor
            PdfDocument pdf = new PdfDocument(writer);

            // Crear un documento iText con el tamaño de página A4
            Document document = new Document(pdf, PageSize.A4);

            // Agregar un párrafo de título al documento
            document.add(new Paragraph("Movimientos"));

            // Crear una tabla con una columna
            Table table = new Table(1);

            // Agregar cada movimiento como una celda en la tabla
            for (String movimiento : movimientos) {
                table.addCell(movimiento);
            }

            // Agregar la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();
            System.out.println("PDF generado exitosamente.");
        } catch (FileNotFoundException e) {
            // Manejar la excepción en caso de que no se encuentre el archivo
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }
}
