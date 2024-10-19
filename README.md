# Binary Search Tree

En este taller, se desarrolló un árbol binario de búsqueda (Binary Search Tree) utilizando tipos genéricos en Java, y implementando los metodos de colletions para que fueran compatibles con el, utilizando la recursividad. 

## Implementación de metodos

1. **insert(T value)**
    - **Descripción**: Inserta un nuevo valor en el árbol.
    - **Funcionamiento**: Llama a un método recursivo que ubica la posición adecuada en el árbol para el nuevo nodo.

2. **search(T value)**
    - **Descripción**: Busca un valor en el árbol.
    - **Funcionamiento**: Llama a un método recursivo que compara el valor buscado con los nodos del árbol, regresando el nodo correspondiente si lo encuentra.

3. **delete(T value)**
    - **Descripción**: Elimina un nodo con un valor específico del árbol.
    - **Funcionamiento**: Busca el nodo y luego lo elimina, manejando los casos en que el nodo tiene cero, uno o dos hijos.

4. **inOrderTraversal()**
    - **Descripción**: Realiza un recorrido en orden del árbol.
    - **Funcionamiento**: Visita el subárbol izquierdo, luego el nodo actual, y finalmente el subárbol derecho recursivamente.

5. **preOrderTraversal()**
    - **Descripción**: Realiza un recorrido en preorden del árbol.
    - **Funcionamiento**: Visita el nodo actual antes de sus subárboles izquierdo y derecho.

6. **postOrderTraversal()**
    - **Descripción**: Realiza un recorrido en postorden del árbol.
    - **Funcionamiento**: Visita los subárboles izquierdo y derecho antes de visitar el nodo actual.

7. **levelOrderTraversal()**
    - **Descripción**: Realiza un recorrido por niveles del árbol.
    - **Funcionamiento**: Utiliza una cola para visitar todos los nodos en cada nivel.

8. **altura()**
    - **Descripción**: Calcula la altura del árbol.
    - **Funcionamiento**: retorna la maxima altura entre el nodo derecho o izquierdo.

9. **isBalanced()**
    - **Descripción**: Verifica si el árbol está balanceado.
    - **Funcionamiento**: Comprueba la diferencia de alturas entre subárboles y retorna si el árbol cumple con la propiedad de balance es decir tienen la misma altura.

10. **countNodes()**
    - **Descripción**: Cuenta el número de nodos en el árbol.
    - **Funcionamiento**: Realiza un recorrido recursivo y suma 1 por cada nodo encontrado.

11. **toArray()**
    - **Descripción**: Convierte el árbol en un array.
    - **Funcionamiento**: Llena una lista con los valores del árbol y luego los convierte a un array.

12. **toArray(T[] a)**
    - **Descripción**: Convierte el árbol en un array del tipo especificado.
    - **Funcionamiento**: Llena un array existente o crea uno nuevo según sea necesario.

13. **contains(Object o)**
    - **Descripción**: Verifica si un elemento está presente en el árbol.
    - **Funcionamiento**: Llama a `search()` para determinar si el valor existe.

14. **size()**
    - **Descripción**: Retorna el número de elementos en el árbol.
    - **Funcionamiento**: Puede usar `countNodes()` para calcular el tamaño del árbol.

15. **add(T t)**
    - **Descripción**: Agrega un nuevo elemento al árbol.
    - **Funcionamiento**: Llama al método `insert()` para añadir el elemento.

16. **remove(Object o)**
    - **Descripción**: Elimina un elemento del árbol.
    - **Funcionamiento**: Utiliza `delete()` para eliminar el nodo correspondiente.

17. **iterator()**
    - **Descripción**: Proporciona un iterador para recorrer los elementos del árbol.
    - **Funcionamiento**: Devuelve un iterador que puede usar el recorrido por levelordertrasversal o mejor dicho por niveles. 

18. **retainAll(Collection<?> c)**
    - **Descripción**: Modifica el árbol para mantener solo los elementos presentes en la colección especificada.
    - **Funcionamiento**: Elimina los elementos que no están en la colección dada.

19. **containsAll(Collection<?> c)**
    - **Descripción**: Verifica si el árbol contiene todos los elementos de la colección especificada.
    - **Funcionamiento**: Revisa cada elemento de la colección y verifica su existencia en el árbol.

20. **addAll(Collection<? extends T> c)**
    - **Descripción**: Agrega todos los elementos de la colección al árbol.
    - **Funcionamiento**: Itera sobre la colección y llama a `add()` para cada elemento.

21. **removeAll(Collection<?> c)**
    - **Descripción**: Elimina todos los elementos de la colección especificada del árbol.
    - **Funcionamiento**: Itera sobre la colección y llama a `remove()` para cada elemento.

22. **retainAll(Collection<?> c)**
    - **Descripción**: Mantiene solo los elementos que están en la colección proporcionada.
    - **Funcionamiento**: Identifica y elimina los elementos que no están presentes en la colección.

23. **clear**
    - **Descripción**: Elimina los nodos 
    - **Funcionamiento**: Es curioso, al establecer la raíz del árbol en null, se eliminan todas las referencias a los nodos que formaban parte del arbol. 

## Empezando

### Requisitos Previos
Para ejecutar este proyecto, necesitarás tener instalado:

- Java JDK 17.
- Un IDE de Java como IntelliJ IDEA, Eclipse, o NetBeans.
- Maven para manejar las dependencias preferiblemente la version 3.9.4
- Un navegador web para interactuar con el servidor.

### Instalación

1. Tener instalado Git en tu máquina local
2. Elegir una carpeta en donde guardes tu proyecto
3. abrir la terminal de GIT --> mediante el click derecho seleccionas Git bash here
4. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/Medina95/Ejercicio-.git
   ```
5. ejecuta la clase BinarySearchTree

## Comentarios
Siendo sincera yo no acabe en la clase puedes ver mis commits y calificarme lo que tenia honestamente, implementar los metodos del collection, recordar el arbol y la recursividad me tomo su tiempo sin embargo queria terminarlo.  




