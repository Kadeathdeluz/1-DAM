package calculadora;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class MiCalculadora {

    private final int numero1, numero2, numero3;

    public MiCalculadora(int num1, int num2, int num3) {
        this.numero1 = num1;
        this.numero2 = num2;
        this.numero3 = num3;
    }
    
    public int cartesiano() {
        return this.numero1 * this.numero2 * this.numero3;
    }

    public int sumaTriple() {
        return this.numero1 + this.numero2 + this.numero3;
    }

    public float media() {
        return (sumaTriple() / 3.0f);
    }

    public int mayorDeLosTres() {
        return Math.max(Math.max(numero1, numero2), numero3);
    }

}
