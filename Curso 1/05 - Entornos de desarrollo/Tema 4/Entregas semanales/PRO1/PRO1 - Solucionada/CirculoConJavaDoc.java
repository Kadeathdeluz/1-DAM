/**
 *
 * Ejemplo simple de comentarios en JavaDoc
 *
 * @author Sergio Badal
 * @author <a href="mailto:sergio.badal@ceedcv.com">sergio.badal@ceedcv.com</a>
 * @version 1.1
 */
public class Circulo {

    private double centroX;
    private double centroY;
    private double radio;

    /**
     * Constructor con tres parámetros
     *
     * @param cx centro coordenada x
     * @param cy centro coordenada y
     * @param r radio del círculo
     */
    public Circulo(double cx, double cy, double r) {
        centroX = cx;
        centroY = cy;
        radio = r;
    }

    /**
     * Método getter
     *
     * @return centro coordenada x
     */
    public double getCentroX() {
        return centroX;
    }

    /**
     * Calcula la longitud de la circunferencia (perímetro del círculo)
     *
     * @return circunferencia
     */
    public double getCircunferencia() {
        return 2 * Math.PI * radio;
    }

    /**
     * Desplaza el círculo a otro lugar
     *
     * @param deltaX movimiento en el eje x
     * @param deltaY movimiento en el eje y
     */
    public void mueve(double deltaX, double deltaY) {
        centroX = centroX + deltaX;
        centroY = centroY + deltaY;
    }

    /**
     * Escala del círculo (cambia su radio)
     *
     * @param s factor de escala
     */
    public void escala(double s) {
        radio = radio * s;
    }
}
