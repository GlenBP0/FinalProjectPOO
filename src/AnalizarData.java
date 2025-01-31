import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase encargada de analizar datos de ventas y generar reportes relevantes
 *
 * @author Glenda Bermudez y Elvis Marcillo
 * @version POO - 2024-2025 C2
 * @since 29-ene-2025, 19:00 horas
 */
public class AnalizarData {

    /**
     * Genera un reporte de los 5 productos más vendidos
     *
     * @param productos lista de productos disponibles
     * @param ventas lista de ventas registradas
     */
    public static void generarReporteTop5Productos(List<Producto> productos, List<Venta> ventas) {
        // Map para almacenar las ventas totales por producto (idProducto -> cantidadTotal, dineroTotal)
        Map<String, double[]> ventasPorProducto = new HashMap<>();

        // Calcular las ventas totales por producto
        for (Venta venta : ventas) {
            ventasPorProducto.computeIfAbsent(venta.getIdProducto(), k -> new double[2]);
            ventasPorProducto.get(venta.getIdProducto())[0] += venta.getCantidad();
            ventasPorProducto.get(venta.getIdProducto())[1] += venta.getCantidad() * venta.getPrecioUnitario();
        }

        // Ordenar los productos por cantidad total vendida de mayor a menor
        List<String> topProductos = new ArrayList<>(ventasPorProducto.keySet());
        topProductos.sort((p1, p2) -> Double.compare(ventasPorProducto.get(p2)[0], ventasPorProducto.get(p1)[0]));

        // Generar el reporte de los 5 productos más vendidos
        System.out.println("Reporte de los 5 productos más vendidos:");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-15s\n", "ID Producto", "Nombre", "Total Ventas", "Facturado");

        for (int i = 0; i < Math.min(5, topProductos.size()); i++) {
            String idProducto = topProductos.get(i);
            double[] datos = ventasPorProducto.get(idProducto);

            // Buscar el nombre del producto
            String nombre = productos.stream()
                    .filter(p -> p.getIdProducto().equals(idProducto))
                    .map(Producto::getNombre)
                    .findFirst()
                    .orElse("Desconocido");

            // Imprimir el reporte
            System.out.printf("%-15s %-20s %-15.0f $%-14.2f\n", idProducto, nombre, datos[0], datos[1]);
        }
    }

