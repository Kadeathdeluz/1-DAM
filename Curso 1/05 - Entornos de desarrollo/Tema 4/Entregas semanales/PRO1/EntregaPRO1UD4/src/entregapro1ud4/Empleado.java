package entregapro1ud4;

/**
 * <h2>Clase Empleado</h2>
 * Contiene información de cada empleado.
 *
 * @version 03.08
 * @author Roldán Sanchis Martínez,
 * <a href="mailto:rolsanmar@alu.edu.gva.es">rolsanmar@alu.edu.gva.es</a>
 */
public class Empleado {

    private String nombre;
    private String apellido;
    private int edad;
    private double salario;
//Metodos publicos

    /**
     * Suma un plus de 93 euros al salario del empleado si el empleado tiene más
     * de 30 años.
     *
     * @param sueldoPlus Cantidad en euros que se suma al salario.
     * @return <ul> 
     * <li>true: se suma el plus al sueldo.</li>
     * <li>false: no se suma el plus al sueldo.</li>
     * </ul>
     */
    public boolean plus(double sueldoPlus) {
        boolean aumento = false;
        if (edad > 30 && compruebaNombre()) {
            salario += sueldoPlus;
            aumento = true;
        }
        return aumento;
    }
//Metodos privados

    private boolean compruebaNombre() {
        if (nombre.equals("")) {
            return false;
        }
        return true;
    }
//Constructores

    /**
     * Constructor por defecto.
     */
    public Empleado() {
        this("", "", 0, 0);
    }

    /**
     * Constructor con 4 parámetros.
     *
     * @param nombre Nombre del empleado.
     * @param apellido Apellido del empleado.
     * @param edad Edad del empleado.
     * @param salario Salario del empleado.
     */
    public Empleado(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }
}
