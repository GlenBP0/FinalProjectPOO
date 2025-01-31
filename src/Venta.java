/**
 * Clase que representa una venta, incluyendo el ID de la venta, la fecha, el ID del cliente, el ID del producto, la cantidad vendida,
 * el precio unitario y la región en la que se realiza la venta.
 *
 * @author Elvis Marcillo
 * @version POO - 2024-2025 C2
 * @since Desde 29-ene-2025, 19:00 horas
 */
public class Venta {

    //atributos
    private String idVenta;
    private String fecha;
    private String idCliente;
    private String idProducto;
    private int cantidad;
    private double precioUnitario;
    private String region;

    //constructors

    /**
     * Constructor vacío de la clase Venta.
     *
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public Venta() {
    }

    /**
     * Constructor de la clase Venta que inicializa todos los atributos de la venta.
     *
     * @param idVenta El identificador único de la venta.
     * @param fecha La fecha en la que se realizó la venta.
     * @param idCliente El identificador del cliente que realizó la compra.
     * @param idProducto El identificador del producto que fue vendido.
     * @param cantidad La cantidad del producto vendido.
     * @param precioUnitario El precio por unidad del producto.
     * @param region La región en la que se realizó la venta.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public Venta(String idVenta, String fecha, String idCliente, String idProducto, int cantidad, double precioUnitario, String region) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.region = region;
    }

    //accesores

    /**
     * Obtiene el ID de la venta.
     *
     * @return El ID de la venta.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public String getIdVenta() {
        return idVenta;
    }

    /**
     * Obtiene la fecha de la venta.
     *
     * @return La fecha de la venta.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene el ID del cliente.
     *
     * @return El ID del cliente.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Obtiene la cantidad de productos vendidos.
     *
     * @return La cantidad de productos vendidos.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el precio unitario del producto vendido.
     *
     * @return El precio unitario del producto.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Obtiene la región de la venta.
     *
     * @return La región de la venta.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public String getRegion() {
        return region;
    }

    /**
     * Establece el ID de la venta.
     *
     * @param idVenta El nuevo ID de la venta.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Establece la fecha de la venta.
     *
     * @param fecha La nueva fecha de la venta.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el ID del cliente.
     *
     * @param idCliente El nuevo ID del cliente.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Establece el ID del producto.
     *
     * @param idProducto El nuevo ID del producto.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Establece la cantidad de productos vendidos.
     *
     * @param cantidad La nueva cantidad de productos vendidos.
     * @since Desde 01-ene-2025, 19:00 horas
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Establece el precio unitario del producto.
     *
     * @param precioUnitario El nuevo precio unitario del producto.
     * @since Desde 01-ene-2025, 19:00 horas
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Establece la región de la venta.
     *
     * @param region La nueva región de la venta.
     * @since Desde 01-ene-2025, 19:00 horas
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Representa la clase Venta como una cadena de texto.
     *
     * @return Una representación en formato String de la venta.
     * @since Desde 29-ene-2025, 19:00 horas
     */
    @Override
    public String toString() {
        return "Venta{" +
                "idVenta='" + idVenta + '\'' +
                ", fecha='" + fecha + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", idProducto='" + idProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", region='" + region + '\'' +
                '}';
    }
}
