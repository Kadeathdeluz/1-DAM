package pro3_ud5_ed;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Roldán Sanchis Martínez
 */
@RunWith(Parameterized.class)
public class EmpleadoBRNetoTest {
    private float salarioBruto;
    private float netoEsperado;
    
    @Parameters
    public static Collection<Object[]> parametrosNeto() {
        return Arrays.asList(new Object[][]{
            {2000, 1640}, {1500, 1230}, {1499.99f, 1259.9916f}, {1250, 1050}, 
            {1000, 840}, {999.99f, 999.99f}, {500, 500},{0, 0}
        });
    }
    public EmpleadoBRNetoTest(float salarioBruto, float netoEsperado) {
        this.salarioBruto = salarioBruto;
        this.netoEsperado = netoEsperado;
    }
    
    @Test
    public void testCalculaSalarioNeto() throws Exception {

        EmpleadoBR instance = new EmpleadoBR();
        float expResult = this.netoEsperado;
        float result = instance.calculaSalarioNeto(salarioBruto);
        
        assertEquals(expResult, result, 0.001f);
    }
    
}

