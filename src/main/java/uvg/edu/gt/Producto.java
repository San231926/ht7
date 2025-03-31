package uvg.edu.gt;

/**
 * Clase que representa un producto en el sistema.
 * Implementa la interfaz Comparable para permitir la comparación entre productos basada en su precio actual.
 */
public class Producto implements Comparable<Producto> {
    private String category;
    private String sku;
    private double priceRetail;
    private double priceCurrent;
    private String productName;

    /**
     * Constructor de la clase Producto.
     *
     * @param category Categoría del producto.
     * @param sku Código único del producto.
     * @param priceRetail Precio original del producto.
     * @param priceCurrent Precio actual del producto.
     * @param productName Nombre del producto.
     */
    public Producto(String category, String sku, double priceRetail, double priceCurrent, String productName) {
        this.category = category;
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
    }

    /**
     * Obtiene el SKU del producto.
     *
     * @return Código SKU del producto.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Obtiene el precio original del producto.
     *
     * @return Precio original del producto convertido a entero.
     */
    public int getPriceRetail() {
        return (int) priceRetail;
    }

    /**
     * Obtiene el precio actual del producto.
     *
     * @return Precio actual del producto convertido a entero.
     */
    public int getPriceCurrent() {
        return (int) priceCurrent;
    }

    /**
     * Compara este producto con otro basado en el precio actual.
     *
     * @param other Producto con el que se va a comparar.
     * @return Un valor negativo si este producto es más barato,
     *         un valor positivo si es más caro y 0 si tienen el mismo precio.
     */
    @Override
    public int compareTo(Producto other) {
        return Double.compare(this.priceCurrent, other.priceCurrent);
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return Cadena con la información del producto.
     */
    @Override
    public String toString() {
        return "SKU: " + sku + ", Nombre: " + productName + ", Categoría: " + category + ", Precio Retail: " + priceRetail + ", Precio Actual: " + priceCurrent;
    }
}
