package uvg.edu.gt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Producto> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testInsert() {
        Producto producto = new Producto("Refrigerators", "1002585046", 162.16, 162.16, "1.6-cu ft Freestanding Mini Fridge Freezer Compartment (Stainless Steel)");
        bst.insert(producto);
        assertEquals(producto, bst.search(producto));
    }

    @Test
    public void testSearch() {
        Producto producto1 = new Producto("Refrigerators", "1002585046", 162.16, 162.16, "1.6-cu ft Freestanding Mini Fridge Freezer Compartment (Stainless Steel)");
        Producto producto2 = new Producto("Refrigerators", "5002106143", 311.04, 311.04, "0.7-cu ft Freestanding Mini Fridge (Blue)");
        bst.insert(producto1);
        bst.insert(producto2);

        assertEquals(producto1, bst.search(producto1));
        assertEquals(producto2, bst.search(producto2));
        assertNull(bst.search(new Producto("Refrigerators", "9999999999", 0, 0, "Non-existent product")));
    }
}