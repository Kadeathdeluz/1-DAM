
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;

public class CrearPDF {
    public void añadirTexto() throws Exception {
        Document document = new Document();

        String parrafo = "NOTAS DE 1º de DAM" + 
            "\nAlumno: Roldán Sanchis Martínez" + 
            "\nBases de datos: 9" + 
            "\nComputer Systems: 7" + 
            "\nEntornos de Desarrollo: 10" + 
            "\nFormación y Orientación Laboral: 8" + 
            "\nLenguajes de Marcas: 7" + 
            "\nProgramación: 10";

        PdfWriter.getInstance(document, new FileOutputStream("calificaciones_ROLDÁN.pdf"));
        document.open();
        document.add(new Paragraph(parrafo));
        document.close();
    }

    public static void main(String args[]) {
        try {
            CrearPDF p = new CrearPDF();
            p.añadirTexto();
            System.out.println("Fichero creado con éxito.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}