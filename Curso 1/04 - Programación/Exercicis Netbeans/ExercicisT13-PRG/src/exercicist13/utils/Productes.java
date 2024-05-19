package exercicist13.utils;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class Productes {

    private String codigo;
    private String seccion;
    private String nombre;
    private double precio;
    private String pais;
    private java.sql.Date fecha;

    /**
     * Constructor de productes
     *
     * @param cod
     * @param sec
     * @param nom
     * @param pre
     * @param pais
     * @param fecha
     */
    public Productes(String cod, String sec, String nom, Double pre, String pais, java.sql.Date fecha) {
        this.codigo = cod;
        this.seccion = sec;
        this.nombre = nom;
        this.precio = pre;
        this.pais = pais;
        this.fecha = fecha;
    }

    /* Getters y Setters */
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the fecha
     */
    public java.sql.Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "-------PRODUCTE-------"
                + "\nCódigo: " + this.codigo
                + "\nSección: " + this.seccion
                + "\nNombre: " + this.nombre
                + "\nPrecio: " + this.precio
                + "\nPaís: " + this.pais
                + "\nFecha: " + this.fecha
                + "\n----------------------";
    }

}
