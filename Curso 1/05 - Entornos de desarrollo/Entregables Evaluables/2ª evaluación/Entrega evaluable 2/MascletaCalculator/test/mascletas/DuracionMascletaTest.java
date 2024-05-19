package mascletas;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * Clase de test parametrizada para probar el método calcularDuracionMascleta().
 *
 * @version 2.0 - 28/04/2024
 * @author Roldán Sanchis Martínez
 */
@RunWith(Parameterized.class)
public class DuracionMascletaTest {

    private LocalTime horaIni;
    private LocalTime horaFin;
    private int intesidadSonido;
    private int duracionFuegos;
    private int resultado;

    //Instancia para todas las pruebas
    private static MascletasCalculator instance;

    /**
     * Constructor del test con los parámetros.
     *
     * @param hini Hora de inicio.
     * @param hfin Hora de fin.
     * @param intS Intensidad del sonido.
     * @param durF Duración de los fuegos.
     * @param res Resultado (duración mascletá).
     */
    public DuracionMascletaTest(LocalTime hini, LocalTime hfin, int intS, int durF, int res) {
        this.horaIni = hini;
        this.horaFin = hfin;
        this.intesidadSonido = intS;
        this.duracionFuegos = durF;
        this.resultado = res;
    }

    /**
     * Método que crea y devuelve una colección con los parámetros de las
     * pruebas parametrizadas.
     *
     * @return Devuelve una colección con una lista que contiene todos los
     * parámetros con todos los casos de uso a testear.
     */
    @Parameters
    public static Collection<Object[]> entradas() {
        return Arrays.asList(new Object[][]{
            {LocalTime.of(13, 0), LocalTime.of(13, 15), 3, 5, 26},
            {LocalTime.of(23, 15), LocalTime.of(23, 45), 5, 10, 50},
            {LocalTime.of(14, 30), LocalTime.of(15, 0), 5, 10, 50},
            {LocalTime.of(12, 0), LocalTime.of(13, 0), 0, 0, 60},
            {LocalTime.of(0, 0), LocalTime.of(0, 0), 0, 0, 0}});
    }

    /**
     * Instancia una MascletasCalculator para todas la pruebas.
     */
    @BeforeClass
    public static void prepararTest() {
        instance = new MascletasCalculator();
    }

    /**
     * Test of calcularDuracionMascleta method, of class MascletasCalculator.
     */
    @Test
    public void testCalcularDuracionMascleta() {
        System.out.println("calcularDuracionMascleta");
        int result = instance.calcularDuracionMascleta(this.horaIni, this.horaFin, this.intesidadSonido, this.duracionFuegos);
        assertEquals(this.resultado, result);
    }
}
