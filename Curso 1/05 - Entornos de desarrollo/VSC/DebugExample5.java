public class DebugExample5 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 1; i < 10; i++) {
            numbers[i] = i; // Aquí hay un error, índice fuera de rango
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("La suma de los números es: " + sum);
    }
}