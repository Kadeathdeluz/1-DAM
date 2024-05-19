package exercicist10.prg;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ExercicisT10PRG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-8)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();
    }

    private static void exercici1() throws InputMismatchException {
        int a;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número entero: ");
        try {
            a = input.nextInt();
            System.out.println("Valor introducido: " + a);
        } catch (InputMismatchException ime) {
            System.out.println("Valor incorrecto.");
        }

    }

    private static void exercici2() {
        int a, b;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Introduce un número entero: ");
            a = input.nextInt();

            System.out.println("Introduce otro número entero: ");
            b = input.nextInt();

            System.out.println("Resultado: " + (a / b));

        } catch (InputMismatchException ime) {
            System.err.println("Error: Valor incorrecto.");
        } catch (ArithmeticException ae) {
            System.err.println("Error: División entre 0.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void exercici3() {
        Scanner input = new Scanner(System.in);
        double[] vector = new double[5];
        double nextNum;
        int i = 0;
        boolean correcte;

        //Per a cada posició del vector
        while (i < vector.length) {
            correcte = false;
            System.out.println("Introduce un número para la posición [" + i + "]: ");
            //Mentres l'entrada no siga correcta, continua demanant número
            while (!correcte) {
                try {
                    nextNum = input.nextDouble();
                    vector[i] = nextNum;

                    correcte = true;

                } catch (InputMismatchException ime) {
                    correcte = false;

                    System.err.println("Error: Introduce un valor correcto para [" + i + "].");
                    input.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            //Incrementem l'index només si s'ha pogut introduïr el número
            i++;
        }
        System.out.println("Vector: {");
        for (double elem : vector) {
            System.out.println("Element: " + elem);
        }
        System.out.println("}");

    }

    private static void exercici4() {
        int n = (int) (Math.random() * 100 + 1); //Grandaria aleatoria (1-100)
        System.out.println("Tamany: " + n);
        int[] vector = new int[n]; //Array de tamany aleatori
        int posicio; //Posició seleccionada per l'usuari
        boolean eixir = false, //Condició d'eixida
                correcte; //Condició per a seguir demenant index o no
        Scanner input = new Scanner(System.in);

        //Emplenem l'array
        for (int i = 0; i < vector.length; i++) {
            //Genera un número entre 1 i 10 i el fica a la posició i de l'array
            vector[i] = (int) (Math.random() * 10 + 1);
        }

        do {
            System.out.println("Selecciona una posició del vector: ");
            correcte = false;
            while (!correcte) {
                try {
                    posicio = input.nextInt();

                    if (posicio < 0) {
                        eixir = true;
                    } else {
                        int valor = vector[posicio];
                        System.out.println("Posició [" + posicio + "] conté: " + valor);
                    }

                    //Només serà correcte quan arribe al final sense excepcions
                    correcte = true;
                } catch (InputMismatchException ime) {
                    System.err.println("Error: Introdueïx un número enter.");
                    input.nextLine();

                } catch (ArrayIndexOutOfBoundsException aiobe) {
                    System.err.println("Error: Array de tamany " + n + ", selecciona un index correcte.");
                    input.nextLine();
                }
            }
        } while (!eixir);

    }

    /**
     * Farà de main per a l'exercici 5
     */
    private static void exercici5() {
        try {
            //Positius
            System.out.println("Funciona: ");
            imprimeixPositiu(1);
            
            System.out.println("Funciona: ");
            imprimeixPositiu(0);
            
            System.out.println("Donarà expeció: ");
            imprimeixPositiu(-1);
            
            //Negatius
            System.out.println("Funciona: ");
            imprimeixNegatiu(-1);
            
            System.out.println("Donarà expeció: ");
            imprimeixNegatiu(0);
            
            System.out.println("Donarà expeció: ");
            imprimeixNegatiu(1);

        } catch (InputMismatchException ime){
            //Només per a entrades per teclat
            System.err.println("Escriu un valor correcte.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Métode auxiliar de l'exercici 5
     */
    private static void imprimeixPositiu(int p) throws Exception {
        if (p < 0) {
            throw new Exception("P ha de ser positiu.");
        } else {
            System.out.println("P: " + p);
        }
    }

    /**
     * Métode auxiliar de l'exercici 5
     */
    private static void imprimeixNegatiu(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("N ha de ser negatiu.");
        } else {
            System.out.println("N: " + n);
        }

    }

    private static void exercici6() {

    }

    private static void exercici7() {

    }

    private static void exercici8() {

    }

    private static void printAux(int i) {
        System.out.println("Exercici " + i + ": ");
    }

    private static void chooseExercici(int num) {
        switch (num) {
            case 1 ->
                exercici1();
            case 2 ->
                exercici2();
            case 3 ->
                exercici3();
            case 4 ->
                exercici4();
            case 5 ->
                exercici5();
            case 6 ->
                exercici6();
            case 7 ->
                exercici7();
            case 8 ->
                exercici8();

            default ->
                System.out.println("Exercici fora de rang!");
        }
    }

}
