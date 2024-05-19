package pro3_ud5_ed;

/**
 *
 * @author Roldán Sanchis Martínez
 */
/*El salario base será 1000 euros si el empleado es de tipo TipoEmpleado.VENDEDOR, 
y de 1500 euros si es de tipo TipoVendedor.ENCARGADO. 
A esta cantidad se le sumará una prima de 100 euros si ventasMes es mayor o igual que 1000 euros,
y de 200 euros si fuese al menos de 1500 euros. Por último, cada hora extra se pagará a 20 euros. 
Si tipo es null, o ventasMes o horasExtra toman valores negativos el método lanzará una excepción
de tipo BRException.
 */
 /*Si el salario bruto es menor de 1000 euros, no se aplicará ninguna retención. 
Para salarios a partir de 1000 euros, y menores de 1500 euros se les aplicará un 16%, 
y a los salarios a partir de 1500 euros se les aplicará un 18%. 
El método nos devolverá salarioBruto * (1-retencion), o BRExcepcion si el salario es menor que cero.
 */

enum TipoEmpleado {
    VENDEDOR, ENCARGADO
};

class BRException extends Exception {
    
    public BRException(String msj) {
        super(msj);
    }
    
}

public class EmpleadoBR {
   //private String nombre;
   //otros atributos
    float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes, float horasExtra) 
            throws BRException {
        int salarioBase;
        if ((tipo == null || ventasMes < 0) || horasExtra < 0) {
            throw new BRException("Datos de nómina erróneos");
        }
        if (tipo == TipoEmpleado.VENDEDOR) {
            salarioBase = 1000;
        } else {
            salarioBase = 1500;
        }
        if (ventasMes >= 1000 && ventasMes < 1500) {
            salarioBase += 100;
        }
        if (ventasMes >= 1500) {
            salarioBase += 200;
        }
        salarioBase += horasExtra * 20;
        return salarioBase;
    }

    public float calculaSalarioNeto(float salarioBruto) throws BRException 
    {
        float retencion = 0.0f;

        if (salarioBruto < 0) {
            throw new BRException("El salario bruto debe ser positivo");
        }
        if (salarioBruto >= 1000 && salarioBruto < 1500) {
            retencion = 0.16f;
        }
        if (salarioBruto >=1500) {
            retencion = 0.18f;
        }

        return salarioBruto * (1 - retencion);
    }

}

