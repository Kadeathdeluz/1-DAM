package mascletas;

import java.time.LocalTime;

/**
 * Calcula la duración de cada mascletá con calcularDuracionMascleta() y
 * almacena el total de todas ellas en duracionTotal.
 *
 * @version 2.0 - 28/04/2024
 * @author Roldán Sanchis Martínez
 */
public class MascletasCalculator {

    private int duracionTotal;

    /**
     * Calcula la duración de una mascletá dados los siguientes parámetros.
     *
     * @param horaInicio Hora de inicio de la mascletá.
     * @param horaFin Hora de fin de la mascletá.
     * @param intensidadSonido Intensidad del sonido (a tener en cuenta para
     * sumar el doble de dicha cantidad a la duración de la mascletá).
     * @param duracionFuegosArtificiales Duración de los fuegos, que se suma a
     * la duración de la mascletá.
     * @return Devuelve un número entero con la duración de la mascletá.
     */
    public int calcularDuracionMascleta(LocalTime horaInicio, LocalTime horaFin, int intensidadSonido, int duracionFuegosArtificiales) {
        // Cálculo de la duración de la mascletà en minutos 
        int duracion = 0;
        // Suponiendo que la duración es la diferencia entre la hora de inicio y la hora de fin 
        duracion = (horaFin.toSecondOfDay() - horaInicio.toSecondOfDay()) / 60;
        // Tomamos en cuenta la intensidad del sonido y la duración de los fuegos artificiales 
        duracion += intensidadSonido * 2;
        // Cada punto de intensidad suma 2 minutos 
        duracion += duracionFuegosArtificiales;
        // Duración de los fuegos artificiales en minutos 
        duracionTotal += duracion;
        return duracion;
    }

    /**
     * Devuelve la duración total de todas las maslcetás calculadas.
     *
     * @return Devuelve un entero que representa la duración total.
     */
    public int getDuracionTotal() {
        return this.duracionTotal;
    }
}
