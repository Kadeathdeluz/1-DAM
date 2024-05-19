package calculadora;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Fecha {

    SimpleDateFormat formato;
    Date hoy;

    public Fecha() {
        hoy = new Date();
    }
    
    public static void main(String[] args) {
        Fecha unodenero = new Fecha();
        
        System.out.println(unodenero.devuelveFecha(1));
    }
    public String devuelveFecha(int tipo) {
        String cad = "";
        switch (tipo) {
            case 1: {
                formato = new SimpleDateFormat("yyyy/MM");
                cad = formato.format(hoy);
                break;
            }
            case 2: {
                formato = new SimpleDateFormat("MM/yyyy");
                cad = formato.format(hoy);
                break;
            }
            case 3: {
                formato = new SimpleDateFormat("MM/yy");
                cad = formato.format(hoy);
                break;
            }
            default: {
                cad = "ERROR";
            }
            System.out.println(cad);
        }
        return cad;
    }
}
