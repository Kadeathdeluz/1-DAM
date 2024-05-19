package calculadora;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Factorial {
    
    int num;
    
    public Factorial(int num) {
        this.num = num;
    }
    
    public long calculo() {
        if(num < 0) {
            throw new IllegalArgumentException("Número " + num + " no puede ser menor que 0.");
        }
        long fact = 1;
        
        for(int i = 2; i <= num; i++) {
            fact *= i;
        }
        
        return fact;
    }

}
