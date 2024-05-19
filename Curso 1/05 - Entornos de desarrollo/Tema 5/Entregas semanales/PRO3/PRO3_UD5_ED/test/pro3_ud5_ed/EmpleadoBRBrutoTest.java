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
public class EmpleadoBRBrutoTest {

    private TipoEmpleado tipo;
    private float ventasMes;
    private float horasExtra;
    private Object resultadoEsperado; //Es de tipo Object porque puede ser un float o una Exception

    public EmpleadoBRBrutoTest(TipoEmpleado tipo, float ventasMes, float horasExtra, Object resultadoEsperado) {
        this.tipo = tipo;
        this.ventasMes = ventasMes;
        this.horasExtra = horasExtra;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters
    public static Collection<Object[]> parametrosBruto() {
        return Arrays.asList(new Object[][]{
            {TipoEmpleado.VENDEDOR, 2000, 8, 1360}, {TipoEmpleado.VENDEDOR, 1500, 3, 1260}, {TipoEmpleado.VENDEDOR, 1499.99f, 0, 1100},
            {TipoEmpleado.ENCARGADO, 1250, 8, 1760}, {TipoEmpleado.ENCARGADO, 1000, 0, 1600}, {TipoEmpleado.ENCARGADO, 999.99f, 3, 1560}, {TipoEmpleado.ENCARGADO, 500, 0, 1500}, {TipoEmpleado.ENCARGADO, 0, 8, 1660},
            {null, 1500, 8, BRException.class}
        });
    }

    @Test
    public void testCalculaSalarioBruto() throws Exception {
        EmpleadoBR instance = new EmpleadoBR();
        Object expResult = this.resultadoEsperado;

        if (expResult.equals(Float.class)) {
            float result = instance.calculaSalarioBruto(tipo, ventasMes, horasExtra);
            assertEquals((float) expResult, result, 0);
        } else {
            try {
                float result = instance.calculaSalarioBruto(tipo, ventasMes, horasExtra);
            } catch (Exception e) {
                //Comprobamos que realmente devuelve el tipo de excepción esperada
                assertEquals(expResult, e.getClass());
            }
        }

    }

}
