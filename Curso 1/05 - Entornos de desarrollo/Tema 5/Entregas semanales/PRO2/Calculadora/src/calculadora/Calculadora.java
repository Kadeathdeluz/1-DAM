package calculadora;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Calculadora {

    private int num1, num2;

    public Calculadora(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int suma() {
        int result = num1 + num2;
        return result;
    }

    public int resta() {
        int result;

        if (resta2()) {
            result = num1 - num2;
        } else {
            result = num2 - num1;
        }

        return result;
    }

    public boolean resta2() {
        if (num1 > num2) {
            return true;
        } else {
            return false;
        }
    }

    public String divide2() {
        if (num2 == 0) {
            return null;
        }
        
        int result = num1 / num2;
        
        return String.valueOf(result);
    }
    
    public int multiplica() {
        int result = num1 * num2;
        return result;
    }

    public int divide() {
        int result = num1 / num2;
        return result;
    }


}
