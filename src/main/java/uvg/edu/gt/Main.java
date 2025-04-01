package uvg.edu.gt;

import java.util.Scanner;

/**
 * Clase principal que gestiona la interfaz de usuario para la búsqueda y listado de productos.
 */
public class Main {
    private static BinarySearchTree<Producto> productTree = new BinarySearchTree<>();

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Cargar datos desde el CSV
        System.out.println("Cargando datos desde CSV...");
        CSVLoader.loadCSV("src//main//java//uvg//edu//gt//productos.csv", productTree);

        System.out.println("Se han cargado " + productTree.size() + " productos.");

        // Interfaz de usuario
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Buscar productos por SKU");
            System.out.println("2. Listar productos ordenados por SKU (ascendente)");
            System.out.println("3. Listar productos ordenados por SKU (descendente)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    searchProductsBySku(scanner);
                    break;
                case 2:
                    listProductsBySku(true);
                    break;
                case 3:
                    listProductsBySku(false);
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
     * Busca un producto en el árbol por su SKU.
     *
     * @param scanner Scanner para capturar la entrada del usuario.
     */
    private static void searchProductsBySku(Scanner scanner) {
        System.out.print("Ingrese el SKU del producto: ");
        String sku = scanner.nextLine();

        Producto encontrado = productTree.search(sku);

        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró ningún producto con el SKU: " + sku);
        }
    }

    /**
     * Lista los productos ordenados por SKU, ya sea de manera ascendente o descendente.
     *
     * @param ascending Indica si el orden debe ser ascendente (true) o descendente (false).
     */
    private static void listProductsBySku(boolean ascending) {
        System.out.println("\nListado de productos (SKU " + (ascending ? "ascendente" : "descendente") + "):");
        if (ascending) {
            productTree.inOrder(Main::displayProduct);
        } else {
            productTree.inOrderDescending(Main::displayProduct);
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