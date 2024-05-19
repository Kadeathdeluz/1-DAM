package ed;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class StringUtils {

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder(str).reverse();
        return reversed.toString();
    }
}
