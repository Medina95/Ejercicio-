import java.util.Collection;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Collection<T> {
    private Nodo<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Método para insertar un valor en el árbol
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Nodo<T> insertRec(Nodo<T> nodo, T value) {
        if (nodo == null) {
            return new Nodo<>(value);
        }
        if (value.compareTo(nodo.value) < 0) {
            nodo.left = insertRec(nodo.left, value);
        } else if (value.compareTo(nodo.value) > 0) {
            nodo.right = insertRec(nodo.right, value);
        }
        return nodo;
    }

    // Método para buscar un nodo en el árbol
    public Nodo<T> search(T value) {
        return searchRec(root, value);
    }

    private Nodo<T> searchRec(Nodo<T> nodo, T value) {
        if (nodo == null) {
            return null; // Valor no encontrado
        }
        if (value.equals(nodo.value)) {
            return nodo; // Valor encontrado, retornamos el nodo
        }

        // Comparar y buscar en el subárbol correspondiente
        if (value.compareTo(nodo.value) < 0) {
            return searchRec(nodo.left, value); // Buscar en el subárbol izquierdo
        } else {
            return searchRec(nodo.right, value); // Buscar en el subárbol derecho
        }
    }

    // Método para eliminar un valor del árbol
    public void delete(T value) {
        Nodo<T> nodoToDelete = search(value);
        if (nodoToDelete != null) {
            root = deleteRec(root, value);
        } else {
            System.out.println("Valor no encontrado para eliminar: " + value);
        }
    }

    private Nodo<T> deleteRec(Nodo<T> nodo, T value) {
        // Caso base: si el nodo actual es nulo, simplemente retornamos nulo
        if (nodo == null) {
            return null;
        }

        // Comparación para determinar en qué subárbol buscar
        if (value.compareTo(nodo.value) < 0) {
            nodo.left = deleteRec(nodo.left, value);
        } else if (value.compareTo(nodo.value) > 0) {
            nodo.right = deleteRec(nodo.right, value);
        } else {
            // Nodo encontrado (el nodo que queremos eliminar)

            // Caso 1: Si el nodo no tiene hijo izquierdo y derecho (ambos nulos)
            if (nodo.left == null && nodo.right == null) {
                return null; // Retornamos nulo, eliminando el nodo
            }
            // Caso 2: Si el nodo no tiene hijo izquierdo
            if (nodo.left == null) {
                return nodo.right; // Retornamos el hijo derecho (o nulo si no existe)
            }
            // Caso 3: Si el nodo no tiene hijo derecho
            if (nodo.right == null) {
                return nodo.left; // Retornamos el hijo izquierdo (o nulo si no existe)
            }

            // Caso 4: Si el nodo tiene dos hijos
            nodo.value = minValue(nodo.right);
            nodo.right = deleteRec(nodo.right, nodo.value);
        }

        return nodo; // Retornamos el nodo actualizado
    }

    private T minValue(Nodo<T> nodo) {
        T minValue = nodo.value;
        while (nodo.left != null) {
            minValue = nodo.left.value;
            nodo = nodo.left;
        }
        return minValue;
    }

    // Método para recorrer el árbol en orden
    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Nodo<T> nodo) {
        if (nodo != null) {
            inOrder(nodo.left);
            System.out.print(nodo.value + " ");
            inOrder(nodo.right);
        }
    }

    // Método para recorrer el árbol en preorder
    public void preOrderTraversal() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.value + " "); // Visitar nodo
            preOrderRec(nodo.left);  // Visitar subárbol izquierdo
            preOrderRec(nodo.right); // Visitar subárbol derecho
        }
    }

    // Método para recorrer el árbol en postorder
    public void postOrderTraversal() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Nodo<T> nodo) {
        if (nodo != null) {
            postOrder(nodo.left);  // Visitar subárbol izquierdo
            postOrder(nodo.right); // Visitar subárbol derecho
            System.out.print(nodo.value + " "); // Visitar nodo
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // 1) Insertar
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        // 2) Búsqueda
        Nodo<Integer> foundNodo = bst.search(7);
        if (foundNodo != null) {
            System.out.println("Encontrado: " + foundNodo.value);
        } else {
            System.out.println("Valor no encontrado.");
        }

        foundNodo = bst.search(8);
        if (foundNodo != null) {
            System.out.println("Encontrado: " + foundNodo.value);
        } else {
            System.out.println("No se encontró el valor");
        }

        // 3) Eliminar un nodo
        bst.delete(10);
        bst.delete(500); // Intenta eliminar un nodo que no existe

        System.out.print("Recorrido en orden después de eliminar 10: ");
        bst.inOrderTraversal(); // 3 5 7 12 15 18

        // 4) Recorridos
        System.out.print("Recorrido en orden: ");
        bst.inOrderTraversal(); // 3 5 7 10 12 15 18

        System.out.print("Recorrido en preorder: ");
        bst.preOrderTraversal(); // 10 5 3 7 15 12 18

        System.out.print("Recorrido en postorder: ");
        bst.postOrderTraversal(); // 3 7 5 12 18 15 10
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}