package calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class FactorialTest {
    
    public FactorialTest() {
    }

    @Test
    public void testCalculo() {
        Factorial instance = new Factorial(3);
        long expResult = 6;
        long result = instance.calculo();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalculo_error() {
        Factorial instance = new Factorial(-2);
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            instance.calculo();
        });
        String expectedMessage = "Número -2 no puede ser menor que 0.";
        String resultMessage = exception.getMessage();
        
        assertTrue(resultMessage.contains(expectedMessage));
    }
    
}
