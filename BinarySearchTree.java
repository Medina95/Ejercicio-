import java.util.*;

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

    private T maxvalue(Nodo<T> nodo) {
        T maxvalue = nodo.value;
        while (nodo.right != null) {
            maxvalue = nodo.right.value;
            nodo = nodo.right;
        }
        return maxvalue;
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


    public int altura() {
        return alturaRec(root);
    }

    private int alturaRec(Nodo<T> nodo) {

        if (nodo == null) {
            return 0; // La altura de un nodo nulo es 0
        }
        return 1 + Math.max(alturaRec(nodo.left), alturaRec(nodo.right));
    }




    public boolean isBalanced() {

        return isBalancedRec(root) != -1;
    }

    private int isBalancedRec(Nodo<T> nodo) {
        if (nodo == null) {
            return 0; // La altura de un nodo nulo es 0
        }

        // Calcular la altura de los subárboles
        int alturaIzquierda = isBalancedRec(nodo.left);
        int alturaDerecha = isBalancedRec(nodo.right);

        // Verificar la diferencia de alturas
        if (Math.abs(alturaIzquierda - alturaDerecha) > 1) {
            return -1; // Desbalanceado
        }
        // Retornar la altura del nodo actual
        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Nodo<T> nodo) {
        if (nodo == null) {
            return 0; // Si el nodo es nulo, no hay nodos que contar
        }
        // Sumar 1 (el nodo actual) más la cantidad de nodos en los subárboles izquierdo y derecho
        return 1 + countNodesRec(nodo.left) + countNodesRec(nodo.right);
    }



    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<Nodo<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodo<T> current = queue.poll(); // Obtener el nodo en la parte frontal de la cola
            System.out.print(current.value + " "); // Visitar el nodo

            // Añadir los hijos del nodo actual a la cola
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println(); // Para un salto de línea después de imprimir todos los nodos
    }



    @Override
    public Object[] toArray() {
        List<Object> list = new ArrayList<>();
        toArrayRec(root, list); // Llenar la lista
        return list.toArray(); // Convertir la lista en un array y retornarlo
    }

    private void toArrayRec(Nodo<T> nodo, List<Object> list) {
        if (nodo != null) {
            toArrayRec(nodo.left, list); // Recorrer el subárbol izquierdo
            list.add(nodo.value); // Añadir el valor del nodo a la lista
            toArrayRec(nodo.right, list); // Recorrer el subárbol derecho
        }
    }
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) { // Verificar si cada elemento está en el árbol
                return false;
            }
        }
        return true; // Todos los elementos están en el árbol
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) { // Utilizar el método insert
                modified = true; // Si se insertó un nuevo elemento
            }
        }
        return modified; // Retornar true si se modificó el árbol
    }

    // modificar la colección de tal manera que solo queden los elementos que están presentes en la colección y elimina los demas
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove((T) element)) { // Utilizar el método delete
                modified = true; // Si se eliminó un elemento
            }
        }
        return modified; // Retornar true si se modificó el árbol
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        List<T> toRemove = new ArrayList<>();

        // Encontrar todos los elementos que no están en la colección c
        for (Object element : toArray()) {
            if (!c.contains(element)) {
                toRemove.add((T) element); // Añadir a la lista de eliminación
            }
        }

        // Eliminar los elementos que no están en la colección c
        for (T element : toRemove) {
            if (remove(element)) { // Utilizar el método delete
                modified = true; // Si se eliminó un elemento
            }
        }
        return modified; // Retornar true si se modificó el árbol
    }

    //esta vacio ¿?

    public boolean isEmpty() {
        return root == null;
    }
    //eliminar
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false; // No se puede eliminar un valor nulo
        }
        @SuppressWarnings("unchecked")
        T value = (T) o; // Convertir el objeto a tipo T
        if (search(value) != null) {
            delete(value);
            return true;
        }
        return false; // no se pudo eliminar xd
    }
    // insertar
    @Override
    public boolean add(T t) {
        if (t == null) {
            throw new NullPointerException("No se puede añadir un valor nulo."); // Manejo de valores nulos
        }
        insert(t);
        return true;
    }

    // numero de nodos
    @Override
    public int size() {
        return countNodes();
    }

    // eliminar
    @Override
    public void clear() {
        root = null;
    }


    //verificar qeu dconitene un objeto

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false; // No se puede buscar un valor nulo
        }
        @SuppressWarnings("unchecked")
        T value = (T) o; // Convierte el objeto a tipo T
        return search(value) != null; // Retorna true si el valor se encuentra
    }

    //definir un iterador en este caso  para organizar por nivels
    @Override
    public Iterator<T> iterator() {
        return new LevelOrderIterator(); // Retornar una nueva instancia del iterador
    }
    private class LevelOrderIterator implements Iterator<T> {
        private Queue<Nodo<T>> queue = new LinkedList<>();

        public LevelOrderIterator() {
            if (root != null) {
                queue.add(root); // Añadir la raíz a la cola
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty(); // Verificar si hay más elementos
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException(); // Lanza excepción si no hay más elementos
            }
            Nodo<T> current = queue.poll(); // Obtener el nodo en la parte frontal de la cola

            // Añadir los hijos del nodo actual a la cola
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }

            return current.value; // Retornar el valor del nodo actual
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
        System.out.print("Recorrido en orden: ");
        bst.inOrderTraversal(); // 3 5 7 10 12 15 18
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
        bst.remove(10);
        bst.remove(500); // Intenta eliminar un nodo que no existe

        System.out.print("Recorrido en orden después de eliminar 10: ");
        bst.inOrderTraversal(); // 3 5 7 12 15 18

        // 4) Recorridos
        System.out.print("Recorrido en orden: ");
        bst.inOrderTraversal(); // 3 5 7 10 12 15 18

        System.out.print("Recorrido en preorder: ");
        bst.preOrderTraversal(); // 10 5 3 7 15 12 18

        System.out.print("Recorrido en postorder: ");
        bst.postOrderTraversal(); // 3 7 5 12 18 15 10

        // 5)  minimo
        Integer minValue = bst.minValue(bst.root);
        System.out.println("El mínimo es: " + minValue);
        //6) Maximo
        Integer maxValue = bst.maxvalue(bst.root);
        System.out.println("El máximo es: " + maxValue);
        // 7 altura
        System.out.println("La altura del árbol es: " + bst.altura());
        // 8 es baklanceado
        boolean balanced = bst.isBalanced();
        System.out.println("El árbol está balanceado: " + balanced);
        // 9
        System.out.print("Recorrido por nivel: ");
        bst.levelOrderTraversal();
        //11 contar nodos
        int totalNodos = bst.size();
        System.out.println("Total de nodos en el árbol: " + totalNodos);
        //10 eliminar todos los nodos
        bst.clear();
        int totalNodos1 = bst.size();
        System.out.println("Total de nodos en el árbol después de clear: " + totalNodos1);



        // utilizando las funciones de collection modificadas
        System.out.println("-----------------------------------------------------------------");
        System.out.println("El árbol está vacío: " + bst.isEmpty());
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(12);
        bst.add(18);
        bst.remove(10);
        System.out.println("¿Contiene 7? " + bst.contains(7));
        System.out.println("utilizando el iterador");
        Iterator<Integer> iterator = bst.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // Imprime los elementos en orden por niveles

        }
        System.out.println(); // Salto de línea
        Object[] array = bst.toArray();
        System.out.print("Array de elementos: ");
        for (Object obj : array) {
            System.out.print(obj + " "); // Imprimir cada elemento del array
        }
        System.out.println(); // Salto de línea
        List<Integer> collection = new ArrayList<>(Arrays.asList(5, 10, 20));
        System.out.print("Array de elementos de la collection que se va a trabajar: ");
        for (Object obj : collection) {
            System.out.print(obj + " "); // Imprimir cada elemento del array
        }
        System.out.println();
        System.out.println("¿El arbol contiene esos elementos? " + bst.containsAll(collection)); // Debería ser false
        bst.addAll(collection);
        System.out.println("Array después de añadir: " + Arrays.toString(bst.toArray()));
        bst.removeAll(collection);
        System.out.println("Array después de eliminar: " + Arrays.toString(bst.toArray()));

        bst.add(10); // Reinsertar el elemento que tiene de la collecion
        bst.add(5);
        bst.retainAll(collection);
        System.out.println("Array después de retener: " + Arrays.toString(bst.toArray()));

    }
}
