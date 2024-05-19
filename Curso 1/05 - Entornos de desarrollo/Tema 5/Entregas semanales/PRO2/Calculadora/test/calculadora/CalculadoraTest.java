package calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class CalculadoraTest {

    public CalculadoraTest() {
    }

    @Test
    public void testResta() {
        Calculadora calculadoraTest = new Calculadora(10, 2);
        int expectedResult = 8;
        int result = calculadoraTest.resta();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testResta2() {
        Calculadora calculadoraTest = new Calculadora(10, 2);
        boolean result = calculadoraTest.resta2();
        
        assertTrue(result);
    }
    @Test
    public void testResta2_v2() {
        Calculadora calculadoraTest = new Calculadora(2, 10);
        boolean result = calculadoraTest.resta2();
        
        assertFalse(result);
    }

    @Test
    public void testDivide2() {
        Calculadora calculadoraTest = new Calculadora(10, 1);
        String result = calculadoraTest.divide2();
        
        assertEquals(result, "10");
    }
    
    @Test
    public void testDivide2_v2() {
        Calculadora calculadoraTest = new Calculadora(10, 0);
        String result = calculadoraTest.divide2();
        
        assertNull(result);
    }

}
