package uvg.edu.gt;

import java.io.*;
import java.util.List;

/**
 * Clase para cargar datos desde un archivo CSV y almacenarlos en una lista.
 */
public class CSVLoader {
    /**
     * Carga los productos desde un archivo CSV y los inserta en una lista.
     * @param filePath Ruta del archivo CSV.
     * @param productList Lista donde se almacenarán los productos.
     */
    public static void loadCSV(String filePath, List<Producto> productList) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Omitir la primera línea de encabezado
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Saltar líneas vacías
                }
                String[] values = line.split(";");
                if (values.length == 5) {
                    String category = values[0];
                    String sku = values[1];

                    double priceRetail, priceCurrent;
                    if (values[2].isEmpty() || values[3].isEmpty()) {
                        continue;
                    }else{
                        priceRetail = Double.parseDouble(values[2]);
                        priceCurrent = Double.parseDouble(values[3]);}


                    String productName = values[4];
                    Producto producto = new Producto(category, sku, priceRetail, priceCurrent, productName);
                    productList.add(producto);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}