    /**
     * Genera un reporte de los productos más vendidos
     *
     * @param ventas lista de ventas registradas
     * @param productos lista de productos disponibles
     */
    // Reporte 1: Productos más vendidos
    public static void generarReporteProductosMasVendidos(List<Venta> ventas, List<Producto> productos) {
        Map<String, Integer> ventasPorProducto = new HashMap<>();
        for (Venta venta : ventas) {
            ventasPorProducto.put(venta.getIdProducto(), ventasPorProducto.getOrDefault(venta.getIdProducto(), 0) + venta.getCantidad());
        }
        // Mapa para almacenar el total de dinero generado por producto
        Map<String, Double> dineroPorProducto = new HashMap<>();
        for (Venta venta : ventas) {
            // Calcular la cantidad vendida
            ventasPorProducto.put(venta.getIdProducto(), ventasPorProducto.getOrDefault(venta.getIdProducto(), 0) + venta.getCantidad());
            // Calcular el total de dinero generado
            double totalVenta = venta.getCantidad() * venta.getPrecioUnitario();
            dineroPorProducto.put(venta.getIdProducto(), dineroPorProducto.getOrDefault(venta.getIdProducto(), 0.0) + totalVenta);
        }

        System.out.println("\nProductos más vendidos:");
        ventasPorProducto.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    String idProducto = entry.getKey();
                    int cantidad = entry.getValue();
                    double totalDinero = dineroPorProducto.getOrDefault(idProducto, 0.0);
                    String nombreProducto = productos.stream()
                            .filter(p -> p.getIdProducto().equals(idProducto))
                            .findFirst()
                            .map(p -> p.getNombre())
                            .orElse("Desconocido");
                    System.out.println(idProducto + " - " + nombreProducto + ": " + cantidad + " unidades vendidas, Total generado: $" + totalDinero);
                });
    }

    /**
     * Genera un reporte de los 5 clientes que más compran
     *
     * @param ventas lista de ventas registradas
     * @param clientes lista de clientes registrados
     */
    // Reporte 2: Top 5 clientes que más compran
    public static void generarReporteTopClientes2(List<Venta> ventas, List<Cliente> clientes) {
        Map<String, Double> comprasPorCliente = new HashMap<>();
        // Mapa para almacenar el número de compras realizadas por cliente
        Map<String, Integer> vecesComprasPorCliente = new HashMap<>();

        for (Venta venta : ventas) {
            // Calcular el total de dinero gastado por cliente
            double totalVenta = venta.getPrecioUnitario() * venta.getCantidad();
            comprasPorCliente.put(venta.getIdCliente(), comprasPorCliente.getOrDefault(venta.getIdCliente(), 0.0) + totalVenta);

            // Contar el número de compras realizadas por cliente
            vecesComprasPorCliente.put(venta.getIdCliente(), vecesComprasPorCliente.getOrDefault(venta.getIdCliente(), 0) + 1);
        }

        System.out.println("\nTop 5 clientes que más compran:");
        comprasPorCliente.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> {
                    String idCliente = entry.getKey();
                    double totalCompras = entry.getValue();
                    int vecesCompras = vecesComprasPorCliente.getOrDefault(idCliente, 0);
                    String nombreCliente = clientes.stream()
                            .filter(c -> c.getIdCliente().equals(idCliente))
                            .findFirst()
                            .map(c -> c.getNombre())
                            .orElse("Desconocido");
                    System.out.println(idCliente + " - " + nombreCliente + ": $" + totalCompras +
                            " (Compras realizadas: " + vecesCompras + " veces)");
                });
    }

    public static void generarReporteTopClientes(List<Venta> ventas, List<Cliente> clientes) {
        Map<String, Double> comprasPorCliente = new HashMap<>();
        // Mapa para almacenar el número de compras realizadas por cliente
        Map<String, Integer> vecesComprasPorCliente = new HashMap<>();

        for (Venta venta : ventas) {
            // Calcular el total de dinero gastado por cliente
            double totalVenta = venta.getPrecioUnitario() * venta.getCantidad();
            comprasPorCliente.put(venta.getIdCliente(), comprasPorCliente.getOrDefault(venta.getIdCliente(), 0.0) + totalVenta);

            // Contar el número de compras realizadas por cliente
            vecesComprasPorCliente.put(venta.getIdCliente(), vecesComprasPorCliente.getOrDefault(venta.getIdCliente(), 0) + 1);
        }

        System.out.println("\nTop 5 clientes que más compran:");
        vecesComprasPorCliente.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> {
                    String idCliente = entry.getKey();
                    int vecesCompras = entry.getValue();
                    double totalCompras = comprasPorCliente.getOrDefault(idCliente, 0.0);
                    String nombreCliente = clientes.stream()
                            .filter(c -> c.getIdCliente().equals(idCliente))
                            .findFirst()
                            .map(c -> c.getNombre())
                            .orElse("Desconocido");
                    System.out.println(idCliente + " - " + nombreCliente + ": $" + totalCompras +
                            " (Compras realizadas: " + vecesCompras + " veces)");
                });
    }

    /**
     * Genera estadísticas generales de ventas
     *
     * @param ventas lista de ventas registradas
     */
    // Reporte 3: Estadísticas de ventas
    public static void generarEstadisticasVentas(List<Venta> ventas) {
        double totalVentas = ventas.stream().mapToDouble(v -> v.getPrecioUnitario() * v.getCantidad()).sum();
        double ventaMaxima = ventas.stream().mapToDouble(v -> v.getPrecioUnitario() * v.getCantidad()).max().orElse(0);
        double ventaMinima = ventas.stream().mapToDouble(v -> v.getPrecioUnitario() * v.getCantidad()).min().orElse(0);
        double promedioVentas = totalVentas / ventas.size();

        System.out.println("\nEstadísticas de ventas:");
        System.out.println("Total de ventas: $" + totalVentas);
        System.out.println("Venta más grande: $" + ventaMaxima);
        System.out.println("Venta más pequeña: $" + ventaMinima);
        System.out.println("Promedio de ventas: $" + promedioVentas);
    }

    /**
     * Genera un archivo CSV extendido con información detallada de las ventas realizadas.
     *
     * El archivo incluirá los siguientes encabezados:
     * "idVenta", "fecha", "idCliente", "nombreCliente", "cantidadProductos", "totalVentas".
     *
     * @param ventas Lista de ventas registradas en el sistema.
     * @param clientes Lista de clientes registrados, usada para obtener el nombre del cliente.
     * @param archivoSalida Nombre del archivo CSV donde se guardará el reporte.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    // Reporte 4: CSV extendido
    public static void generarCSVExtendido(List<Venta> ventas, List<Cliente> clientes, String archivoSalida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            bw.write("idVenta,fecha,idCliente,nombreCliente,cantidadProductos,totalVentas\n");
            for (Venta venta : ventas) {
                String nombreCliente = clientes.stream()
                        .filter(c -> c.getIdCliente().equals(venta.getIdCliente()))
                        .findFirst()
                        .map(c -> c.getNombre())
                        .orElse("Desconocido");
                double totalVenta = venta.getPrecioUnitario() * venta.getCantidad();
                bw.write(venta.getIdVenta() + "," + venta.getFecha() + "," + venta.getIdCliente() + "," + nombreCliente + "," + venta.getCantidad() + "," + totalVenta + "\n");
            }
            System.out.println("\nReporte CSV extendido generado en: " + archivoSalida);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
