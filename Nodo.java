
class Nodo<T> {
    T value;
    Nodo<T> left;
    Nodo<T> right;

    Nodo(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}