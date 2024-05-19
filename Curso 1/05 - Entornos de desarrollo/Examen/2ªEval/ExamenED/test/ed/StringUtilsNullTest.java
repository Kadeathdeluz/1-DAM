package ed;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class StringUtilsNullTest {

    @Test
    public void testNullReverse() {
        System.out.println("reverse");
        String str = null;
        String expResult = null;
        String result = StringUtils.reverse(str);
        assertEquals(expResult, result);
    }
}
