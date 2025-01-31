
import java.util.List;

/**
 * Clase principal que ejecuta la carga de datos y la generación de reportes.
 *
 * @author Glenda Bermudez y Elvis Marcillo
 * @version POO - 2024-2025 C2
 * @since Desde 29-ene-2025, 14:00 horas
 */
public class Main {

    /**
     * Método principal que carga los datos y genera los reportes.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main (String[]args){
        String rutaJson= "./src/productos.json";
        String rutaVentasCsv= "./src/ventas.csv";
        String rutaClientesCsv="./src/clientes.csv";

        // Carga de productos, ventas y clientes
        List<Producto>productos= LeerArchivo.cargarProductos(rutaJson);
        List<Venta>ventas=LeerArchivo.cargarVentas(rutaVentasCsv);
        List<Cliente>clientes= LeerArchivo.cargarClientes(rutaClientesCsv);

        // Analisis de datos
        AnalizarData.generarReporteTop5Productos(productos,ventas);

        // Reporte 1: Productos más vendidos
        AnalizarData.generarReporteProductosMasVendidos(ventas, productos);

        // Reporte 2: Top 5 clientes que más compran
        AnalizarData.generarReporteTopClientes(ventas, clientes);

        // Reporte 3: Estadísticas de ventas
        AnalizarData.generarEstadisticasVentas(ventas);

        // Reporte 4: CSV extendido
        AnalizarData.generarCSVExtendido(ventas, clientes, "ReporteExtendido.csv");


    }
}
