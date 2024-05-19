public class Main {
    public static void main(String[] args) {
        int numero = obtenerNumero();
        int resultado = dividir(10, numero);
        System.out.println("El resultado de la división es: " + resultado);
    }

    public static int obtenerNumero() {
        int num = 0;
        for (int i = 0; i <= 1; i++) {
            num += i;
        }
        return num;
    }

    public static int dividir(int a, int b) {
        int result = a / b; // Aquí hay un error, división por cero
        return result;
    }
}
