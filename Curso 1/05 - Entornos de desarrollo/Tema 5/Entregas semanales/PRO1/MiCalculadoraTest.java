package calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class MiCalculadoraTest {
    
    public MiCalculadoraTest() {
    }

    @Test
    public void testSumaTriple() {
        MiCalculadora calculadora = new MiCalculadora(3,2, 1);
        int result = calculadora.sumaTriple();
        assertEquals(6, result);
    }
    
    @Test
    public void testCartesiano() {
        MiCalculadora calculadora = new MiCalculadora(3,2, 10);
        int result = calculadora.cartesiano();
        assertEquals(60, result);
    }
    
    @Test
    public void testMedia() {
        MiCalculadora calculadora = new MiCalculadora(3,2, 1);
        float result = calculadora.media();
        assertEquals(2.0f, result, 0.01);
    }

    @Test
    public void testMayorDeLosTres() {
        MiCalculadora calculadora = new MiCalculadora(3,2, 1);
        int result = calculadora.mayorDeLosTres();
        assertEquals(3, result);
    }
    
    
}
