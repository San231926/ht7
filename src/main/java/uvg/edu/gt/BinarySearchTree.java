package uvg.edu.gt;

import java.util.function.Consumer;

/**
 * Clase que implementa un Árbol Binario de Búsqueda (BST).
 * Basado en el concepto presentado en el libro Java Structures, capítulo 12.
 *
 * @param <E> Tipo de dato almacenado en el árbol, debe ser comparable.
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private NodoBST<E> root;

    /**
     * Inserta un nuevo elemento en el árbol.
     *
     * @param data Elemento a insertar.
     */
    public void insert(E data) {
        root = insertRec(root, data);
    }

    /**
     * Método recursivo para insertar un elemento en el árbol.
     *
     * @param root Nodo actual del árbol.
     * @param data Elemento a insertar.
     * @return Nodo actualizado del árbol.
     */
    private NodoBST<E> insertRec(NodoBST<E> root, E data) {
        if (root == null) {
            return new NodoBST<>(data);
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    /**
     * Busca un elemento en el árbol.
     *
     * @param key Elemento a buscar.
     * @return El elemento encontrado o null si no está en el árbol.
     */
    public E search(E key) {
        return searchRec(root, key);
    }

    /**
     * Método recursivo para buscar un elemento en el árbol.
     *
     * @param root Nodo actual del árbol.
     * @param key Elemento a buscar.
     * @return El elemento encontrado o null si no está en el árbol.
     */
    private E searchRec(NodoBST<E> root, E key) {
        if (root == null || root.data.equals(key)) {
            return root != null ? root.data : null;
        }
        return key.compareTo(root.data) < 0 ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    /**
     * Recorre el árbol en orden ascendente y aplica una función a cada elemento.
     *
     * @param consumer Función a aplicar a cada elemento.
     */
    public void inOrder(Consumer<E> consumer) {
        inOrderRec(root, consumer);
    }

    /**
     * Método recursivo para recorrer el árbol en orden ascendente.
     *
     * @param root Nodo actual del árbol.
     * @param consumer Función a aplicar a cada elemento.
     */
    private void inOrderRec(NodoBST<E> root, Consumer<E> consumer) {
        if (root != null) {
            inOrderRec(root.left, consumer);
            consumer.accept(root.data);
            inOrderRec(root.right, consumer);
        }
    }

    /**
     * Recorre el árbol en orden descendente y aplica una función a cada elemento.
     *
     * @param consumer Función a aplicar a cada elemento.
     */
    public void inOrderDescending(Consumer<E> consumer) {
        inOrderDescendingRec(root, consumer);
    }

    /**
     * Método recursivo para recorrer el árbol en orden descendente.
     *
     * @param root Nodo actual del árbol.
     * @param consumer Función a aplicar a cada elemento.
     */
    private void inOrderDescendingRec(NodoBST<E> root, Consumer<E> consumer) {
        if (root != null) {
            inOrderDescendingRec(root.right, consumer);
            consumer.accept(root.data);
            inOrderDescendingRec(root.left, consumer);
        }
    }

    /**
     * Encuentra el elemento con el valor mínimo en el árbol.
     *
     * @return El elemento con el menor valor o null si el árbol está vacío.
     */
    public E findMin() {
        return findMinRec(root);
    }

    /**
     * Método recursivo para encontrar el elemento con el menor valor en el árbol.
     *
     * @param root Nodo actual del árbol.
     * @return El elemento con el menor valor o null si el árbol está vacío.
     */
    private E findMinRec(NodoBST<E> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.data;
        }
        return findMinRec(root.left);
    }
}
