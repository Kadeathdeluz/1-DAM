/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ed;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Roldán Sanchis Martínez
 */
@RunWith(Parameterized.class)
public class StringUtilsNotNullTest {

    private String in;
    private String out;

    public StringUtilsNotNullTest(String in, String out) {
        this.in = in;
        this.out = out;

    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> entradas() {
        return Arrays.asList(new Object[][]{
            {"asd "," dsa"},
            {"Mayus", "suyaM"},
            {"caña","añac"},
            {"calçot","toçlac"},
            {"Roldán", "nádloR"}
        });
    }

    @Test
    public void testNotNullReverse() {
        System.out.println("reverse");
        String str = this.in;
        String expResult = this.out;
        String result = StringUtils.reverse(str);
        assertEquals(expResult, result);
    }

}
