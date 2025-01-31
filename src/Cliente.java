/**
 * Representa un cliente con su información básica, incluyendo identificación,
 * nombre, correo electrónico, segmento de mercado y fecha de registro.
 *
 * @author Elvis Marcillo
 * @version POO - 2024-2025 C2
 * @since Desde 29-ene-2025, 14:00 horas
 */
public class Cliente {

    // atributos
    private String idCliente;
    private String nombre;
    private String email;
    private String segmento;
    private String fechaRegistro;

    /**
     * Constructor por defecto de la clase Cliente.
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa un objeto Cliente con valores específicos.
     *
     * @param idCliente Identificación única del cliente
     * @param nombre Nombre del cliente
     * @param email Correo electrónico del cliente
     * @param segmento Segmento de mercado al que pertenece el cliente
     * @param fechaRegistro Fecha en la que el cliente se registró
     */
    public Cliente(String idCliente, String nombre, String email, String segmento, String fechaRegistro) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.segmento = segmento;
        this.fechaRegistro = fechaRegistro;
    }

    // accesores

    /**
     * Obtiene la identificación del cliente.
     *
     * @return Identificación del cliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return Correo electrónico del cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene el segmento de mercado del cliente.
     *
     * @return Segmento de mercado del cliente
     */
    public String getSegmento() {
        return segmento;
    }

    /**
     * Obtiene la fecha de registro del cliente.
     *
     * @return Fecha de registro del cliente
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la identificación del cliente.
     *
     * @param idCliente Nueva identificación del cliente
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param email Nuevo correo electrónico del cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece el segmento de mercado del cliente.
     *
     * @param segmento Nuevo segmento de mercado del cliente
     */
    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    /**
     * Establece la fecha de registro del cliente.
     *
     * @param fechaRegistro Nueva fecha de registro del cliente
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Devuelve una representación en cadena del objeto Cliente.
     *
     * @return Representación en cadena del Cliente
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", segmento='" + segmento + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                '}';
    }
}
