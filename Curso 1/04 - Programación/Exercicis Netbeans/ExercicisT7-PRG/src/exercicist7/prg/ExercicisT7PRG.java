package exercicist7.prg;

import java.util.Scanner;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class ExercicisT7PRG {

    public static void main(String[] args) {
        System.out.println("Quin exercici vols fer? (1-21)");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        printAux(num);
        chooseExercici(num);

        input.close();
    }

    private static void exercici1() {
        Scanner input = new Scanner(System.in);

        System.out.println("Escriu un nombre(A): ");
        double a = input.nextDouble();
        System.out.println("Escriu un nombre(B): ");
        double b = input.nextDouble();

        System.out.println("Resultat de A(" + a + ") * B(" + b + ") = " + multiplica(a, b));
        input.close();
    }

    private static double multiplica(double a, double b) {
        return a * b;
    }

    private static void exercici2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escriu l'edat: ");
        int edat = input.nextInt();

        if (esMajorEdat(edat)) {
            System.out.println("Eres major d'edat.");
        } else {
            System.out.println("No eres major d'edat.");
        }
        input.close();
    }

    private static boolean esMajorEdat(int a) {
        return (a >= 18);
    }

    private static void exercici3() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escriu un nombre (A): ");
        int a = input.nextInt();

        System.out.println("Escriu un nombre (B): ");
        int b = input.nextInt();

        System.out.println("El mínim és: " + minim(a, b));

        input.close();
    }

    private static int minim(int a, int b) {
        return a > b ? b : a;
    }

    private static void exercici4() {
        Scanner input = new Scanner(System.in);

        System.out.println("Escriu un nombre enter (positu o negatiu): ");
        int a = input.nextInt();

        switch (dimeSigne(a)) {
            case 0 -> {
                System.out.println("Es cero.");
            }
            case 1 -> {
                System.out.println("És positiu.");
            }
            case -1 -> {
                System.out.println("És negatiu.");
            }
        }
        input.close();
    }

    private static int dimeSigne(int a) {
        return (a == 0) ? 0 : (a > 0) ? 1 : -1;
    }

    private static void exercici5() {
        int miles;
        double km;
        Scanner input = new Scanner(System.in);

        System.out.println("Escriu les milles: ");
        miles = input.nextInt();

        km = millesAQuilometres(miles);
        System.out.println(miles + " milles són " + String.format("%.2f", km) + " quilómetres.");
        input.close();
    }

    private static double millesAQuilometres(int miles) {
        final double MILES_TO_KM = 1.60934;
        return miles * MILES_TO_KM;
    }

    private static void exercici6() {
        Scanner input = new Scanner(System.in);
        double currentPrice;

        for (int i = 0; i < 5; i++) {
            System.out.println("Introdueix un preu sense IVA: ");
            currentPrice = input.nextDouble();
            System.out.println("Preu: " + currentPrice
                    + "?, preu amb IVA(21%): " + String.format("%.2f", preuAmbIVA(currentPrice)) + "?");
        }

        input.close();
    }

    private static double preuAmbIVA(double price) {
        final double IVA = 0.21;
        return price + (price * IVA);
    }

    private static void exercici7() {
        Scanner input = new Scanner(System.in);
        double height, width;

        System.out.println("Introdueix l'altura del rectangle: ");
        height = input.nextDouble();

        System.out.println("Introdueix l'altura del rectangle: ");
        width = input.nextDouble();

        System.out.println("Àrea: " + areaRectangul(height, width));
        System.out.println("Perímetre: " + perimetreRectangul(height, width));

        input.close();
    }

    private static double perimetreRectangul(double height, double width) {
        return height * 2 + width * 2;
    }

    private static double areaRectangul(double height, double width) {
        return height * width;
    }

    private static void exercici8() {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("Introdueix un valor sencer: ");
        n = input.nextInt();
        
        System.out.println("Nombre(N): " + n +
                "\nSuma: "+ suma1aN(n) +
                "\nProducte: " + producte1aN(n) +
                "\nIntermedi: " + intermedi1aN(n) );

        input.close();
    }

    private static int suma1aN(int n) {
        int addition = 0;
        for(int i = 1; i <= n; i ++) {
            addition += i;
        }     
        return addition;
    }
    private static int producte1aN(int n) {
        int product = 1;
        for(int i = 2; i <= n; i ++) {
            product *= i;
        }     
        return product;
    }
    private static double intermedi1aN(int n) {         
        return (double)(n+1)/2;
    }

    private static void exercici9() {
        Scanner input = new Scanner(System.in);
        int [] nums = new int [3];
        
        for(int i = 0; i < nums.length; i++) {
            System.out.println("Introdueix un nombre: ");
            nums[i] = input.nextInt();
        }
        System.out.println("El màxim és: " + max(nums[0],max(nums[1],nums[2])));
        
        
        input.close();
    }
    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static void exercici10() {
        Scanner input = new Scanner(System.in);
        int [] date = new int [3];
        
        System.out.println("Introdueix una data (DD/MM/AAAA): ");
        for(int i = 0; i < date.length; i++) {
            date[i] = input.nextInt();
        }
        System.out.println( (isCorrectDate(date) ? "Data correcta." : "No és una data correcta") );
        
        
        input.close();
        
    }
    private static boolean isCorrectDate(int [] date){
        int day = date[0], month = date[1], year = date[2];
        
        return day > 0 && day <= 30 ? month > 0 && month <= 12 ? year > 0 : false : false;
    }

    private static void exercici11() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Introdueix un nombre sencer: ");
        int n = input.nextInt();
        showMultiplyTable(n);
        
        input.close();
    }
    private static void showMultiplyTable(int n) {
        for(int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    private static void exercici12() {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Introdueix els quilómetres: ");
        float kms = input.nextFloat();
        
        System.out.println(kms + " Kms són " + String.format("%.2f", kmsToMiles(kms)) + " milles.");
        input.close();
    }
    private static float kmsToMiles(float kms) {
        final float MILES = 0.621371f;
        return kms * MILES;
    }

    private static void exercici13() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Introdueix un preu sense descompte: ");
        float initialPrice = input.nextFloat();
        
        System.out.println("Introdueix un preu amb descompte: ");
        float finalPrice = input.nextFloat();
        
        calculateDiscount(initialPrice, finalPrice);
        System.out.println("Descompte: " + String.format("%.2f", (calculateDiscount(initialPrice, finalPrice)*100)) + "%");
        input.close();
    }
    private static float calculateDiscount(float start, float end) {
        return (start-end)/start;
    }

    private static void exercici14() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Escriu un caracter: ");
        
        input.close();
    }

    private static void exercici15() {
    }

    private static void exercici16() {
    }

    private static void exercici17() {
    }

    private static void exercici18() {
    }

    private static void exercici19() {
    }

    private static void exercici20() {
    }

    private static void exercici21() {
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
            case 9 ->
                exercici9();
            case 10 ->
                exercici10();
            case 11 ->
                exercici11();
            case 12 ->
                exercici12();
            case 13 ->
                exercici13();
            case 14 ->
                exercici14();
            case 15 ->
                exercici15();
            case 16 ->
                exercici16();
            case 17 ->
                exercici17();
            case 18 ->
                exercici18();
            case 19 ->
                exercici19();
            case 20 ->
                exercici20();
            case 21 ->
                exercici21();

            default ->
                System.out.println("Exercici fora de rang!");
        }
    }

}
