public class Node<T> {
    T value;
    Node<T> next;

    public Node() {}

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this(value);
        this.next = next;
    }
}
