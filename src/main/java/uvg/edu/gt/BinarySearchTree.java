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
     * Busca un elemento en el árbol por su clave.
     *
     * @param key Clave del elemento a buscar.
     * @return El elemento encontrado o null si no está en el árbol.
     */
    public E search(String key) {
        return searchRec(root, key);
    }

    /**
     * Método recursivo para buscar un elemento en el árbol por su clave.
     *
     * @param root Nodo actual del árbol.
     * @param key Clave del elemento a buscar.
     * @return El elemento encontrado o null si no está en el árbol.
     */
    private E searchRec(NodoBST<E> root, String key) {
        if (root == null) {
            return null;
        }
        Producto producto = (Producto) root.data;
        if (producto.getSku().equals(key)) {
            return root.data;
        }
        if (key.compareTo(producto.getSku()) < 0) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
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
     * Devuelve el número de nodos en el árbol.
     *
     * @return El tamaño del árbol.
     */
    public int size() {
        return sizeRec(root);
    }

    /**
     * Método recursivo para contar el número de nodos en el árbol.
     *
     * @param node Nodo actual del árbol.
     * @return El número de nodos en el árbol.
     */
    private int sizeRec(NodoBST<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRec(node.left) + sizeRec(node.right);
    }
}






