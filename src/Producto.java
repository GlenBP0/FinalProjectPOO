/**
 * Representa un producto con atributos como identificador, nombre, categoría, precio base, stock inicial y licencia.
 *
 * @author Elvis Marcillo
 * @version (POO - 2024-2025 C2)
 * @since Desde 29-ene-2025, 19:00 horas
 */
public class Producto {

    // atributos
    private String idProducto;
    private String nombre;
    private String categoria;
    private double precioBase;
    private Integer stockInicial;
    private String licencia;

    //constructores

    /**
     * Constructor por defecto.
     */
    public Producto() {}

    /**
     * Constructor con parámetros para inicializar un producto.
     *
     * @param idProducto Identificador del producto
     * @param nombre Nombre del producto
     * @param categoria Categoría del producto
     * @param precioBase Precio base del producto
     * @param stockInicial Stock inicial disponible del producto
     * @param licencia Tipo de licencia del producto
     */
    public Producto(String idProducto, String nombre, String categoria, double precioBase, Integer stockInicial, String licencia) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.stockInicial = stockInicial;
        this.licencia = licencia;
    }

    // accesores

    /**
     * Obtiene el identificador del producto.
     *
     * @return Identificador del producto
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return Categoría del producto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Obtiene el precio base del producto.
     *
     * @return Precio base del producto
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Obtiene el stock inicial del producto.
     *
     * @return Stock inicial del producto
     */
    public int getStockInicial() {
        return stockInicial;
    }

    /**
     * Obtiene la licencia del producto.
     *
     * @return Licencia del producto
     */
    public String getLicencia() {
        return licencia;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param idProducto Nuevo identificador del producto
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param categoria Nueva categoría del producto
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Establece el precio base del producto.
     *
     * @param precioBase Nuevo precio base del producto
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Establece el stock inicial del producto.
     *
     * @param stockInicial Nuevo stock inicial del producto
     */
    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    /**
     * Establece la licencia del producto.
     *
     * @param licencia Nueva licencia del producto
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * Devuelve una representación en cadena del objeto Producto.
     *
     * @return Cadena con la información del producto
     */
    @Override
    public String toString() {
        return "\nProducto{" +
                "\nidProducto='" + idProducto + '\'' +
                ",\n nombre='" + nombre + '\'' +
                ",\n categoria='" + categoria + '\'' +
                ",\n precioBase=" + precioBase +
                ",\n stockInicial=" + stockInicial +
                ",\n licencia='" + licencia + '\'' +
                "\n}";
    }
}
