
/**
 * Clase EmpleadoFinalSolución

 Contiene informacion de cada empleado
 *
 * @author Cristina
 * @version 1.0
 */
public class EmpleadoFinalSolución {
 
    //Atributos
 
    /**
     * Nombre del empleado
     */
    private String nombre;
    /**
     * Apellido del empleado
     */
    private String apellido;
    /**
     * Edad del empleado
     */
    private int edad;
    /**
     * Salario del empleado
     */
    private double salario;
 
    //M�todos publicos
 
    /**
     * Suma un plus al salario del empleado si el empleado tiene mas de 40 a�os
     * @param sueldoPlus
     * @return <ul>
     *          <li>true: se suma el plus al sueldo</li>
     *          <li>false: no se suma el plus al sueldo</li>
     *          </ul>
     */
    public boolean plus (double sueldoPlus){
        boolean aumento=false;
        if (edad>40 && compruebaNombre()){
            salario+=sueldoPlus;
            aumento=true;
        }
        return aumento;
    }
 
    //M�todos privados
    /**
     * Comprueba que el nombre no est� vac�o
     * @return <ul>
     *  <li>true: el nombre es una cadena vac�a</li>
     *  <li>false: el nombre no es una cadena vac�a</li>
     *  </ul>
     */
    private boolean compruebaNombre(){
        if(nombre.equals("")){
            return false;
        }
        return true;
    }
 
    //Constructores
    /**
     * Constructor por defecto
     */
    public EmpleadoFinalSolución(){
        this ("", "", 0, 0);
    }
 
    /**
     * Constructor con 4 parametros
     * @param nombre nombre del empleado
     * @param apellido nombre del empleado
     * @param edad edad del empleado
     * @param salario salario del empleado
     */
    public EmpleadoFinalSolución(String nombre, String apellido, int edad, double salario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.salario=salario;
    }
}