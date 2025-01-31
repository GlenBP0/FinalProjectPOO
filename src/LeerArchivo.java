import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para cargar datos desde archivos JSON y CSV.
 *
 * @author Elvis Marcillo
 * @version POO - 2024-2025 C2
 * @since 29-ene-2025, 19:00 horas
 */
public class LeerArchivo {

    /**
     * Carga una lista de productos desde un archivo JSON.
     *
     * @param ruta Ruta del archivo JSON a leer.
     * @return Lista de productos cargados desde el archivo.
     *         Retorna {@code null} si ocurre un error en la lectura.
     */
    public static List<Producto> cargarProductos(String ruta){
        ObjectMapper mapper = new ObjectMapper();
        List<Producto>productos=null;
        try {
            productos= mapper.readValue(new File(ruta),new TypeReference<List<Producto>>(){});
            System.out.println("archivo json cargado con exito");
        }catch (IOException e){
            System.out.println("error al leer json: "+e.getMessage());
        }
        return productos;

    }

    /**
     * Carga una lista de ventas desde un archivo CSV.
     *
     * @param ruta Ruta del archivo CSV a leer.
     * @return Lista de ventas cargadas desde el archivo.
     *         Retorna una lista vacía si ocurre un error en la lectura.
     */
    public static List<Venta> cargarVentas(String ruta){
        List<Venta> ventas= new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(ruta))){

            String[] linea ;
            reader.readNext();
            while ((linea=reader.readNext()) !=null){
                ventas.add(new Venta(
                        linea[0],
                        linea[1],
                        linea[2],
                        linea[3],
                        Integer.parseInt(linea[4]),
                        Double.parseDouble(linea[5]),
                        linea[6]
                ));
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("error: " +e.getMessage());

        }
        return ventas;
    }

    /**
     * Carga una lista de clientes desde un archivo CSV.
     *
     * @param ruta Ruta del archivo CSV a leer.
     * @return Lista de clientes cargados desde el archivo.
     *         Retorna una lista vacía si ocurre un error en la lectura.
     */
    public static List<Cliente>cargarClientes(String ruta){
        List<Cliente> clientes= new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(ruta))){
            String[]linea;
            reader.readNext();
            while ((linea=reader.readNext()) !=null){
                clientes.add(new Cliente(
                        linea[0],
                        linea[1],
                        linea[2],
                        linea[3],
                        linea[4]
                ));
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("error: "+ e.getMessage());
        }

        return clientes;
    }
}
