package uvg.edu.gt;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Clase principal que gestiona la interfaz de usuario para la búsqueda y listado de productos.
 */
public class Main {
    private static List<Producto> allProducts = new ArrayList<>();
    private static List<Producto> filteredProducts;

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Cargar datos desde el CSV
        System.out.println("Cargando datos desde CSV...");
        CSVLoader.loadCSV("src//main//java//uvg//edu//gt//productos.csv", allProducts);

        System.out.println("Se han cargado " + allProducts.size() + " productos.");

        // Interfaz de usuario
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Buscar productos por SKU");
            System.out.println("2. Listar productos ordenados por precio (ascendente)");
            System.out.println("3. Listar productos ordenados por precio (descendente)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    searchProductsBySku(scanner);
                    break;
                case 2:
                    listProductsByPrice(true);
                    break;
                case 3:
                    listProductsByPrice(false);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
        System.out.println("¡Gracias por usar el sistema!");
    }

    /**
     * Busca productos en la lista por su SKU y los almacena en una lista filtrada.
     *
     * @param scanner Scanner para capturar la entrada del usuario.
     */
    private static void searchProductsBySku(Scanner scanner) {
        System.out.print("Ingrese el SKU del producto: ");
        String sku = scanner.nextLine();

        // Filtrar productos por SKU
        filteredProducts = allProducts.stream()
                .filter(product -> product.getSku().equals(sku))
                .collect(Collectors.toList());

        if (!filteredProducts.isEmpty()) {
            System.out.println("Se encontraron " + filteredProducts.size() + " productos con el SKU: " + sku);

            // Crear un BinarySearchTree a partir de los productos filtrados
            BinarySearchTree<Producto> bst = new BinarySearchTree<>();
            for (Producto product : filteredProducts) {
                bst.insert(product);
            }

            // Encontrar y mostrar el producto con el menor precio
            Producto minProduct = bst.findMin();
            System.out.println("Producto con el menor precio: " + minProduct);
        } else {
            System.out.println("No se encontró ningún producto con el SKU: " + sku);
        }
    }

    /**
     * Lista los productos filtrados ordenados por precio, ya sea de manera ascendente o descendente.
     *
     * @param ascending Indica si el orden debe ser ascendente (true) o descendente (false).
     */
    private static void listProductsByPrice(boolean ascending) {
        if (filteredProducts == null || filteredProducts.isEmpty()) {
            System.out.println("Primero busque los productos por SKU utilizando la opción 1.");
            return;
        }

        BinarySearchTree<Producto> bst = new BinarySearchTree<>();
        for (Producto product : filteredProducts) {
            bst.insert(product);
        }

        System.out.println("\nListado de productos (precio " + (ascending ? "ascendente" : "descendente") + "):");
        if (ascending) {
            bst.inOrder(Main::displayProduct);
        } else {
            bst.inOrderDescending(Main::displayProduct);
        }
    }

    /**
     * Muestra la información de un producto en la consola.
     *
     * @param product Producto a mostrar.
     */
    private static void displayProduct(Producto product) {
        System.out.println(product);
    }
}
