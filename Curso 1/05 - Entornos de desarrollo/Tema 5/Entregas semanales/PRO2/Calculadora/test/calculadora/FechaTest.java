package calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class FechaTest {

    @Test
    public void testDevuelveFecha_error() {
        int tipo = 0;
        Fecha instance = new Fecha();
        String expResult = "ERROR";
        String result = instance.devuelveFecha(tipo);
        assertEquals(expResult, result);
    }
    @Test
    public void testDevuelveFecha_tipo1() {
        int tipo = 1;
        Fecha instance = new Fecha();
        String expResult = "2024/02";
        String result = instance.devuelveFecha(tipo);
        assertEquals(expResult, result);
    }
    @Test
    public void testDevuelveFecha_tipo2() {
        int tipo = 2;
        Fecha instance = new Fecha();
        String expResult = "02/2024";
        String result = instance.devuelveFecha(tipo);
        assertEquals(expResult, result);
    }
    @Test
    public void testDevuelveFecha_tipo3() {
        int tipo = 3;
        Fecha instance = new Fecha();
        String expResult = "02/24";
        String result = instance.devuelveFecha(tipo);
        assertEquals(expResult, result);
    }
    
}
