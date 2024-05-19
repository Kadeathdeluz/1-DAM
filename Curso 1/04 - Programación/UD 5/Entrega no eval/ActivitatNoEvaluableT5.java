package exercicist5.prg;

import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ActivitatNoEvaluableT5 {
    
    public static void main(String[] args) {
        int testNum = askForAndGetNumber();
        collatz(testNum);
        
    }
    
    private static void collatz(int num) {
        System.out.println("La conjectura de Collatz de " + num + " es: ");
        System.out.print("" + num);
        
        while(num > 1) {
            System.out.print(", ");
            if(num % 2 == 0) {
                num /= 2;
            }
            else {
                num *= 3;
                num += 1;
            }
            System.out.print("" + num);
        }
        System.out.println(".");
        
    }

    private static int askForAndGetNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe un número para la prueba");
        
        int num = input.nextInt();
        return num;
    }

}
