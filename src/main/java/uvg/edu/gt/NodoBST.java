package uvg.edu.gt;

/**
 * Clase que representa un Nodo dentro de un Árbol Binario de Búsqueda (BST).
 * @param <E> Tipo genérico que extiende Comparable.
 */
public class NodoBST<E extends Comparable<E>> {
    E data;
    NodoBST<E> left, right;

    /**
     * Constructor de un nodo del BST.
     * @param data Dato almacenado en el nodo.
     */
    public NodoBST(E data) {
        this.data = data;
        this.left = this.right = null;
    }
}
